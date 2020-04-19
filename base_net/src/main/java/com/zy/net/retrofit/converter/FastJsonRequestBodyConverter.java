package com.zy.net.retrofit.converter;

import com.alibaba.fastjson.JSON;

import java.io.IOException;

import okhttp3.MediaType;
import okhttp3.RequestBody;
import retrofit2.Converter;

/**
 * @author:zhangyue
 * @date:2020/4/19
 * FastJson格式化工厂中对RequestBody的序列化
 */
public class FastJsonRequestBodyConverter<T> implements Converter<T, RequestBody> {
    private static final MediaType MEDIA_TYPE = MediaType.parse("application/json; charset=UTF-8");
    @Override
    public RequestBody convert(T value) throws IOException {

        return RequestBody.create(MEDIA_TYPE, JSON.toJSONBytes(value));
    }
}
