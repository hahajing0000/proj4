package com.zy.commonlib.log;

import com.zy.commonlib.app.AppUtils;

/**
 * @author:zhangyue
 * @date:2020/4/16
 */
public class ZLog {
    private static IZLog mLog;
    //是否Debug模式
    private static boolean isDebug= AppUtils.getDebugMode();

    static {
        mLog=new ZLogNormalImpl();
    }

    /**
     * 构造中初始化默认的ZLog
     */
    private ZLog(){

    }

    /**
     * 可以在外部修改Log输出方式
     * @param log
     */
    public static void changeLog(IZLog log){
        mLog=log;
    }

    /**
     * 开启/关闭日志
     * @param _debug
     */
    public static void setDebugMode(boolean _debug){
        isDebug=_debug;
    }

    //Debug
    public static void d(String msg){
        if(isDebug) {
            mLog.d(msg);
        }
    }
    public static void d(String tag,String msg){
        if (isDebug){
            mLog.d(tag,msg);
        }

    }

    //Info
    public static void i(String msg){
       if (isDebug){
           mLog.i(msg);
       }
    }
    public static void i(String tag,String msg){
        if (isDebug){
            mLog.i(tag,msg);
        }
    }

    //warning
    public static void w(String msg){
        if (isDebug){
            mLog.w(msg);
        }
    }
    public static void w(String tag,String msg){
       if (isDebug){
           mLog.w(tag,msg);
       }
    }

    //error
    public static void e(String msg){
        if (isDebug){
            mLog.e(msg);
        }
    }
    public static void e(String tag,String msg){
       if (isDebug){
           mLog.e(tag,msg);
       }
    }
}
