package com.coolcr.zhijiaoyun.model.domain;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by CoolCrush
 * On 2021/7/11
 * Email CoolCrush@126.com
 */
public class UserLoginHistory {
    private List<UserLoginBean> mUserLoginBeans = null;

    public List<UserLoginBean> getUserLoginBeans() {
        return mUserLoginBeans;
    }

    public void setUserLoginBeans(List<UserLoginBean> userLoginBeans) {
        mUserLoginBeans = userLoginBeans;
    }
}
