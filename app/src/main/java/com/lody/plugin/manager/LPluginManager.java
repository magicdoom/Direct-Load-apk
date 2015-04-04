package com.lody.plugin.manager;

import android.app.Activity;

import com.lody.plugin.bean.LPlugin;

/**
 * Created by lody  on 2015/3/27.
 */
public class LPluginManager{

    //private static final Map<String,LPlugin> pluginsMapForPath = new ConcurrentHashMap<String, LPlugin>();
    public static String finalApkPath;

    /**
     * 加载Plugin
     * @param proxyParent
     * @param apkPath
     * @return
     */
    public static LPlugin loadPlugin(Activity proxyParent,String apkPath){
        finalApkPath = apkPath;
        LPlugin plugin = null;
//        plugin = pluginsMapForPath.get(apkPath);
//        if(plugin == null){
            plugin = new LPlugin(proxyParent,apkPath);
//       }

        // Lody~
        // FIX ME:不要使用缓存，否则Activity间跳转会出现严重问题！
        //奇怪的是，不使用缓存，插件间跳转的效率居然没有受到影响
        //2015/4/4 17:20
        //pluginsMapForPath.put(apkPath,plugin);
        return plugin;
    }

/*
    */
/**
     * 得到一个已经加载的Plugin,可能返回null
     * @return
     *//*

    public static LPlugin getLoadedPlugin(String apkPath){
        finalApkPath = apkPath;

        return pluginsMapForPath.get(apkPath);
    }
*/

}
