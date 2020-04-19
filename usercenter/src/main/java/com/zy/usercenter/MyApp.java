package com.zy.usercenter;

import android.app.Application;

import com.zy.commonlib.app.AppUtils;
import com.zy.imageloader.ImageLoader;
import com.zy.imageloader.impl.GlideStrategy;

/**
 * @author:zhangyue
 * @date:2020/4/19
 */
public class MyApp extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        //初始化图片策略
        ImageLoader.getInstance().initStrategy(new GlideStrategy());

        /**
         * 设置Common中的全局上下文
         */
        AppUtils.setContext(this);
    }
}
