package com.zy.home.service.repository;

import com.zy.core.mvp.IModel;
import com.zy.core.mvp.Repository;
import com.zy.home.callback.IResultCallback;
import com.zy.home.contract.HomeContract;
import com.zy.home.service.model.HomeModel;

/**
 * @author:zhangyue
 * @date:2020/4/16
 */
public class HomeRepository extends HomeContract.HomeRepository {

    @Override
    protected void createModel() {
        mModel= new HomeModel();
    }

    @Override
    public void getValue(IResultCallback<String> resultCallback) {
        mModel.getValue(resultCallback);
    }
}
