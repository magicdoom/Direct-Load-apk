package com.lody.plugin.service;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

import com.lody.plugin.bean.LPlugin;
import com.lody.plugin.exception.LaunchPluginException;
import com.lody.plugin.exception.PluginCreateFailedException;
import com.lody.plugin.reflect.Reflect;

/**
 * Created by lody  on 2015/3/28.
 */
public class LServiceProxy extends Service {

    LPlugin remotePlugin;
    Reflect serviceRef;
    Reflect thisRef;

    public void fillPluginService(LPlugin plugin){
        if(remotePlugin.isServiceInit()){
            return;
        }

        Service pluginService = null;
        String serviceClassName = remotePlugin.getCurrentServiceClassName();
        if(serviceClassName == null){
            throw new LaunchPluginException("Plugin can't found service name!");
        }
        try {
            pluginService = (Service)remotePlugin.getPluginLoader().loadClass(serviceClassName).newInstance();
        } catch (ClassNotFoundException e) {
            throw new PluginCreateFailedException(e.getMessage());
        } catch (InstantiationException e) {
            throw new PluginCreateFailedException(e.getMessage());
        } catch (IllegalAccessException e) {
            throw new PluginCreateFailedException(e.getMessage());
        }

        serviceRef = Reflect.on(remotePlugin.getPluginService());

        hackPluginService();

        remotePlugin.setPluginService(pluginService);

    }

    private void hackPluginService() {
        serviceRef.call("attach",LServiceProxy.this,thisRef.get("mApplication"),thisRef.get("mClassName"),thisRef.get("mToken"),remotePlugin.getPluginApplication() == null ? getApplication() : remotePlugin.getPluginApplication(),thisRef.get("mActivityManager"));

    }

    @Override
    public void onStart(Intent intent, int startId) {
        super.onStart(intent, startId);
        if(remotePlugin == null ||! remotePlugin.isServiceInit())return;

    }

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        /*thisRef = Reflect.on(LServiceProxy.this);
        remotePlugin = LPluginManager.getLoadedPlugin(LPluginManager.finalApkPath);
        if(remotePlugin == null){
            throw new LaunchPluginException("Service is depend on a plugin.");
        }
        if(!remotePlugin.isPluginInit()){
            throw new LaunchPluginException("Service meet a plugin which is not init..");
        }
        fillPluginService(remotePlugin);

        serviceRef.call("onCreate");*/


    }

    @Override
    public void onLowMemory() {
        super.onLowMemory();
        if(remotePlugin != null)
        serviceRef.call("onLowMemory");
    }

    @Override
    public void onTrimMemory(int level) {
        super.onTrimMemory(level);
        if(remotePlugin != null)
            serviceRef.call("onTrimMemory");
    }

    @Override
    public boolean onUnbind(Intent intent) {

        if(remotePlugin != null)
           return serviceRef.call("onUnbind",intent).get();

        return super.onUnbind(intent);
    }



    @Override
    public void onRebind(Intent intent) {
        super.onRebind(intent);
        if(remotePlugin != null)
            serviceRef.call("onRebind",intent);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if(remotePlugin != null)
            serviceRef.call("onDestroy");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        if (remotePlugin == null|| !remotePlugin.isServiceInit())
        return super.onStartCommand(intent, flags, startId);

        return serviceRef.call("onStartCommand",intent,flags,startId).get();

    }

    @Override
    public void onTaskRemoved(Intent rootIntent) {
        super.onTaskRemoved(rootIntent);
        if(remotePlugin == null ||!remotePlugin.isServiceInit()){
            return;
        }
        serviceRef.call("onTaskRemoved",rootIntent);
    }
}
