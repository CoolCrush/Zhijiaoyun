package com.coolcr.zhijiaoyun.base;


public interface IBaseCallback {

    /**
     * 加载中
     */
    void onLoading();

    /**
     * 网络错误
     */
    void onError();

    /**
     * 数据为空
     */
    void onEmpty();
}

