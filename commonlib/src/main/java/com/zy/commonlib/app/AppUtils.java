package com.zy.commonlib.app;

import android.content.Context;
import android.content.pm.ApplicationInfo;

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
}
