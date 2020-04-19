package com.zy.net.retrofit.converter;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.parser.ParserConfig;
import com.zy.commonlib.log.ZLog;

import java.io.IOException;
import java.lang.reflect.Type;

import okhttp3.ResponseBody;
import okio.BufferedSource;
import okio.Okio;
import retrofit2.Converter;

/**
 * @author:zhangyue
 * @date:2020/4/19
 * FastJson格式化中对ResponseBody的解析（反序列化）
 */
public class FastJsonResponseBodyConverter<T> implements Converter<ResponseBody,T> {
    private Type mType;
    public FastJsonResponseBodyConverter(Type _t){
        this.mType=_t;
    }

    @Override
    public T convert(ResponseBody value) throws IOException {
        BufferedSource buffer=null;
        try{
            buffer = Okio.buffer(value.source());
            String s = buffer.readUtf8();
            return (T) JSON.parseObject(s,mType);
        }
        catch (Exception ex){
            ZLog.e(ex.getMessage());
        }
        finally {
            if (null!=buffer){
                buffer.close();
            }
        }
        return null;
    }
}
