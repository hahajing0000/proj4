package com.zy.usercenter.model.repository;

import com.zy.usercenter.contract.UserCenterContract;
import com.zy.usercenter.model.protocol.resp.UserEntity;
import com.zy.usercenter.model.service.UserCenterService;

import io.reactivex.Flowable;
import io.reactivex.Observable;

/**
 * @author:zhangyue
 * @date:2020/4/17
 */
public class UserCenterRepository extends UserCenterContract.UserCenterRepository {

    @Override
    public Observable<UserEntity> register(UserEntity userEntity) {
        return mModel.register(userEntity);
    }

    @Override
    protected void createModel() {
        mModel=new UserCenterService();
    }
}
