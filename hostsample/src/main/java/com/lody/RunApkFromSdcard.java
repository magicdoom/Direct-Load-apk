package com.lody;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.util.AttributeSet;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.lody.plugin.LPluginOpener;
import com.lody.plugin.api.LPluginBug;
import com.lody.plugin.api.LPluginBugListener;
import com.lody.plugin.control.PluginActivityCallback;
import com.lody.plugin.manager.LCallbackManager;
import com.lody.plugin.manager.LPluginBugManager;
import com.lody.sample.R;

import java.io.File;
import java.io.FileDescriptor;
import java.io.PrintWriter;

/**
 * Created by lody  on 2015/4/4.
 */
public class RunApkFromSdcard extends Activity {
    Button button;
    EditText editText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.choose_from_sd);
        button = (Button) findViewById(R.id.打开插件);
        editText = (EditText) findViewById(R.id.editText);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String path = editText.getText().toString();
                if(path.isEmpty()){
                    Toast.makeText(RunApkFromSdcard.this, "请输入插件的路径！", Toast.LENGTH_SHORT).show();
                    return;
                }
                File file = new File(path);
                if(!file.exists()){
                    Toast.makeText(RunApkFromSdcard.this,"所在路径没有文件！！",Toast.LENGTH_SHORT).show();
                    return;
                }
                LPluginBugManager.addBugListener(new LPluginBugListener() {
                    @Override
                    public void OnError(LPluginBug error) {

                        Log.e("DEBUG", error.error.getMessage());
                        android.os.Process.killProcess(error.processId);
                        System.exit(1);
                    }
                });


                LCallbackManager.addActivityCallback(new PluginActivityCallback() {
                    @Override
                    public void callOnCreate(Bundle saveInstance) {

                    }

                    @Override
                    public void callOnStart() {

                    }

                    @Override
                    public void callOnResume() {

                    }

                    @Override
                    public void callOnDestroy() {

                    }

                    @Override
                    public void callOnStop() {

                    }

                    @Override
                    public void callOnRestart() {

                    }

                    @Override
                    public void callOnSaveInstanceState(Bundle outState) {

                    }

                    @Override
                    public void callOnRestoreInstanceState(Bundle savedInstanceState) {

                    }

                    @Override
                    public void callOnPause() {

                    }

                    @Override
                    public void callOnBackPressed() {

                    }

                    @Override
                    public boolean callOnKeyDown(int keyCode, KeyEvent event) {
                        return false;
                    }

                    @Override
                    public void callDump(String prefix, FileDescriptor fd, PrintWriter writer, String[] args) {

                    }

                    @Override
                    public void callOnConfigurationChanged(Configuration newConfig) {

                    }

                    @Override
                    public void callOnPostResume() {

                    }

                    @Override
                    public void callOnDetachedFromWindow() {

                    }

                    @Override
                    public View callOnCreateView(String name, Context context, AttributeSet attrs) {
                        return null;
                    }

                    @Override
                    public View callOnCreateView(View parent, String name, Context context, AttributeSet attrs) {
                        return null;
                    }

                    @Override
                    public void callOnNewIntent(Intent intent) {

                    }
                });
                LPluginOpener.startPlugin(RunApkFromSdcard.this, path);
            }
        });
    }
}

