package com.lody.plugin.api;

import com.lody.plugin.bean.LPlugin;

/**
 * Created by lody  on 2015/4/3.
 */
public class LPluginError {
    public Throwable error;
    public long errorTime;
    public Thread errorThread;
    public LPlugin errorPlugin;
    public int processId;
}
