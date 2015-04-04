package com.lody;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.lody.sample.R;

/**
 * Created by lody  on 2015/4/4.
 */
public class Main extends Activity {

    Button chooseFromSd;
    Button listFromSd;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        chooseFromSd = (Button)findViewById(R.id.从sd卡选择);
        chooseFromSd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Main.this,RunApkFromSdcard.class));
            }
        });
    }
}
