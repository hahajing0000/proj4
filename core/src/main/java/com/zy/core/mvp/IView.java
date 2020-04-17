package com.zy.core.mvp;

import androidx.lifecycle.LifecycleOwner;

/**
 * @author:zhangyue
 * @date:2020/4/16
 * V层基接口
 */
public interface IView {
    LifecycleOwner getOwner();
}
