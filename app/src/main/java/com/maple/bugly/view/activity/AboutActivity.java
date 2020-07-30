package com.maple.bugly.view.activity;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.blankj.utilcode.util.TimeUtils;
import com.maple.bugly.R;
import com.maple.bugly.app.base.BaseActivity;
import com.maple.bugly.view.adapter.AboutAdapter;
import com.scwang.smart.refresh.footer.ClassicsFooter;
import com.scwang.smart.refresh.header.ClassicsHeader;
import com.scwang.smart.refresh.layout.api.RefreshLayout;
import com.scwang.smart.refresh.layout.listener.OnLoadMoreListener;
import com.scwang.smart.refresh.layout.listener.OnRefreshListener;

import java.util.ArrayList;
import java.util.List;

public class AboutActivity extends BaseActivity {

    private RefreshLayout refreshLayout;
    private RecyclerView rvAbout;

    private AboutAdapter mAdapter;
    private List<String> mData;



    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);

        refreshLayout = (RefreshLayout)findViewById(R.id.refreshLayout);
        rvAbout = findViewById(R.id.rv_about);
        rvAbout.setLayoutManager(new LinearLayoutManager(this));
        refreshLayout.setRefreshHeader(new ClassicsHeader(this));
        refreshLayout.setRefreshFooter(new ClassicsFooter(this));
        refreshLayout.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh(RefreshLayout refreshlayout) {
                onRefreshData();
            }
        });
        refreshLayout.setOnLoadMoreListener(new OnLoadMoreListener() {
            @Override
            public void onLoadMore(RefreshLayout refreshlayout) {
                onLoadMoreData();
            }
        });

        mAdapter = new AboutAdapter(this);
        rvAbout.setAdapter(mAdapter);
        mData = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            mData.add(String.valueOf(i) +"----"+TimeUtils.getNowString());
        }
        mAdapter.setList(mData);
    }



    private void onRefreshData() {
        mData.clear();
        for (int i = 0; i < 10; i++) {
            mData.add(String.valueOf(i) +"----"+TimeUtils.getNowString());
        }
        mAdapter.notifyDataSetChanged();
        onFinishRefresh();
    }

    private void onLoadMoreData() {
        int size = mData.size();
        for (int i = size; i < size + 10; i++) {
            mData.add(String.valueOf(i) +"----"+TimeUtils.getNowString());
        }
        mAdapter.notifyDataSetChanged();
        onFinishLoadMore();
    }

    private void onFinishRefresh(){
        if(refreshLayout != null && refreshLayout.isRefreshing()){
            refreshLayout.finishRefresh(500/*,false*/);//传入false表示刷新失败
        }
    }

    private void onFinishLoadMore(){
        if(refreshLayout != null && refreshLayout.isLoading()){
            refreshLayout.finishLoadMore(500/*,false*/);//传入false表示加载失败
        }
    }
}
