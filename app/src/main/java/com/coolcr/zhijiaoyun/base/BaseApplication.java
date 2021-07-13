package com.coolcr.zhijiaoyun.base;

import android.app.Application;
import android.content.Context;

import com.coolcr.zhijiaoyun.model.domain.SignInEntity;


public class BaseApplication extends Application {

    private static Context appContext;
    private static SignInEntity signInEntity;

    @Override
    public void onCreate() {
        super.onCreate();
        appContext = getBaseContext();
    }

    public static Context getAppContext() {
        return appContext;
    }

    public static SignInEntity getSignInEntity() {
        return signInEntity;
    }

    public static void setSignInEntity(SignInEntity signInEntity) {
        BaseApplication.signInEntity = signInEntity;
    }
}
