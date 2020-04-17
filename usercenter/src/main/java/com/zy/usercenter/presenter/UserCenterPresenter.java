package com.zy.usercenter.presenter;

import com.zy.net.rx.BaseObservable;
import com.zy.net.rx.BaseObserver;
import com.zy.usercenter.contract.UserCenterContract;
import com.zy.usercenter.model.protocol.resp.UserEntity;
import com.zy.usercenter.model.repository.UserCenterRepository;

import org.reactivestreams.Subscription;

import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.Observable;
import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.subscribers.DefaultSubscriber;
import io.reactivex.subscribers.DisposableSubscriber;

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
    protected void createRepository() {
        mRepository=new UserCenterRepository();
    }
}
