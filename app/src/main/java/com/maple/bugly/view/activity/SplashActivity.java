package com.maple.bugly.view.activity;

import android.content.Intent;
import android.os.Bundle;

import com.blankj.utilcode.util.BarUtils;
import com.maple.bugly.R;
import com.maple.bugly.app.base.BaseActivity;
import com.maple.bugly.utils.PermissionUtils;
import com.maple.bugly.utils.RequestPermission;
import com.tbruyelle.rxpermissions2.RxPermissions;

import java.util.List;

public class SplashActivity extends BaseActivity {
    private RxPermissions rxPermissions = new RxPermissions(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        BarUtils.setStatusBarLightMode(this,true);
        setContentView(R.layout.activity_splash);
        applyPermissions();
    }


    @Override
    protected void onRestart() {
        super.onRestart();
        applyPermissions();
    }

    private void applyPermissions(){
        PermissionUtils.applyPermissions(new RequestPermission(){

            @Override
            public void onRequestPermissionSuccess() {
                launchHome();
            }

            @Override
            public void onRequestPermissionFailure(List<String> permissions) {

            }

            @Override
            public void onRequestPermissionFailureWithAskNeverAgain(List<String> permissions) {

            }
        },rxPermissions);
    }

    private void launchHome(){
        startActivity(new Intent(this,HomeActivity.class));
        this.finish();
    }
}