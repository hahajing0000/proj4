package com.zy.usercenter.model.api;

import com.zy.usercenter.model.protocol.resp.UserEntity;

import io.reactivex.Flowable;
import io.reactivex.Observable;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

/**
 * @author:zhangyue
 * @date:2020/4/17
 */
public interface UserApi {

    @POST("videouser/register")
    Observable<UserEntity> register(@Body UserEntity userEntity);
}
