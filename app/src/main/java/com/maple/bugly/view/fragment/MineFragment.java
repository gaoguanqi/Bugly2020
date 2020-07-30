package com.maple.bugly.view.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.bumptech.glide.Glide;
import com.luck.picture.lib.PictureSelector;
import com.luck.picture.lib.config.PictureConfig;
import com.luck.picture.lib.config.PictureMimeType;
import com.luck.picture.lib.entity.LocalMedia;
import com.luck.picture.lib.listener.OnResultCallbackListener;
import com.maple.bugly.R;
import com.maple.bugly.app.base.BaseFragment;
import com.maple.bugly.utils.GlideEngine;
import com.maple.bugly.utils.PermissionUtils;
import com.maple.bugly.utils.RequestPermission;
import com.maple.bugly.view.activity.AboutActivity;
import com.tbruyelle.rxpermissions2.RxPermissions;
import com.tencent.bugly.crashreport.inner.InnerApi;

import java.util.List;

public class MineFragment extends BaseFragment{

    private ImageView ivImg;
    private Button btnPicture,btnAbout;

    private RxPermissions rxPermissions;

    public static MineFragment getInstance(){
        MineFragment fragment = new MineFragment();
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_mine, container, false);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ivImg = view.findViewById(R.id.iv_img);
        btnPicture = view.findViewById(R.id.btn_picture);
        btnAbout = view.findViewById(R.id.btn_about);
        rxPermissions = new RxPermissions(requireActivity());

        btnPicture.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PermissionUtils.openCamera(new RequestPermission() {
                    @Override
                    public void onRequestPermissionSuccess() {
                        openPhoto();
                    }

                    @Override
                    public void onRequestPermissionFailure(List<String> permissions) {

                    }

                    @Override
                    public void onRequestPermissionFailureWithAskNeverAgain(List<String> permissions) {

                    }
                },rxPermissions);
            }
        });
        btnAbout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(requireActivity(), AboutActivity.class));
            }
        });
    }

    private void openPhoto() {
        PictureSelector.create(requireActivity())
                .openGallery(PictureMimeType.ofImage())
                .imageEngine(GlideEngine.createGlideEngine()) // Please refer to the Demo GlideEngine.java
                .isCompress(true)
                .minimumCompressSize(300) //小于多少kb的图片不压缩
                .compressQuality(80)//图片压缩后输出质量
                .forResult(new OnResultCallbackListener<LocalMedia>() {
                    @Override
                    public void onResult(List<LocalMedia> result) {
                        if(result != null && !result.isEmpty()){
                            GlideEngine.createGlideEngine().loadImage(requireActivity(),result.get(0).getPath(),ivImg);
                        }
                    }

                    @Override
                    public void onCancel() {

                    }
                });


    }
}
