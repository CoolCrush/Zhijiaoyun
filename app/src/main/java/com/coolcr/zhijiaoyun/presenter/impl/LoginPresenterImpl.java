package com.coolcr.zhijiaoyun.presenter.impl;

import com.coolcr.zhijiaoyun.model.Api;
import com.coolcr.zhijiaoyun.model.domain.SignInEntity;
import com.coolcr.zhijiaoyun.model.domain.UserLoginBean;
import com.coolcr.zhijiaoyun.model.domain.UserLoginHistory;
import com.coolcr.zhijiaoyun.presenter.ILoginPresenter;
import com.coolcr.zhijiaoyun.utils.Constants;
import com.coolcr.zhijiaoyun.utils.JsonCacheUtil;
import com.coolcr.zhijiaoyun.utils.RetrofitManager;
import com.coolcr.zhijiaoyun.view.ILoginCallback;

import java.net.HttpURLConnection;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class LoginPresenterImpl implements ILoginPresenter {

    private ILoginCallback mViewCallback = null;
    private final Api mApi;
    private final JsonCacheUtil mJsonCacheUtil;

    public LoginPresenterImpl() {
        mJsonCacheUtil = JsonCacheUtil.getInstance();
        Retrofit retrofit = RetrofitManager.getInstance().getPhoneRetrofit();
        mApi = retrofit.create(Api.class);
    }

    @Override
    public void login(String username, String password, boolean isRemember) {
        if (mViewCallback != null) {
            String equipmentModel = android.os.Build.BRAND + " " + android.os.Build.MODEL;
            HashMap<String, String> signInParams = new HashMap<>();
            signInParams.put("clientId", "f47d9901259e48a982eb9af711410aba");
            signInParams.put("sourceType", "2");
            signInParams.put("userPwd", password);
            signInParams.put("userName", username);
            signInParams.put("appVersion", Constants.appVersion);
            signInParams.put("equipmentAppVersion", Constants.appVersion);
            signInParams.put("equipmentModel", equipmentModel);
            signInParams.put("equipmentApiVersion", Constants.equipmentApiVersion);
            long emit = new Date().getTime();
            String device = getDevice(signInParams.get("equipmentModel"), signInParams.get("equipmentApiVersion"), signInParams.get("equipmentAppVersion"), emit);
            Call<SignInEntity> task = mApi.login(emit, device, signInParams);
            task.enqueue(new Callback<SignInEntity>() {
                @Override
                public void onResponse(Call<SignInEntity> call, Response<SignInEntity> response) {
                    if (response.code() == HttpURLConnection.HTTP_OK) {
                        SignInEntity signInEntity = response.body();
                        if (signInEntity != null) {
                            if (signInEntity.getCode() == 1) {
                                saveLoginHistory(username, password, isRemember, signInEntity.getUrl());
                                mViewCallback.onSingInResult(signInEntity);
                            } else {
                                mViewCallback.onError();
                            }
                        }
                    }
                }

                @Override
                public void onFailure(Call<SignInEntity> call, Throwable t) {
                    mViewCallback.onError();
                }
            });
        }
    }

    private String getDevice(String equipmentModel, String equipmentApiVersion, String equipmentAppVersion, long emit) {
        String v1 = md5(equipmentModel);
        String v2 = v1 + equipmentApiVersion;
        String v3 = md5(v2);
        String v4 = v3 + equipmentAppVersion;
        String v5 = md5(v4);
        String v6 = v5 + emit;
        String result = md5(v6);
        return result;
    }

    /**
     * md5加密
     *
     * @param string
     * @return
     */
    private static String md5(String string) {
        if (string.isEmpty()) {
            return "";
        }
        MessageDigest md5 = null;
        try {
            md5 = MessageDigest.getInstance("MD5");
            byte[] bytes = md5.digest(string.getBytes());
            StringBuilder result = new StringBuilder();
            for (byte b : bytes) {
                String temp = Integer.toHexString(b & 0xff);
                if (temp.length() == 1) {
                    temp = "0" + temp;
                }
                result.append(temp);
            }
            return result.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return "";
    }

    public static final String KEY_LOGIN_HISTORY = "KEY_LOGIN_HISTORY";

    /**
     * 保存历史账号密码
     *
     * @param username
     * @param password
     * @param isRemember
     */
    private void saveLoginHistory(String username, String password, boolean isRemember, String imgUrl) {
        UserLoginHistory userLoginHistory = mJsonCacheUtil.getValue(KEY_LOGIN_HISTORY, UserLoginHistory.class);
        if (userLoginHistory != null) {
            List<UserLoginBean> userLoginBeans = userLoginHistory.getUserLoginBeans();
            if (userLoginBeans != null) {
                for (int i = 0; i < userLoginBeans.size(); i++) {
                    UserLoginBean userLoginBean = userLoginBeans.get(i);
                    if (username.equals(userLoginBean.getUsername())) {
                        userLoginBeans.remove(i);
                        break;
                    }
                }
            }
        } else {
            userLoginHistory = new UserLoginHistory();
        }

        List<UserLoginBean> userLoginBeans = userLoginHistory.getUserLoginBeans();
        if (userLoginBeans == null) {
            userLoginBeans = new ArrayList<>();
        }
        UserLoginBean userLoginBean = new UserLoginBean(username, password, isRemember, imgUrl);
        userLoginBeans.add(userLoginBean);
        userLoginHistory.setUserLoginBeans(userLoginBeans);
        mJsonCacheUtil.saveCache(KEY_LOGIN_HISTORY, userLoginHistory);
    }

    /**
     * 获取登录历史记录
     */
    @Override
    public void getLoginHistory() {
        UserLoginHistory userLoginHistory = mJsonCacheUtil.getValue(KEY_LOGIN_HISTORY, UserLoginHistory.class);
        if (userLoginHistory != null) {
            List<UserLoginBean> userLoginBeans = userLoginHistory.getUserLoginBeans();
            //让新数据在前面
            Collections.reverse(userLoginBeans);
            mViewCallback.onHistorySuccess(userLoginBeans);
        }
    }


    /**
     * 删除登录历史记录
     *
     * @param username
     */
    @Override
    public void delLoginHistory(String username) {
        UserLoginHistory userLoginHistory = mJsonCacheUtil.getValue(KEY_LOGIN_HISTORY, UserLoginHistory.class);
        if (userLoginHistory != null) {
            List<UserLoginBean> userLoginBeans = userLoginHistory.getUserLoginBeans();
            //获取迭代器
            Iterator<UserLoginBean> iterator = userLoginBeans.iterator();
            while (iterator.hasNext()) {
                UserLoginBean userLoginBean = iterator.next();
                if (userLoginBean.getUsername().equals(username)) {
                    //删除迭代器自身
                    iterator.remove();
                    break;
                }
            }
            userLoginHistory.setUserLoginBeans(userLoginBeans);
            mJsonCacheUtil.saveCache(KEY_LOGIN_HISTORY, userLoginHistory);
            getLoginHistory();
        }
    }

    @Override
    public void registerViewCallback(ILoginCallback callback) {
        this.mViewCallback = callback;
    }

    @Override
    public void unregisterViewCallback(ILoginCallback callback) {
        mViewCallback = null;
    }
}
