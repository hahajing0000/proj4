package com.zy.imageloader;

import android.content.Context;

import com.zy.commonlib.log.ZLog;
import com.zy.imageloader.base.ImgLoaderStrategy;
import com.zy.imageloader.setting.ImgSetting;

/**
 * @author:zhangyue
 * @date:2020/4/19
 */
public class ImageLoader {
    private ImgLoaderStrategy imgLoaderStrategy;

    private volatile static ImageLoader instance=null;

    private ImageLoader(){}

    public static ImageLoader getInstance(){
        if (null==instance){
            synchronized (ImageLoader.class){
                if (null==instance){
                    instance=new ImageLoader();
                }
            }
        }
        return instance;
    }

    /**
     * 加载图片
     * @param context
     * @param setting
     */
    public void loadImage(Context context, ImgSetting setting){
        if (null==imgLoaderStrategy){
            ZLog.e("please set imgLoaderStrategy,because current is null...");
            throw new NullPointerException("please set imgLoaderStrategy,because current is null...");
        }
        if (null==context){
            ZLog.e("context is null");
            throw new IllegalArgumentException("context is null");
        }
        if (null==setting){
            ZLog.e("setting is null");
            throw new IllegalArgumentException("setting is null");
        }
        imgLoaderStrategy.loadImage(context,setting);
    }

    /**
     * 初始化图片加载策略
     * @param imgLoaderStrategy
     */
    public void initStrategy(ImgLoaderStrategy imgLoaderStrategy){
        this.imgLoaderStrategy=imgLoaderStrategy;
    }

    /**
     * 获取当前图片加载策略
     * @return
     */
    public ImgLoaderStrategy getCurrentImgLoaderStrategy(){
        return imgLoaderStrategy;
    }
}
