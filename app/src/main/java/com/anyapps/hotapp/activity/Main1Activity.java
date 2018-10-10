package com.anyapps.hotapp.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import com.anyapps.hotapp.R;

public class Main1Activity extends AppCompatActivity implements View.OnClickListener {
    private Toast mToast;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main1);
        setTitle("Chrome");
        findViewById(R.id.menu_1).setOnClickListener(this);
        findViewById(R.id.menu_2).setOnClickListener(this);
        findViewById(R.id.menu_3).setOnClickListener(this);
        findViewById(R.id.menu_4).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (null != mToast) {
            mToast.cancel();
        }
        switch (v.getId()) {
            case R.id.menu_1:
                mToast = Toast.makeText(this, "red", Toast.LENGTH_SHORT);
                break;
            case R.id.menu_2:
                mToast = Toast.makeText(this, "yellow", Toast.LENGTH_SHORT);
                break;
            case R.id.menu_3:
                mToast = Toast.makeText(this, "green", Toast.LENGTH_SHORT);
                break;
            case R.id.menu_4:
                mToast = Toast.makeText(this, "blue", Toast.LENGTH_SHORT);
                break;
        }
        mToast.show();
    }
}
