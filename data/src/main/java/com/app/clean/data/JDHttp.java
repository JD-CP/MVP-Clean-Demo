package com.app.clean.data;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Administrator on 2017/9/6.
 */

public class JDHttp {

    private static OkHttpClient.Builder sOkHttpBuilder;

    private static Retrofit retrofit = null;
    private static OkHttpClient okHttpClient = null;

    public static <K> K createApi(Class<K> cls) {
        return getRetrofit().create(cls);
    }

    private static Retrofit getRetrofit() {
        if (retrofit == null) {

            synchronized (JDHttp.class) {

                if (retrofit == null) {
                    sOkHttpBuilder = new OkHttpClient.Builder();
                    okHttpClient = sOkHttpBuilder
                            .readTimeout(60L, TimeUnit.SECONDS)// 读取超时
                            .writeTimeout(60L, TimeUnit.SECONDS)// 写入超时
                            .connectTimeout(60L, TimeUnit.SECONDS)// 连接超时
                            .build();
                    retrofit = new Retrofit.Builder()
                            .baseUrl("http://v.juhe.cn")
                            .client(okHttpClient)
                            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                            .addConverterFactory(GsonConverterFactory.create())
                            .build();
                }

            }

        }
        return retrofit;
    }

}
