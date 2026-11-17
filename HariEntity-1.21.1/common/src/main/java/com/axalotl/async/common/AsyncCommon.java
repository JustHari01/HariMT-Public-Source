package com.axalotl.async.common;

import com.axalotl.async.common.platform.PlatformUtils;

public abstract class AsyncCommon {
    public static final String MODID = "harimt";

    public final void initialize() {
        PlatformUtils.initialize();
    }
}
