package com.maple.bugly.app.base;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.blankj.utilcode.util.BarUtils;
import com.maple.bugly.R;
import com.maple.bugly.utils.UIUtils;

public abstract class BaseActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        BarUtils.setStatusBarColor(this, UIUtils.getColor(R.color.colorPrimary));
        BarUtils.setStatusBarLightMode(this,true);
        super.onCreate(savedInstanceState);
    }
}
