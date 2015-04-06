package com.lody.plugin;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

/**
 * Created by lody  on 2015/3/24.
 */
public class LPluginOpener {

    /**
     * 直接启动一个apk
     *
     * @param context    当前上下文
     * @param pluginPath 插件路径
     */
    public static void startPlugin(Context context, String pluginPath) {
        Intent i = new Intent(context, LActivityProxy.class);
        Bundle bundle = new Bundle();
        bundle.putString(LPluginConfig.KEY_PLUGIN_DEX_PATH, pluginPath);
        i.putExtras(bundle);
        context.startActivity(i);
    }

    /**
     * 启动插件中的指定activity
     * @param context
     * @param pluginPath
     * @param activityName 要启动的插件的activity名
     */
    public static void startActivity(Context context, String pluginPath,String activityName) {
        Intent i = new Intent(context, LActivityProxy.class);
        Bundle bundle = new Bundle();
        bundle.putString(LPluginConfig.KEY_PLUGIN_DEX_PATH, pluginPath);
        bundle.putString(LPluginConfig.DEF_PLUGIN_CLASS_NAME,activityName);
        i.putExtras(bundle);
        context.startActivity(i);
    }

    /**
     * 直接启动一个apk
     *
     * @param context
     * @param pluginPath
     * @param index  插件中的第几个Activity？
     */
    public static void startActivity(Context context, String pluginPath, int index) {
        Intent i = new Intent(context, LActivityProxy.class);
        Bundle bundle = new Bundle();
        bundle.putString(LPluginConfig.KEY_PLUGIN_DEX_PATH, pluginPath);
        i.putExtras(bundle);
        context.startActivity(i);
    }

    /**
     * 启动插件中的指定service
     * @param context
     * @param pluginPath
     * @param serviceName 要启动的插件的activity名
     */
    public static void startService(Context context, String pluginPath,String serviceName) {
       //TODO:未完成
    }
}
