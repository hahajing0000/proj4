package com.zy.imageloader.setting;

import android.widget.ImageView;

/**
 * @author:zhangyue
 * @date:2020/4/19
 * 通用的Image Setting
 */
public class NormalImageSetting extends ImgSetting {
    /**
     * 支持圆角图片  该值为 圆角的大小值
     */
    private int imgRadius;


    private NormalImageSetting(Builder builder){
        this.imgRadius=builder.imgRadius;
        mUrl=builder.imgUrl;
        mPlaceholder=builder.placeHolder;
        mView=builder.imgView;
    }

    /**
     * 获取圆角值
     * @return
     */
    public int getImageRadius(){
        return imgRadius;
    }

    public static Builder builder(){
        return new Builder();
    }

    public static final class Builder{
        private String imgUrl;
        private ImageView imgView;
        private int placeHolder;
        private int imgRadius;

        private Builder(){}

        public Builder url(String url){
            this.imgUrl=url;
            return this;
        }

        public Builder placeHolder(int placeholder){
            this.placeHolder=placeholder;
            return this;
        }

        public Builder imageView(ImageView imageView){
            this.imgView=imageView;
            return this;
        }

        public Builder imageRadius(int imageRadius){
            this.imgRadius=imageRadius;
            return this;
        }

        public NormalImageSetting build(){
            return new NormalImageSetting(this);
        }

    }
}
