package com.zy.commonlib.log;

import android.util.Log;

/**
 * @author:zhangyue
 * @date:2020/4/16
 */
public class ZLogNormalImpl implements IZLog {
    private final String TAG="zhangyue";

    @Override
    public void d(String msg) {
        Log.d(TAG, msg);
    }

    @Override
    public void d(String tag, String msg) {
        msg=tag+" -> "+msg;
        d(msg);
    }

    @Override
    public void i(String msg) {
        Log.i(TAG, msg);
    }

    @Override
    public void i(String tag, String msg) {
        msg=tag+" -> "+msg;
        i(msg);
    }

    @Override
    public void w(String msg) {
        Log.w(TAG, msg);
    }

    @Override
    public void w(String tag, String msg) {
        msg=tag+" -> "+msg;
        w(msg);
    }

    @Override
    public void e(String msg) {
        Log.e(TAG, msg);
    }

    @Override
    public void e(String tag, String msg) {
        msg=tag+" -> "+msg;
        e(msg);
    }
}
