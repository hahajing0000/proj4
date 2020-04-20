package com.zy.storage.chain;

import com.zy.storage.callback.ResultCallback;
import com.zy.storage.common.ZLRUCache;

/**
 * @author:zhangyue
 * @date:2020/4/19
 * 内存缓存 使用 LRU算法的 LRUCache
 */
public class MemoryCacheChain<T> extends StorageChain<T> {

    public MemoryCacheChain(){

    }

    @Override
    protected void saveData(String key, T data) {
        /**
         * 设置链名称
         */
        chainName=key;

        ZLRUCache.getInstance().put(key,data);
    }

    @Override
    protected void getData(String key, ResultCallback callback) {
        T t = (T) ZLRUCache.getInstance().get(key);
        if (t==null){
            callback.getData(null);
        }
        else {
            callback.getData(t);
        }

    }

    @Override
    protected void removeByKey(String key) {
        ZLRUCache.getInstance().remove(key);
    }

    @Override
    protected void clearData() {
        ZLRUCache.getInstance().clear();
    }
}
