package com.zy.commonlib.log;

/**
 * @author:zhangyue
 * @date:2020/4/16
 */
public interface IZLog {
    //Debug
    void d(String msg);
    void d(String tag,String msg);

    //Info
    void i(String msg);
    void i(String tag,String msg);

    //warning
    void w(String msg);
    void w(String tag,String msg);

    //error
    void e(String msg);
    void e(String tag,String msg);
}
