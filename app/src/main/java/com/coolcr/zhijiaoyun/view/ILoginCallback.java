package com.coolcr.zhijiaoyun.view;

import com.coolcr.zhijiaoyun.base.IBaseCallback;
import com.coolcr.zhijiaoyun.model.domain.SignInEntity;
import com.coolcr.zhijiaoyun.model.domain.UserLoginBean;

import java.util.List;

public interface ILoginCallback extends IBaseCallback {

    /**
     * 登录成功返回
     *
     * @param signInEntity
     */
    void onSingInResult(SignInEntity signInEntity);

    /**
     * 获取历史登录记录成功
     *
     * @param userLoginBeans
     */
    void onHistorySuccess(List<UserLoginBean> userLoginBeans);
}
