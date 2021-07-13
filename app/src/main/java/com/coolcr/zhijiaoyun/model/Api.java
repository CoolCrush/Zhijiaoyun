package com.coolcr.zhijiaoyun.model;

import com.coolcr.zhijiaoyun.model.domain.SignInEntity;
import com.coolcr.zhijiaoyun.model.domain.TestEntity;

import java.util.Map;

import retrofit2.Call;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Url;

public interface Api {

    @FormUrlEncoded
    @POST("MobileLogin/newSignIn")
    Call<SignInEntity> login(@Header("emit") long emit, @Header("device") String device, @FieldMap Map<String, String> signInParams);

    @GET
    Call<TestEntity> getMyCourse(@Url String url);

}
