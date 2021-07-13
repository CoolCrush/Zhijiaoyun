package com.coolcr.zhijiaoyun.utils;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitManager {
    private static RetrofitManager ourInstance = null;
    private final Retrofit mPhoneRetrofit;

    /**
     * 获取单例
     *
     * @return
     */
    public static RetrofitManager getInstance() {
        if (ourInstance == null) {
            synchronized (RetrofitManager.class) {
                if (ourInstance == null) {
                    ourInstance = new RetrofitManager();
                }
            }
        }
        return ourInstance;
    }

    private RetrofitManager() {

        //创建RetrofitManager
        mPhoneRetrofit = new Retrofit.Builder()
                .baseUrl(Constants.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    public Retrofit getPhoneRetrofit() {
        return mPhoneRetrofit;
    }
}
