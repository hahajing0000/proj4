package com.zy.home.net.repository;

import com.zy.home.callback.IResultCallback;
import com.zy.home.contract.HomeContract;
import com.zy.home.net.service.HomeService;

/**
 * @author:zhangyue
 * @date:2020/4/16
 */
public class HomeRepository extends HomeContract.HomeRepository {

    @Override
    protected void createModel() {
        mModel= new HomeService();
    }

    @Override
    public void getValue(IResultCallback<String> resultCallback) {
        mModel.getValue(resultCallback);
    }
}
