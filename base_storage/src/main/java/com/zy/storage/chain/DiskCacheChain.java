package com.zy.storage.chain;

import com.zy.storage.callback.ResultCallback;
import com.zy.storage.common.ZDiskLRUCache;

/**
 * @author:zhangyue
 * @date:2020/4/19 使用本地磁盘缓存  使用 DiskLRUCache
 */
public class DiskCacheChain<T> extends StorageChain<T> {

    public DiskCacheChain() {
    }

    @Override
    protected void saveData(String key, T data) {
        /**
         * 设置链名称
         */
        chainName = key;
        ZDiskLRUCache.getInstance().saveData(key, data);
    }

    @Override
    protected void getData(String key, ResultCallback callback) {
        T data = (T) ZDiskLRUCache.getInstance().getData(key);
        if (data!=null){
            callback.getData(data);
        }
        else{
            callback.getData(null);
        }
    }

    @Override
    protected void removeByKey(String key) {
        ZDiskLRUCache.getInstance().removeByKey(key);
    }

    @Override
    protected void clearData() {
        ZDiskLRUCache.getInstance().clearData();
    }


}
