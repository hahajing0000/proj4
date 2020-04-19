package com.zy.core.mvp;

import java.lang.ref.WeakReference;

/**
 * @author:zhangyue
 * @date:2020/4/16
 * P层 衔接M与V层
 */
public abstract class BasePresenter<R extends Repository,V extends IView> {
    /**
     * 数据仓库
     */
    protected R mRepository;

    /**
     * 对于View使用弱引用放置内存泄漏
     */
    protected WeakReference<V> mView;

    /**
     * 创建数据仓库实例
     */
    protected abstract void createRepository();


    public BasePresenter(V v){
        createRepository();
        mView=new WeakReference<>(v);
    }
}
