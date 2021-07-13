package com.coolcr.zhijiaoyun.presenter;

import com.coolcr.zhijiaoyun.base.IBasePresenter;
import com.coolcr.zhijiaoyun.view.IHomeCallback;

/**
 * Created by CoolCrush
 * On 2021/7/13
 * Email CoolCrush@126.com
 */
public interface IHomePresenter extends IBasePresenter<IHomeCallback> {
    void getMyCourse();
}
