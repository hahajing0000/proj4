package com.zy.net;

import android.text.TextUtils;

import com.zy.commonlib.log.ZLog;
import com.zy.net.api.TokenApi;
import com.zy.net.common.Config;
import com.zy.net.protocol.resp.TokenRespEntity;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * @author:zhangyue
 * @date:2020/4/17
 */
public class RetrofitFactory {
    private static RetrofitFactory instance=new RetrofitFactory();
    private Retrofit retrofit;

    private RetrofitFactory(){
        initRetrofit();
    }
    public static RetrofitFactory getInstance(){
        return instance;
    }

    /**
     * 初始化Retrofit
     */
    private void initRetrofit(){
        retrofit = new Retrofit.Builder()
                .baseUrl(Config.SERVER_URL)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                //.addCallAdapterFactory(LiveDataCallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .client(createOkHttpClient())
                .build();

    }

    /**
     * 创建OKHttpClient
     * @return
     */
    private OkHttpClient createOkHttpClient() {
        return getBuilder().connectTimeout(Config.TIMEOUT, TimeUnit.SECONDS)
                .addNetworkInterceptor(createLogInterceptor())
                .addInterceptor(createRequestHeaderInterceptor())
                .addInterceptor(createRequestInterceptor())
                .readTimeout(Config.TIMEOUT,TimeUnit.SECONDS)
                .writeTimeout(Config.TIMEOUT,TimeUnit.SECONDS)
                .build();
    }



    /**
     * 创建OkHttpClient Builder
     * @return
     */
    private OkHttpClient.Builder getBuilder() {
        OkHttpClient.Builder builder = new OkHttpClient().newBuilder();
        return builder;
    }



    /**
     * 添加token头信息
     * @param token
     */
    public void addTokenInterceptor(String token){
        getBuilder().addInterceptor(createTokenInterceptor(token));
    }

    /**
     * 创建服务器请求
     * @param service
     * @param <T>
     * @return
     */
    public <T> T create(Class<T> service){
        return retrofit.create(service);
    }

    /**
     * 创建日志拦截器
     * @return
     */
    private Interceptor createLogInterceptor() {
        HttpLoggingInterceptor httpLoggingInterceptor=new HttpLoggingInterceptor();
        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        return httpLoggingInterceptor;
    }

    /**
     * 创建请求拦截器
     * @return
     */
    private Interceptor createRequestHeaderInterceptor() {

        Interceptor interceptor=new Interceptor() {
            @Override
            public Response intercept(Chain chain) throws IOException {
                Request request = chain.request();
                Request newRequest = request.newBuilder().addHeader("Content-Type", "application-json")
                        .addHeader("charset", "utf-8").build();

                return chain.proceed(newRequest);
            }
        };
        return interceptor;
    }

    private Interceptor createRequestInterceptor(){
        Interceptor interceptor = new Interceptor() {
            @Override
            public Response intercept(Chain chain) throws IOException {
                Request request = chain.request();
                Response response = chain.proceed(request);

                //如果是401 同步请求Token然后加载到新请求的Header里，重新发起业务请求
                if (checkHttpCode401(response)){
                    String token=requestToken();
                    if (TextUtils.isEmpty(token)){
                        ZLog.e("Error : token is null...");
                    }
                    //Request newRequest=chain.request();
                    Request.Builder newBuilder = request.newBuilder().addHeader("Authorization", "bearer " + token);

                    Request newRequest=newBuilder.build();
                    return chain.proceed(newRequest);
                }
                return response;
            }
        };

        return interceptor;
    }

    /**
     * 获取Token的同步网络请求
     * @return
     */
    private String requestToken() {

        TokenApi tokenApi = create(TokenApi.class);
        Call<TokenRespEntity> tokenService = tokenApi.getToken("password", Config.AUTHCODE, "");
        try {
            retrofit2.Response<TokenRespEntity> result = tokenService.execute();
            if (result!=null&&result.body()!=null){
                return  result.body().getAccess_token();
            }
        } catch (IOException e) {
            ZLog.e(e.getMessage());
        }
        return "";
    }

    /**
     * 判断HTTP CODE 是否401 —— TOKEN失效
     * @param response
     * @return
     */
    private boolean checkHttpCode401(Response response) {
        if (null==response){
            return false;
        }

        if (response.code()==401){
            return true;
        }
        else{
            return false;
        }
    }

    /**
     * 创建Token拦截器
     * @param token
     * @return
     */
    private Interceptor createTokenInterceptor(final String token) {
        Interceptor interceptor=new Interceptor() {
            @Override
            public Response intercept(Chain chain) throws IOException {
                Request request = chain.request();
                request.newBuilder().addHeader("Authorization","bearer "+token);
                return chain.proceed(request);
            }
        };
        return interceptor;
    }
}
