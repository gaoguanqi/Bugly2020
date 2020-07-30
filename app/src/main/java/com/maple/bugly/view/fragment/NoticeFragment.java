package com.maple.bugly.view.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.maple.bugly.R;
import com.maple.bugly.app.base.BaseFragment;

public class NoticeFragment extends BaseFragment{

    public static NoticeFragment getInstance(){
        NoticeFragment fragment = new NoticeFragment();
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_notice, container, false);
        return view;
    }
}
