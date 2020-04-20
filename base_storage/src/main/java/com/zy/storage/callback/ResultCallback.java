package com.zy.storage.callback;

/**
 * @author:zhangyue
 * @date:2020/4/19
 * 回调结果数据
 */
public interface ResultCallback<T> {
  void getData(T result);
}
