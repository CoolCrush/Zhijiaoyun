package com.coolcr.zhijiaoyun.utils;

import com.coolcr.zhijiaoyun.presenter.impl.LoginPresenterImpl;

/**
 * Created by CoolCrush
 * On 2021/7/11
 * Email CoolCrush@126.com
 */
public class PresenterManger {
    private final static PresenterManger ourInstance = new PresenterManger();
    private final LoginPresenterImpl mLoginPresenter;

    private PresenterManger() {
        mLoginPresenter = new LoginPresenterImpl();
    }

    public static PresenterManger getOurInstance() {
        return ourInstance;
    }

    public LoginPresenterImpl getLoginPresenter() {
        return mLoginPresenter;
    }
}
