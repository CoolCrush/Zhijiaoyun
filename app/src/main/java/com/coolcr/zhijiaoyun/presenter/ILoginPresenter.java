package com.coolcr.zhijiaoyun.presenter;

import com.coolcr.zhijiaoyun.base.IBasePresenter;
import com.coolcr.zhijiaoyun.view.ILoginCallback;

public interface ILoginPresenter extends IBasePresenter<ILoginCallback> {

    /**
     * zjy登录
     */
    void login(String username, String password, boolean isRemember);

    /**
     * 获取历史登录
     */
    void getLoginHistory();


    /**
     * 删除登录信息
     */
    void delLoginHistory(String username);
}
