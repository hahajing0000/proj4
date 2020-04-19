package com.zy.usercenter.model.service;

import com.zy.net.RetrofitFactory;
import com.zy.usercenter.contract.UserCenterContract;
import com.zy.usercenter.model.api.UserApi;
import com.zy.usercenter.model.protocol.resp.UserEntity;

import io.reactivex.Observable;

/**
 * @author:zhangyue
 * @date:2020/4/17
 */
public class UserCenterService implements UserCenterContract.UserCenterModel {
    @Override
    public Observable<UserEntity> register(UserEntity userEntity) {
        UserApi userApi = RetrofitFactory.getInstance().create(UserApi.class);
        return userApi.register(userEntity);
    }

    @Override
    public void destory() {

    }
}
