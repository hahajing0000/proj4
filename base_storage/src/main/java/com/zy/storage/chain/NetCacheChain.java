package com.zy.storage.chain;

import com.zy.storage.callback.ResultCallback;

/**
 * @author:zhangyue
 * @date:2020/4/19
 * 网络缓存
 */
public class NetCacheChain<T> extends StorageChain<T> {

    @Override
    protected void saveData(String key, T data) {

    }

    @Override
    protected void getData(String key, ResultCallback resultCallback) {

    }

    @Override
    protected void removeByKey(String key) {

    }

    @Override
    protected void clearData() {

    }
}
