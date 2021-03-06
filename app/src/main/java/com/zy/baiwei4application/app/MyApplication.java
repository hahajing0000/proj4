package com.zy.baiwei4application.app;

import android.app.Application;

import com.alibaba.android.arouter.launcher.ARouter;
import com.zy.commonlib.app.AppUtils;
import com.zy.imageloader.ImageLoader;
import com.zy.imageloader.impl.GlideStrategy;

/**
 * @author:zhangyue
 * @date:2020/4/16
 */
public class MyApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        if (AppUtils.isDebug(this)) {           // 这两行必须写在init之前，否则这些配置在init过程中将无效
            ARouter.openLog();     // 打印日志
            ARouter.openDebug();   // 开启调试模式(如果在InstantRun模式下运行，必须开启调试模式！线上版本需要关闭,否则有安全风险)
        }
        ARouter.init(this); // 尽可能早，推荐在Application中初始化

        //初始化图片加载框架策略
        ImageLoader.getInstance().initStrategy(new GlideStrategy());
        /**
         * 设置Common中的全局上下文
         */
        AppUtils.setContext(this);
    }


}
