package com.zy.core.mvp;

/**
 * @author:zhangyue
 * @date:2020/4/16
 * 该层为数据逻辑层 用于处理缓存或者原始数据的获取
 */
public abstract class Repository<M extends IModel> {
    protected M mModel;

    protected abstract void createModel();

    public Repository(){
        createModel();
    }

    /**
     * 是否持有的model
     */
    protected void releaseModel(){
        if (null!=mModel){
            mModel=null;
        }
    }
}
