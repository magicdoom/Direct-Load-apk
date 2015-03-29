package com.lody.plugin.bean;

import android.app.Activity;
import android.app.Application;
import android.app.Service;
import android.content.IntentFilter;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageInfo;
import android.content.res.AssetManager;
import android.content.res.Resources;

import com.lody.plugin.control.PluginActivityControl;

import java.util.List;

/**
 * Created by lody  on 2015/3/27.
 */
public class LPlugin {
    /** 插件的Application */
   private Application pluginApplication;
    /** 插件的Service */
    private Service pluginService;
    /** 插件路径 */
    private String pluginPath;
    /** 插件资源管理器 */
    private AssetManager pluginAssetManager;
    /** 插件资源 */
    private Resources pluginRes;
    /** 插件主题 */
    private Resources.Theme currentPluginTheme;
    /** 插件Activity信息 */
    private ActivityInfo activityInfos[];
    /** 插件包信息 */
    private PackageInfo pluginPkgInfo;
    /** 插件代理器 */
    private Activity proxyParent;
    /** 插件实体Activity */
    private Activity CurrentPluginActivity;
    /** 插件加载器 */
    private ClassLoader pluginLoader;
    /** 插件是否已经完成初始化 */
    boolean isPluginInit;
    /**插件的Action过滤器 */
    private List<IntentFilter> pluginFilters;
    /** 插件的第一个Activity */
    private String topActivityName = null;
    /** 插件控制器 */
    private PluginActivityControl control;
    /** 是否需要重复加载 */
    private boolean isOver = false;
    /** 插件的Application名 */
    private String appName;
    /**当前的service完整类名 */
    private String currentServiceClassName = null;

    public boolean isOver() {
        return isOver;
    }

    public void setOver(boolean isOver) {
        this.isOver = isOver;
    }

    public boolean isServiceInit() {
        return pluginService != null;
    }


    public String getCurrentServiceClassName() {
        return currentServiceClassName;
    }

    public void setCurrentServiceClassName(String currentServiceClassName) {
        this.currentServiceClassName = currentServiceClassName;
    }

    public String getAppName() {
        return appName;
    }

    public void setAppName(String appName) {
        this.appName = appName;
    }

    public Service getPluginService() {
        return pluginService;
    }

    public void setPluginService(Service pluginService) {
        this.pluginService = pluginService;
    }

    /**
     * @return 插件的Application
     */
    public Application getPluginApplication() {
        return pluginApplication;
    }

    /**
     * 绑定插件的Application
     * @param pluginApp
     */
    public void bindPluginApp(Application pluginApp) {
        this.pluginApplication = pluginApp;
    }

    public void setPluginFilters(List<IntentFilter> pluginFilters) {
        this.pluginFilters = pluginFilters;
    }

    public String getTopActivityName() {
        return topActivityName;
    }

    public void setTopActivityName(String topActivityName) {
        this.topActivityName = topActivityName;
    }

    public PluginActivityControl getControl() {
        return control;
    }

    public void setControl(PluginActivityControl control) {
        this.control = control;
    }


    public LPlugin(Activity proxyParent,String apkPath){
        this.proxyParent = proxyParent;
        this.pluginPath = apkPath;

    }

    /**
     * 得到代理的实体
     * @return
     */
    public Activity getProxyParent() {
        return proxyParent;
    }

    public List<IntentFilter> getPluginFilters() {
        return pluginFilters;
    }

    /**
     * 设置代理的实体
     * @param proxyParent
     */
    public void setProxyParent(Activity proxyParent) {
        this.proxyParent = proxyParent;
    }

    public String getPluginPath() {
        return pluginPath;
    }

    public void setPluginPath(String pluginPath) {
        this.pluginPath = pluginPath;
    }

    public AssetManager getPluginAssetManager() {
        return pluginAssetManager;
    }

    public void setPluginAssetManager(AssetManager pluginAssetManager) {
        this.pluginAssetManager = pluginAssetManager;
    }

    public Resources getPluginRes() {
        return pluginRes;
    }

    public void setPluginRes(Resources pluginRes) {
        this.pluginRes = pluginRes;
    }

    public Resources.Theme getCurrentPluginTheme() {
        return currentPluginTheme;
    }

    public void setCurrentPluginTheme(Resources.Theme currentPluginTheme) {
        this.currentPluginTheme = currentPluginTheme;
    }

    public ActivityInfo[] getActivityInfos() {
        return activityInfos;
    }

    public void setActivityInfos(ActivityInfo[] activityInfos) {
        this.activityInfos = activityInfos;
    }

    /**
     * 插件的包信息
     * @return
     */
    public PackageInfo getPluginPkgInfo() {
        return pluginPkgInfo;
    }

    public void setPluginPkgInfo(PackageInfo pluginPkgInfo) {
        this.pluginPkgInfo = pluginPkgInfo;
        this.activityInfos = pluginPkgInfo.activities;
    }

    /**
     *
     * @return 当前的插件Activity
     */
    public Activity getCurrentPluginActivity() {
        return CurrentPluginActivity;
    }

    public void setCurrentPluginActivity(Activity currentPluginActivity) {
        CurrentPluginActivity = currentPluginActivity;
    }

    /**
     * 插件的类加载器
     * @return
     */
    public ClassLoader getPluginLoader() {
        return pluginLoader;
    }

    public void setPluginLoader(ClassLoader pluginLoader) {
        this.pluginLoader = pluginLoader;
    }

    /**
     * 插件是否已经可以正常使用？
     * @return
     */
    public boolean isPluginInit() {
        isPluginInit = activityInfos != null;
        isPluginInit = getCurrentPluginActivity() != null;
        return isPluginInit;
    }


}
