package com.zy.storage.common;

import android.util.LruCache;

/**
 * @author:zhangyue
 * @date:2020/4/19
 */
public class ZLRUCache<T> {
    private static ZLRUCache instance=new ZLRUCache();
    public static ZLRUCache getInstance(){
        return instance;
    }

    private int mTotalSize= (int) Runtime.getRuntime().totalMemory();
    private LruCache<String, T> mLruCache;

    private ZLRUCache(){
        mLruCache=new LruCache<String, T>(mTotalSize/8){
            @Override
            protected int sizeOf(String key, T value) {
                return super.sizeOf(key, value);
            }
        };
    }

    public void put(String key,T value){
        mLruCache.put(key,value);
    }

    public T get(String key){
        return mLruCache.get(key);
    }

    public void remove(String key){
        mLruCache.remove(key);
    }

    public void clear(){
        mLruCache.evictAll();
    }
}
