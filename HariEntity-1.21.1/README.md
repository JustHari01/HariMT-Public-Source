# HariEntity (UNOFFICIAL) — Minecraft 1.21.1

Unofficial Fabric and NeoForge 1.21.1 port of HariEntity, the user's 1.20.1 fork of Async. This project is not affiliated with or endorsed by the Async authors.

## What it includes

- Parallel entity processing using the 1.21.1 Async engine.
- The 1.21.1 engine's spatial work grouping and Sable compatibility handling.
- Configurable worker count, synchronous entity list, asynchronous spawning, and experimental asynchronous random ticks.
- A circuit breaker that moves an entity type to server-thread ticking after repeated asynchronous tick exceptions, then retries it after a recovery interval.
- Safety defaults for TNT, dropped items, experience orbs, creepers, withers, end crystals, ghasts, and selected mod namespaces.

The 1.20.1 HariMT 2.0 branch also contains experimental GPU collision code and additional worker scheduling controls. They have not been ported to this 1.21.1 branch because the 1.21.1 engine uses a different scheduling architecture. This release does not claim feature parity with HariMT 2.0.

## Compatibility

- Minecraft Java Edition 1.21.1
- Fabric Loader with Fabric API, or NeoForge 21.1.x
- Java 21

The mod is experimental. A successful build does not establish compatibility with every modpack or client rendering setup. Keep a world backup before trying it.

## Configuration

The common configuration includes:

- `disabled`: run entity processing on the server thread.
- `maxThreads`: worker count; `-1` selects automatic sizing.
- `enableCircuitBreaker`: enable per-entity-type recovery after repeated asynchronous tick failures.
- `enableAsyncSpawn`: enable asynchronous entity spawning.
- `enableAsyncRandomTicks`: enable experimental asynchronous random ticks.
- `synchronizedEntities`: entity IDs or namespaces to keep on the server thread.

Fabric stores this in `config/harimt.toml`; NeoForge stores it in `config/harimt.toml`.

## Attribution and license

This port uses code from [Async](https://github.com/AxalotLDev/Async), by AxalotL, Alchemy, Bliss, FurryMileon, Grider, and jediminer543. The source was adapted from upstream commit `a403c6ffe69b903530f671f3313c17b55ef1b1d8` on the Minecraft 1.21.1 branch. HariMT's 1.20.1 circuit-breaker behavior and entity safety defaults were also adapted for this port.

The complete source is distributed under GPL-3.0-only. See [LICENSE](LICENSE). Original project: [Async](https://modrinth.com/mod/async). HariMT source: [JustHari01/HariMT-Public-Source](https://github.com/JustHari01/HariMT-Public-Source).

## AI assistance disclosure

AI assistance was used to inspect the source differences, adapt the circuit breaker and metadata for Minecraft 1.21.1, and prepare this documentation.
