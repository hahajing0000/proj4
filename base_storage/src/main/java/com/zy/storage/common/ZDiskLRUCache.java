package com.zy.storage.common;

import android.content.Context;
import android.os.Environment;

import com.jakewharton.disklrucache.DiskLruCache;
import com.zy.commonlib.ObjUtils;
import com.zy.commonlib.app.AppUtils;
import com.zy.commonlib.encrypt.MD5;
import com.zy.storage.ResultCallback;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * @author:zhangyue
 * @date:2020/4/19
 */
public class ZDiskLRUCache<T> {
    private static ZDiskLRUCache instance=new ZDiskLRUCache();

    /**
     * 容量上限 50M
     */
    private static final int MAX_SIZE = 50 * 1024 * 1024;
    private DiskLruCache diskLruCache;
    private final String cacheDirName="ZCacheDir";

    private ZDiskLRUCache(){
        if (diskLruCache == null || diskLruCache.isClosed()) {
            try {
                File cacheDir = getDiskCacheDir(AppUtils.getAppContext(), cacheDirName);
                if (!cacheDir.exists()) {
                    cacheDir.mkdirs();
                }
                //初始化DiskLruCache
                diskLruCache = DiskLruCache.open(cacheDir, 1, 1, MAX_SIZE);//AppUtils.getAppVersionCode(AppUtils.getAppContext())
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static ZDiskLRUCache getInstance(){
        return instance;
    }

    public void saveData(String key, T data) {

        String mKey= MD5.encrypt(key);
        OutputStream outputStream = null;
        DiskLruCache.Editor edit=null;
        try {
            edit = diskLruCache.edit(mKey);
            if (edit!=null){

                //对象转byte数组
                byte[] bytes= ObjUtils.obj2ByteArray(data);


                outputStream = edit.newOutputStream(0);
                outputStream.write(bytes);
                edit.commit();
                diskLruCache.flush();
            }
        } catch (IOException e) {
            e.printStackTrace();
            if (edit!=null){
                try {
                    edit.abort();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }

        }finally {
            if (outputStream!=null){
                try {
                    outputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public T getData(String key) {
        InputStream is=null;
        try {
            List<Byte> data = new ArrayList<>();
            String mKey = MD5.encrypt(key);
            DiskLruCache.Snapshot snapShot = diskLruCache.get(mKey);
            if (snapShot != null) {
                is = snapShot.getInputStream(0);
                byte[] bytes = new byte[2048];
                int len;
                while ((len = is.read(bytes)) != -1) {
                    for (int i = 0; i < len; i++) {
                        data.add(bytes[i]);
                    }
                }
                bytes = new byte[data.size()];
                for (int i = 0; i < bytes.length; i++) {
                    bytes[i] = data.get(i);
                }
                return ObjUtils.byteArray2Object(bytes);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if (is!=null){
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return null;
    }

    public void removeByKey(String key) {
        String mKey=MD5.encrypt(key);
        try {
            diskLruCache.remove(mKey);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void clearData() {
        try {
            diskLruCache.delete();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    File getDiskCacheDir(Context context, String uniqueName) {
        final String cachePath = Environment.MEDIA_MOUNTED.equals(Environment.getExternalStorageState()) ||!Environment.isExternalStorageRemovable()
                ? context.getExternalCacheDir().getPath()
                : context.getCacheDir().getPath();
        return new File(cachePath + File.separator + uniqueName);
    }


}
