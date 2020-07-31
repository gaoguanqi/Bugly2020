package com.maple.bugly.view.activity;


import android.os.Bundle;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;

import com.blankj.utilcode.util.ToastUtils;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.maple.bugly.R;
import com.maple.bugly.app.base.BaseActivity;
import com.maple.bugly.utils.LogUtils;
import com.maple.bugly.view.adapter.MyFragmentPagerAdapter;
import com.maple.bugly.view.fragment.MainFragment;
import com.maple.bugly.view.fragment.MineFragment;
import com.maple.bugly.view.fragment.NoticeFragment;

import java.nio.channels.Channel;
import java.util.ArrayList;
import java.util.List;

public class HomeActivity extends BaseActivity {

    private long lastBackPressedMillis = 0;

    private ViewPager2 vp;
    private BottomNavigationView bnav;
    private MyFragmentPagerAdapter pagerAdapter;
    private List<Fragment> fragmentList;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        vp = findViewById(R.id.view_pager);
        bnav = findViewById(R.id.bnav);
        //修改为原图片颜色
        bnav.setItemIconTintList(null);
        //true:滑动，false：禁止滑动
        vp.setUserInputEnabled(false);

        fragmentList = new ArrayList<>(3);
        fragmentList.add(MainFragment.getInstance());
        fragmentList.add(NoticeFragment.getInstance());
        fragmentList.add(MineFragment.getInstance());

        pagerAdapter = new MyFragmentPagerAdapter(this,fragmentList);
        vp.setAdapter(pagerAdapter);

        bnav.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.item_nav_main:
                        vp.setCurrentItem(0);
                        break;
                    case R.id.item_nav_notice:
                        vp.setCurrentItem(1);
                        break;
                    case R.id.item_nav_mine:
                        vp.setCurrentItem(2);
                        break;
                    default:
                        break;
                }
                return true;
            }
        });
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