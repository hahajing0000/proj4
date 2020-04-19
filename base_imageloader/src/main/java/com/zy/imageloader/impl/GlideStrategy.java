package com.zy.imageloader.impl;

import android.content.Context;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.bumptech.glide.request.RequestOptions;
import com.zy.imageloader.base.ImgLoaderStrategy;
import com.zy.imageloader.setting.NormalImageSetting;

/**
 * @author:zhangyue
 * @date:2020/4/19
 * Glide策略
 */
public class GlideStrategy implements ImgLoaderStrategy<NormalImageSetting> {
    @Override
    public void loadImage(Context context, NormalImageSetting setting) {

        RequestOptions options=null;
        if (setting.getImageRadius()>0){
            options=RequestOptions.bitmapTransform(new RoundedCorners(setting.getImageRadius()));
        }else{
            options=new RequestOptions();
        }
//        DiskCacheStrategy.ALL	表示原始数据，本地数据，转换后的数据都缓存
//        DiskCacheStrategy.AUTOMATIC	表示智能的选取最好的一种缓存策略
//        DiskCacheStrategy.NONE	表示不缓存
//        DiskCacheStrategy.DATA	在检索之前将检索到的数据直接写入磁盘缓存
//        DiskCacheStrategy.RESOURCE	表示缓存转换后（压缩、做过处理）的图片
//        关闭内存缓存
//        options.skipMemoryCache(true);
//        //关闭磁盘缓存
//        options.diskCacheStrategy(DiskCacheStrategy.NONE);

        options.diskCacheStrategy(DiskCacheStrategy.ALL);
        if (setting.getmPlaceholder()>0){
            options.placeholder(setting.getmPlaceholder());
            options.error(setting.getmPlaceholder());
        }


        Glide.with(context).load(setting.getmUrl()).apply(options).into(setting.getmView());
    }
}
//        //模糊
//     .bitmapTransform(new BlurTransformation(this))
//                //圆角
//                .bitmapTransform(new RoundedCornersTransformation(this, 24, 0, RoundedCornersTransformation.CornerType.ALL))
//                //遮盖
//                .bitmapTransform(new MaskTransformation(this, R.mipmap.ic_launcher))
//                //灰度
//                .bitmapTransform(new GrayscaleTransformation(this))
//                //圆形
//                .bitmapTransform(new CropCircleTransformation(this))