package com.zy.storage.chain;

import com.zy.storage.callback.ResultCallback;

/**
 * @author:zhangyue
 * @date:2020/4/19
 * 存储链 用于实现三级缓存
 */
public abstract class StorageChain<T> {
    /**
     * 链名称 一般用于区分存储的资源
     */
    protected String chainName;
    /**
     * 上一节点
     */
    protected StorageChain previousChain;
    /**
     * 下一节点
     */
    protected StorageChain nextChain;


    /**
     * 设置下游链
     * @param storageChain
     */
    public void setNextChain(StorageChain storageChain){
        this.nextChain=storageChain;
        storageChain.previousChain=this;
    }

    /**
     * 存储数据 —— 链式存储
     * @param key
     * @param data
     */
    public  void save(String key,T data){
        saveData(key,data);
        if (this.nextChain!=null){
            this.nextChain.save(key,data);
        }

    }

    /**
     * 获取数据  —— 链式获取
     * @param key
     * @return
     */
    public void get(final String key, final ResultCallback<T> callback){
        getData(key, new ResultCallback<T>() {
            @Override
            public void getData(T result) {
                if (null==result){
                    nextChain.getData(key,callback);
                }else{
                    /**
                     * 如果有上级链 则将数据同步过去 因为代码走到这里明显上级数据已经清空了
                     */
                    if (previousChain!=null){
                        previousChain.save(key,result);
                    }
                    callback.getData(result);
                }
            }
        });
    }

    /**
     * 根据key删除链上的所有资源
     * @param key
     */
    public void removeAtKey(String key){
        removeByKey(key);
        this.nextChain.removeByKey(key);
    }

    /**
     * 清空链上所有资源
     */
    public void clear(){
        clearData();
        this.nextChain.clearData();
    }

    /**
     * 存储数据
     * @param key
     * @param data
     */
    abstract protected void saveData(String key,T data);

    /**
     * 获取数据
     * @param key
     * @param callback
     */
    abstract protected void getData(String key,ResultCallback callback);

    /**
     * 根据key删除数据
     * @param key
     */
    abstract protected void removeByKey(String key);

    /**
     * 清除数据
     */
    abstract protected void clearData();

}
