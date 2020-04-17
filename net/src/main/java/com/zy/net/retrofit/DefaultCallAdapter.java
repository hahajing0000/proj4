package com.zy.net.retrofit;

import java.lang.reflect.Type;

import retrofit2.Call;
import retrofit2.CallAdapter;

/**
 * @author:zhangyue
 * @date:2020/4/17
 */
public class DefaultCallAdapter<R> implements CallAdapter<R, Object> {
    Type type;
    public DefaultCallAdapter(Type _t){
        type=_t;
    }
    @Override
    public Type responseType() {
        return type;
    }

    @Override
    public Object adapt(Call<R> call) {
        return call;
    }
}
