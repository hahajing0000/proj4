package com.zy.usercenter.contract;

import com.zy.core.mvp.BasePresenter;
import com.zy.core.mvp.IModel;
import com.zy.core.mvp.IView;
import com.zy.core.mvp.Repository;
import com.zy.usercenter.model.protocol.resp.BaseResp;
import com.zy.usercenter.model.protocol.resp.TestUserEntity;
import com.zy.usercenter.model.protocol.resp.UserEntity;

import io.reactivex.Flowable;
import io.reactivex.Observable;

/**
 * @author:zhangyue
 * @date:2020/4/17
 */
public interface UserCenterContract {
    interface UserCenterView extends IView {
        /**
         * 用户注册成功
         */
        void registerSuccess();

        /**
         * 用户注册失败
         */
        void registerFailed();
    }

    interface UserCenterModel extends IModel{
        Observable<UserEntity> register(UserEntity userEntity);

        Observable<BaseResp<TestUserEntity>> register2(TestUserEntity testUserEntity);
    }

    abstract class UserCenterRepository extends Repository<UserCenterModel>{
       public abstract Observable<UserEntity> register(UserEntity userEntity);
       public abstract Observable<BaseResp<TestUserEntity>> register2(TestUserEntity testUserEntity);
    }

    abstract class UserCenterPresenter extends BasePresenter<UserCenterRepository,UserCenterView>{

        public UserCenterPresenter(UserCenterView userCenterView) {
            super(userCenterView);
        }

        public abstract void register(UserEntity userEntity);
        public abstract void register2(TestUserEntity testUserEntity);
    }

}
