package com.coolcr.zhijiaoyun.presenter.impl;

import com.coolcr.zhijiaoyun.model.Api;
import com.coolcr.zhijiaoyun.model.domain.TestEntity;
import com.coolcr.zhijiaoyun.presenter.IHomePresenter;
import com.coolcr.zhijiaoyun.utils.RetrofitManager;
import com.coolcr.zhijiaoyun.view.IHomeCallback;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

/**
 * Created by CoolCrush
 * On 2021/7/13
 * Email CoolCrush@126.com
 */
public class HomePresenter implements IHomePresenter {

    private IHomeCallback mViewCallback = null;
    private final Api mApi;

    public HomePresenter() {
        Retrofit retrofit = RetrofitManager.getInstance().getPhoneRetrofit();
        mApi = retrofit.create(Api.class);
    }

    @Override
    public void getMyCourse() {
        Call<TestEntity> task = mApi.getMyCourse("https://mooc.icve.com.cn/portal/Course/getMyCourse?isFinished=0&page=1&pageSize=8");
        task.enqueue(new Callback<TestEntity>() {
            @Override
            public void onResponse(Call<TestEntity> call, Response<TestEntity> response) {

            }

            @Override
            public void onFailure(Call<TestEntity> call, Throwable t) {

            }
        });
    }

    @Override
    public void registerViewCallback(IHomeCallback callback) {
        mViewCallback = callback;
    }

    @Override
    public void unregisterViewCallback(IHomeCallback callback) {
        mViewCallback = null;
    }

}
