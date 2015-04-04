package com.lody.plugin.manager;

import com.lody.plugin.EasyFor;
import com.lody.plugin.api.LPluginError;
import com.lody.plugin.api.LPluginErrorListener;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lody  on 2015/4/3.
 */
public class LPluginErrorManager {
    private static final List<LPluginErrorListener> errorCollection = new ArrayList<LPluginErrorListener>();

    /**
     * 加入一个插件异常监听器
     * @param lPluginErrorListener
     */
    public static void addErrorListener(LPluginErrorListener lPluginErrorListener){
        errorCollection.add(lPluginErrorListener);
    }

    /**
     * 移除一个插件异常监听器
     * @param lPluginErrorListener
     */
    public static void aremoveErrorListener(LPluginErrorListener lPluginErrorListener){
        errorCollection.remove(lPluginErrorListener);
    }

    public static void callAllErrorListener(final LPluginError error){
        if(errorCollection.size() == 0) return;
        new EasyFor<LPluginErrorListener>(errorCollection){
            @Override
            public void onNewElement(LPluginErrorListener element) {
                element.OnError(error);
            }
        };
    }

}
