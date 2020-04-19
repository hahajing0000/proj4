package com.zy.storage.chain;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.os.Environment;

import com.jakewharton.disklrucache.DiskLruCache;
import com.zy.commonlib.ObjUtils;
import com.zy.commonlib.app.AppUtils;
import com.zy.commonlib.encrypt.MD5;
import com.zy.storage.ResultCallback;
import com.zy.storage.common.ZDiskLRUCache;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

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
