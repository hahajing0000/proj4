package com.zy.storage.chain;

import com.zy.storage.callback.ResultCallback;

import java.util.concurrent.ConcurrentHashMap;

/**
 * @author:zhangyue
 * @date:2020/4/19
 * 链式存储管理类
 */
public class StorageChainManager {
    private static StorageChainManager instance=null;
    private MemoryCacheChain memoryCacheChain=null;
    private DiskCacheChain diskCacheChain=null;

    /**
     * 缓存各个存储链资源
     */
    private static ConcurrentHashMap<String,StorageChain> chainMap;

    private StorageChainManager(){
        chainMap=new ConcurrentHashMap<>();
    }
    public static StorageChainManager getInstance(){
        if (null==instance){
            synchronized (StorageChainManager.class){
                if (null==instance){
                    instance=new StorageChainManager();
                }
            }
        }
        return instance;
    }

    /**
     * 存储数据
     * @param key
     * @param data
     * @param <T>
     */
    public  <T> void saveData(String key, T data) {
        if (!chainMap.containsKey(key)){
            initChain(key);
        }
        memoryCacheChain.save(key,data);
    }

    /**
     * 初始化链结构
     * @param key
     */
    private StorageChain initChain(String key){
        memoryCacheChain=new MemoryCacheChain();
        diskCacheChain=new DiskCacheChain();
        //设置责任链
        memoryCacheChain.setNextChain(diskCacheChain);

        /**
         * 缓存到chainMap中
         */
        chainMap.put(key,memoryCacheChain);
        return diskCacheChain;
    }

    /**
     * 获取数据
     * @param key
     * @return
     */
    public void getData(String key, ResultCallback callback) {
        if (chainMap.containsKey(key)){
            chainMap.get(key).get(key,callback);
        }

    }

    /**
     * 添加链节点
     * @param storageChain
     */
    public void addChain(String key,StorageChain storageChain){
        if (chainMap.containsKey(key)){
            StorageChain storageChain1 = chainMap.get(key);
            while (storageChain1!=null){
                storageChain1=storageChain1.nextChain;
            }
            storageChain1.nextChain=storageChain;
        }else{
            /**
             * 初始化并获取最后一个链节点
             */
            StorageChain lastStorageChain = initChain(key);
            lastStorageChain.setNextChain(storageChain);
        }
    }
}
