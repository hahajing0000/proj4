package com.zy.usercenter.presenter;

import com.zy.net.rx.BaseObservable;
import com.zy.net.rx.BaseObserver;
import com.zy.usercenter.contract.UserCenterContract;
import com.zy.usercenter.model.protocol.resp.BaseResp;
import com.zy.usercenter.model.protocol.resp.TestUserEntity;
import com.zy.usercenter.model.protocol.resp.UserEntity;
import com.zy.usercenter.model.repository.UserCenterRepository;

import io.reactivex.Observable;

/**
 * @author:zhangyue
 * @date:2020/4/17
 */
public class UserCenterPresenter extends UserCenterContract.UserCenterPresenter {
    public UserCenterPresenter(UserCenterContract.UserCenterView userCenterView) {
        super(userCenterView);
    }

    @Override
    public void register(UserEntity userEntity) {
        Observable<UserEntity> register = mRepository.register(userEntity);
        BaseObservable.doObservable(register,new BaseObserver<UserEntity>(){
            @Override
            public void onNext(UserEntity userEntity) {
                super.onNext(userEntity);
                mView.get().registerSuccess();
            }

            @Override
            public void onError(Throwable e) {
                super.onError(e);
                mView.get().registerFailed();
            }
        },mView.get().getOwner());
    }

    @Override
    public void register2(TestUserEntity testUserEntity) {
        Observable<BaseResp<TestUserEntity>> baseRespObservable = mRepository.register2(testUserEntity);
        BaseObservable.doObservable(baseRespObservable,new BaseObserver<BaseResp<TestUserEntity>>(){
            @Override
            public void onNext(BaseResp<TestUserEntity> testUserEntityBaseResp) {
                super.onNext(testUserEntityBaseResp);
                mView.get().registerSuccess();
            }

            @Override
            public void onError(Throwable e) {
                super.onError(e);
                mView.get().registerFailed();
            }
        },mView.get().getOwner());
    }

    @Override
    protected void createRepository() {
        mRepository=new UserCenterRepository();
    }
}
