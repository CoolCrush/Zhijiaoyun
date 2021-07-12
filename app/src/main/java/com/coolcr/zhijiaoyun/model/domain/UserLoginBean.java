package com.coolcr.zhijiaoyun.model.domain;

/**
 * Created by CoolCrush
 * On 2021/7/11
 * Email CoolCrush@126.com
 */
public class UserLoginBean {
    private String username;
    private String password;
    private boolean isRemember;
    private String imgUrl;

    public UserLoginBean() {
    }

    public UserLoginBean(String username, String password, boolean isRemember, String imgUrl) {
        this.username = username;
        this.password = password;
        this.isRemember = isRemember;
        this.imgUrl = imgUrl;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isRemember() {
        return isRemember;
    }

    public void setRemember(boolean remember) {
        isRemember = remember;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }
}
