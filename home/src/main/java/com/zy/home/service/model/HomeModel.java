package com.zy.home.service.model;

import com.zy.core.mvp.IModel;
import com.zy.home.callback.IResultCallback;
import com.zy.home.contract.HomeContract;

/**
 * @author:zhangyue
 * @date:2020/4/16
 */
public class HomeModel implements HomeContract.HomeModel {
    @Override
    public void destory() {

    }


    @Override
    public void getValue(IResultCallback<String> resultCallback) {
        //模拟网络请求
        resultCallback.getValue("模拟网络请求返回的结果数据");
    }
}
