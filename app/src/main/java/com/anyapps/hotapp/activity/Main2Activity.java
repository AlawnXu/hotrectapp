package com.anyapps.hotapp.activity;

import android.content.res.AssetManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import com.anyapps.hotapp.R;
import com.anyapps.hotapp.entity.HotArea;
import com.anyapps.hotapp.utils.FileUtils;
import com.anyapps.hotapp.widget.HotClickView;

import java.io.InputStream;

public class Main2Activity extends AppCompatActivity implements HotClickView.OnClickListener {
    private HotClickView mHotView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        setTitle("中国地图");
        initParam();
        initDatas();
    }

    private void initParam() {
        mHotView = (HotClickView) findViewById(R.id.a_main_hotview);
//        mHotView.setCanMove(false);
//        mHotView.setCanScale(false);
    }

    protected void initDatas() {
        AssetManager assetManager = getResources().getAssets();
        InputStream imgInputStream = null;
        InputStream fileInputStream = null;
        try {
            imgInputStream = assetManager.open("china.png");
            fileInputStream = assetManager.open("china.xml");
            mHotView.setImageBitmap(fileInputStream, imgInputStream, HotClickView.FIT_XY);
            mHotView.setOnClickListener(this);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            FileUtils.closeInputStream(imgInputStream);
            FileUtils.closeInputStream(fileInputStream);
        }
    }


    @Override
    public void OnClick(View view, HotArea hotArea) {
        Toast.makeText(Main2Activity.this, "你点击了" + hotArea.getDesc(), Toast.LENGTH_SHORT).show();
    }
}
