package com.maple.bugly.utils;

import android.graphics.drawable.Drawable;
import android.util.Log;

import androidx.annotation.ColorRes;
import androidx.annotation.DrawableRes;
import androidx.annotation.StringRes;

import com.blankj.utilcode.util.ColorUtils;
import com.blankj.utilcode.util.ResourceUtils;
import com.blankj.utilcode.util.StringUtils;

public class UIUtils {

    private UIUtils() {
        throw new UnsupportedOperationException("u can't instantiate me...");
    }

    public static String getString(@StringRes int resId){
        return StringUtils.getString(resId);
    }

    public static int getColor(@ColorRes int resId){
        return ColorUtils.getColor(resId);

    }

    public static Drawable getDrawable(@DrawableRes int resId){
        return ResourceUtils.getDrawable(resId);
    }
}
