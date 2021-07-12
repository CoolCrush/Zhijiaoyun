package com.coolcr.zhijiaoyun.model;

import com.coolcr.zhijiaoyun.model.domain.SignInEntity;

import java.util.Map;

import retrofit2.Call;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.Header;
import retrofit2.http.POST;

public interface Api {

    @FormUrlEncoded
    @POST("MobileLogin/newSignIn")
    Call<SignInEntity> login(@Header("emit") long emit, @Header("device") String device, @FieldMap Map<String, String> signInParams);

}
