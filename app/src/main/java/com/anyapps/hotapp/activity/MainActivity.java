package com.anyapps.hotapp.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.anyapps.hotapp.R;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.btnApp1).setOnClickListener(this);
        findViewById(R.id.btnApp2).setOnClickListener(this);
        findViewById(R.id.btnApp3).setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        Intent intent = new Intent();
        switch (view.getId()) {
            case R.id.btnApp1:
                intent.setClass(MainActivity.this, Main1Activity.class);
                break;
            case R.id.btnApp2:
                intent.setClass(MainActivity.this, Main2Activity.class);
                break;
            case R.id.btnApp3:
                intent.setClass(MainActivity.this, Main3Activity.class);
                break;
            default:
                break;
        }
        startActivity(intent);
    }
}
