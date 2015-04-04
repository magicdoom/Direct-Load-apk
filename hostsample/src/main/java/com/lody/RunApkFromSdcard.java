package com.lody;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.lody.plugin.LPluginOpener;
import com.lody.plugin.api.LPluginError;
import com.lody.plugin.api.LPluginErrorListener;
import com.lody.plugin.manager.LPluginErrorManager;
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
                LPluginErrorManager.addErrorListener(new LPluginErrorListener() {
                    @Override
                    public void OnError(LPluginError error) {
                        android.os.Process.killProcess(error.processId);
                        System.exit(1);
                    }
                });
                LPluginOpener.startPlugin(RunApkFromSdcard.this, path);
            }
        });
    }
}

