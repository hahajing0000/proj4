package com.zy.usercenter.model.storage;

import com.zy.commonlib.log.ZLog;
import com.zy.storage.ResultCallback;
import com.zy.storage.chain.StorageChain;

/**
 * @author:zhangyue
 * @date:2020/4/19
 */
public class TestStorageChain extends StorageChain {
    @Override
    protected void saveData(String key, Object data) {
        ZLog.d("test chain save");
    }

    @Override
    protected void getData(String key, ResultCallback callback) {
        ZLog.d("test chain get");
    }

    @Override
    protected void removeByKey(String key) {

    }

    @Override
    protected void clearData() {

    }
}
