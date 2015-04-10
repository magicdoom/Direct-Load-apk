package com.lody.plugin.service;

import android.app.*;
import android.content.*;
import android.content.res.*;
import android.os.*;
import com.lody.plugin.bean.*;
import com.lody.plugin.manager.*;
import com.lody.plugin.reflect.*;

public class LProxyService  extends Service
{

	LServicePlugin remote;
	public static String SERVICE_CLASS_NAME;
	@Override
	public IBinder onBind(Intent i)
	{

		return remote.getCurrentPluginService().onBind(i);
	}

	@Override
	public int onStartCommand(Intent intent, int flags, int startId)
	{
		// TODO: Implement this method
		//Toast.makeText(this,"插件的onStartCommand被执行!",1).show();
		if(!SERVICE_CLASS_NAME.equals(intent.getComponent().getClassName())){
			onCreate();
		}
		return remote.getCurrentPluginService().onStartCommand(intent,flags,startId);
	}

	@Override
	public void onCreate()
	{
		// TODO: Implement this method
		super.onCreate();
		//Toast.makeText(this,"插件的Service已经启动!",1).show();

		remote = new LServicePlugin(this,LPluginDexManager.finalApkPath);
		remote.setTopServiceName(SERVICE_CLASS_NAME);
		if(!remote.from().canUse()){
			LApkManager.initApk(remote.from(),this);
		}

		fillService();
		remote.getCurrentPluginService().onCreate();
	}

	private void fillService()
	{
		try
		{

			Service plugin = (Service) remote.from().pluginLoader.loadClass(remote.getTopServiceName()).newInstance();
			remote.setCurrentPluginService(plugin);
			Reflect thiz = Reflect.on(this);
			Reflect.on(plugin).call("attach", this,thiz.get("mThread"),getClass().getName(),thiz.get("mToken"),getApplication(),thiz.get("mActivityManager"));


		}
		catch (IllegalAccessException e)
		{}
		catch (ClassNotFoundException e)
		{}
		catch (InstantiationException e)
		{}
	}

	@Override
	public void onStart(Intent intent, int startId)
	{
		// TODO: Implement this method
		//Toast.makeText(this,"插件的onStart被执行!",1).show();
		super.onStart(intent, startId);
		remote.getCurrentPluginService().onStart(intent,startId);
	}

	@Override
	public void onConfigurationChanged(Configuration newConfig)
	{
		// TODO: Implement this method
		super.onConfigurationChanged(newConfig);
		remote.getCurrentPluginService().onConfigurationChanged(newConfig);
	}

	@Override
	public boolean onUnbind(Intent intent)
	{
		// TODO: Implement this method
		return remote.getCurrentPluginService().onUnbind(intent);

	}

	@Override
	public void onDestroy()
	{
		// TODO: Implement this method
		super.onDestroy();
		remote.getCurrentPluginService().onDestroy();
	}

	@Override
	public void onRebind(Intent intent)
	{
		// TODO: Implement this method
		super.onRebind(intent);
		remote.getCurrentPluginService().onRebind(intent);
	}

	@Override
	public void onTrimMemory(int level)
	{
		// TODO: Implement this method
		super.onTrimMemory(level);
		remote.getCurrentPluginService().onTrimMemory(level);
	}

	@Override
	public void onLowMemory()
	{
		// TODO: Implement this method
		super.onLowMemory();
		remote.getCurrentPluginService().onLowMemory();
	}

	@Override
	public void onTaskRemoved(Intent rootIntent)
	{
		// TODO: Implement this method
		super.onTaskRemoved(rootIntent);
		remote.getCurrentPluginService().onTaskRemoved(rootIntent);
	}

	@Override
    public Resources getResources() {
        if (remote == null)
            return super.getResources();
        return remote.from().pluginRes == null ? super.getResources() : remote.from().pluginRes;
    }


    @Override
    public AssetManager getAssets() {
        if (remote == null)
            return super.getAssets();
        return remote.from().pluginAssets == null ? super.getAssets() : remote.from().pluginAssets;
    }


    @Override
    public ClassLoader getClassLoader() {
        if (remote == null) {
            return super.getClassLoader();
        }
        if (remote.from().canUse()) {
            return remote.from().pluginLoader;
        }
        return super.getClassLoader();
    }

}
