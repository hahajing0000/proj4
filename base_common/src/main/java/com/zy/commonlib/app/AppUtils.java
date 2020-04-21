package com.zy.commonlib.app;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;

import com.zy.commonlib.BuildConfig;

/**
 * @author:zhangyue
 * @date:2020/4/16
 */
public class AppUtils {

    /**
     * 判断当前是否是Debug模式
     * @param context
     * @return
     */
    public static boolean isDebug(Context context){
        try {
            ApplicationInfo applicationInfo = context.getApplicationInfo();
            return (applicationInfo.flags & ApplicationInfo.FLAG_DEBUGGABLE) != 0;
        }
        catch (Exception ex){
            return false;
        }
    }

    private static Context mContext;

    /**
     * 设置全局上下文
     * @param _context
     */
    public static void setContext(Context _context){
        mContext=_context;
    }

    /**
     * 获取Application Context
     * @return
     */
    public static Context getAppContext(){
        return mContext;
    }

    /**
     * 获取AppVersionCode
     * @param context
     * @return
     */
    public static int getAppVersionCode(Context context){
        try{
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 0);
            return packageInfo.versionCode;
        }
        catch (Exception ex){
            ex.printStackTrace();
        }
        return 1;
    }

    /**
     * 获取是否debug模式
     * @return
     */
    public static boolean getDebugMode(){
        return BuildConfig.isDebug;
    }
}
