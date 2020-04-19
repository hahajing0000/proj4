package com.zy.imageloader.setting;

import android.widget.ImageView;

/**
 * @author:zhangyue
 * @date:2020/4/19
 * 总体设置
 */
public class ImgSetting {
    //图片URl
    protected String mUrl;
    //View
    protected ImageView mView;
    //占位图
    protected int mPlaceholder;

    public String getmUrl() {
        return mUrl;
    }

    public ImageView getmView() {
        return mView;
    }

    public int getmPlaceholder() {
        return mPlaceholder;
    }
}
