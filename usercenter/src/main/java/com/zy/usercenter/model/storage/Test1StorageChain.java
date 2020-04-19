package com.zy.usercenter.model.storage;

import com.zy.commonlib.log.ZLog;
import com.zy.storage.ResultCallback;
import com.zy.storage.chain.StorageChain;

/**
 * @author:zhangyue
 * @date:2020/4/19
 */
public class Test1StorageChain<T> extends StorageChain<T> {
    @Override
    protected void saveData(String key, T data) {
        ZLog.d(data.toString());
    }

    @Override
    protected void getData(String key, ResultCallback callback) {
        ZLog.d(key);
    }

    @Override
    protected void removeByKey(String key) {

    }

    @Override
    protected void clearData() {

    }
}
