package com.axalotl.async.common.utils;

import com.axalotl.async.common.config.AsyncConfig;
import net.minecraft.world.entity.EntityType;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

/**
 * Moves an entity type back to synchronous ticking after repeated async tick failures.
 */
public final class EntityTickCircuitBreaker {
    private static final int FAILURE_THRESHOLD = 3;
    private static final long RECOVERY_TIMEOUT_MS = 30_000L;
    private static final int HALF_OPEN_SUCCESS_THRESHOLD = 5;

    public enum State {
        CLOSED,
        OPEN,
        HALF_OPEN
    }

    private static final class CircuitState {
        private final AtomicInteger failureCount = new AtomicInteger();
        private final AtomicInteger halfOpenSuccessCount = new AtomicInteger();
        private final AtomicReference<State> state = new AtomicReference<>(State.CLOSED);
        private final AtomicLong openedAt = new AtomicLong();
    }

    private final ConcurrentHashMap<EntityType<?>, CircuitState> states = new ConcurrentHashMap<>();

    public boolean shouldTickAsync(EntityType<?> type) {
        CircuitState circuit = states.computeIfAbsent(type, ignoredType -> new CircuitState());
        State current = circuit.state.get();

        if (current == State.CLOSED || current == State.HALF_OPEN) {
            return true;
        }

        long elapsed = System.currentTimeMillis() - circuit.openedAt.get();
        if (elapsed < RECOVERY_TIMEOUT_MS) {
            return false;
        }

        if (circuit.state.compareAndSet(State.OPEN, State.HALF_OPEN)) {
            circuit.halfOpenSuccessCount.set(0);
            AsyncConfig.LOGGER.info("Circuit breaker for {} entering HALF_OPEN", EntityType.getKey(type));
            return true;
        }
        return circuit.state.get() == State.HALF_OPEN;
    }

    public void recordSuccess(EntityType<?> type) {
        CircuitState circuit = states.get(type);
        if (circuit == null || circuit.state.get() != State.HALF_OPEN) {
            return;
        }

        if (circuit.halfOpenSuccessCount.incrementAndGet() >= HALF_OPEN_SUCCESS_THRESHOLD
                && circuit.state.compareAndSet(State.HALF_OPEN, State.CLOSED)) {
            circuit.failureCount.set(0);
            AsyncConfig.LOGGER.info("Circuit breaker for {} CLOSED after successful recovery", EntityType.getKey(type));
        }
    }

    public void recordFailure(EntityType<?> type, Throwable cause) {
        CircuitState circuit = states.computeIfAbsent(type, ignoredType -> new CircuitState());
        State current = circuit.state.get();

        if (current == State.HALF_OPEN) {
            if (circuit.state.compareAndSet(State.HALF_OPEN, State.OPEN)) {
                circuit.openedAt.set(System.currentTimeMillis());
                AsyncConfig.LOGGER.warn("Circuit breaker for {} reopened after a half-open failure: {}",
                        EntityType.getKey(type), cause.getMessage());
            }
            return;
        }

        if (current == State.CLOSED && circuit.failureCount.incrementAndGet() >= FAILURE_THRESHOLD
                && circuit.state.compareAndSet(State.CLOSED, State.OPEN)) {
            circuit.openedAt.set(System.currentTimeMillis());
            AsyncConfig.LOGGER.warn("Circuit breaker for {} opened after {} async tick failures; using server-thread ticks: {}",
                    EntityType.getKey(type), FAILURE_THRESHOLD, cause.getMessage());
        }
    }

    public void reset() {
        states.clear();
    }
}
