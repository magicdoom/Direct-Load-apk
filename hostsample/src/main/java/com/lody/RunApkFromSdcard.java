package com.lody;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.lody.plugin.LPluginOpener;
import com.lody.plugin.api.LPluginBug;
import com.lody.plugin.api.LPluginBugListener;
import com.lody.plugin.manager.LPluginBugManager;
import com.lody.sample.R;

import java.io.File;

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
        button = (Button) findViewById(R.id.open_plugin);
        editText = (EditText) findViewById(R.id.editText);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String path = editText.getText().toString();
                if(path.isEmpty()){
                    Toast.makeText(RunApkFromSdcard.this, "Please enter the SD card path！", Toast.LENGTH_SHORT).show();
                    return;
                }
                File file = new File(path);
                if(!file.exists()){
                    Toast.makeText(RunApkFromSdcard.this,"Not found APK In their path！！",Toast.LENGTH_SHORT).show();
                    return;
                }
                LPluginBugManager.addBugListener(new LPluginBugListener() {
                    @Override
                    public void OnError(LPluginBug bug) {

                        Log.e("DEBUG", bug.error.getMessage());
                        android.os.Process.killProcess(bug.processId);
                        System.exit(10);
                    }
                });
                LPluginOpener.startPlugin(RunApkFromSdcard.this, path);
            }
        });
    }
}

