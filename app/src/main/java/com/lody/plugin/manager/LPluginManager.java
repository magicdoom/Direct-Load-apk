package com.lody.plugin.manager;

import android.app.Activity;

import com.lody.plugin.bean.LPlugin;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by lody  on 2015/3/27.
 */
public class LPluginManager{

    private static final Map<String,LPlugin> pluginsMapForPath = new ConcurrentHashMap<String, LPlugin>();
    public static String finalApkPath;

    /**
     * 先从缓存中读取Plugin，如果缓存中没有找到，尝试创建Plugin
     * @param proxyParent
     * @param apkPath
     * @return
     */
    public static LPlugin loadPlugin(Activity proxyParent,String apkPath){
        finalApkPath = apkPath;
        LPlugin plugin = null;
        plugin = pluginsMapForPath.get(apkPath);
        if(plugin == null){
            plugin = new LPlugin(proxyParent,apkPath);
        }
        pluginsMapForPath.put(apkPath,plugin);
        return plugin;
    }

    /**
     * 得到一个已经加载的Plugin,可能返回null
     * @return
     */
    public static LPlugin getLoadedPlugin(String apkPath){
        finalApkPath = apkPath;

        return pluginsMapForPath.get(apkPath);
    }

}
