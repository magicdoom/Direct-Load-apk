package com.lody.plugin;

import android.app.Activity;

import com.lody.plugin.bean.LPlugin;

/**
 * Created by lody  on 2015/3/27.
 */
public interface ILoadPlugin {
    /**
     * 根据apk路径加载一个插件
     * @param proxyParent 代理activity
     * @param apkPath apk路径
     * @return 插件的bean
     */
    LPlugin loadPlugin(Activity proxyParent, String apkPath);

    /**
     *根据apk路径加载一个插件
     * @param proxyParent 代理activity
     * @param apkPath apk路径
     * @param checkInit 是否检测插件是否初始化？
     * @return 插件的bean
     */
    LPlugin loadPlugin(Activity proxyParent, String apkPath, boolean checkInit);

    /**
     * 根据apk路径加载一个插件
     * @param proxyParent 代理activity
     * @param apkPath apk路径
     * @param activityName 启动的activity名
     * @return
     */
    LPlugin loadPlugin(Activity proxyParent, String apkPath, String activityName);

    /**
     * 根据apk路径加载一个插件
     * @param proxyParent 代理activity
     * @param apkPath apk路径
     * @param index  启动的activity在AndroidManifest.xml的索引值
     * @return
     */
    LPlugin loadPlugin(Activity proxyParent, String apkPath, int index);

    /**
     * 装载一个插件<br>
     * 一个刚刚初始化的插件只有apk路径信息，
     * 本操作能够使其变得完整(装载资源，类加载器等)。
     * @param plugin 需要装载的插件
     */
    void fillPlugin(LPlugin plugin);

}
