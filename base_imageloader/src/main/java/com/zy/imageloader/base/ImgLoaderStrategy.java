package com.zy.imageloader.base;

import android.content.Context;

import com.zy.imageloader.setting.ImgSetting;

/**
 * @author:zhangyue
 * @date:2020/4/19
 * ImageLoader 策略接口  使用策略模式
 */
public interface ImgLoaderStrategy<Setting extends ImgSetting> {
    /**
     * 加载图片
     * @param context
     * @param setting
     */
    void loadImage(Context context,Setting setting);
}
