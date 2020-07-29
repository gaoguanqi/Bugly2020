package com.maple.bugly.view.activity;


import android.os.Bundle;
import android.view.KeyEvent;
import android.widget.TextView;

import com.blankj.utilcode.util.ToastUtils;
import com.maple.bugly.R;
import com.maple.bugly.app.base.BaseActivity;

public class HomeActivity extends BaseActivity {

    private long lastBackPressedMillis = 0;


    private TextView tvTest;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        tvTest = findViewById(R.id.tv_test);
        tvTest.setText("下发补丁测试");
    }


    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            if(lastBackPressedMillis + 2000 > System.currentTimeMillis()){
                moveTaskToBack(true);
//                this.finish();
            }else {
                lastBackPressedMillis = System.currentTimeMillis();
                ToastUtils.showShort("再按一次退出程序");
            }
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }
}