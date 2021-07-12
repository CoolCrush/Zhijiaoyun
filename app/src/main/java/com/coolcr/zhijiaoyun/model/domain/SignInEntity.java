package com.coolcr.zhijiaoyun.model.domain;

public class SignInEntity {

    private Integer code;
    private Integer userType;
    private String token;
    private String userName;
    private String secondUserName;
    private String userId;
    private String newToken;
    private String displayName;
    private String employeeNumber;
    private String url;
    private String schoolName;
    private String schoolId;
    private Integer isValid;
    private Integer isNeedMergeUserName;
    private Integer isZjyUser;
    private Integer isGameUser;
    private Integer isNeedUpdatePwd;
    private String pwdMsg;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public Integer getUserType() {
        return userType;
    }

    public void setUserType(Integer userType) {
        this.userType = userType;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getSecondUserName() {
        return secondUserName;
    }

    public void setSecondUserName(String secondUserName) {
        this.secondUserName = secondUserName;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getNewToken() {
        return newToken;
    }

    public void setNewToken(String newToken) {
        this.newToken = newToken;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public String getEmployeeNumber() {
        return employeeNumber;
    }

    public void setEmployeeNumber(String employeeNumber) {
        this.employeeNumber = employeeNumber;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getSchoolName() {
        return schoolName;
    }

    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName;
    }

    public String getSchoolId() {
        return schoolId;
    }

    public void setSchoolId(String schoolId) {
        this.schoolId = schoolId;
    }

    public Integer getIsValid() {
        return isValid;
    }

    public void setIsValid(Integer isValid) {
        this.isValid = isValid;
    }

    public Integer getIsNeedMergeUserName() {
        return isNeedMergeUserName;
    }

    public void setIsNeedMergeUserName(Integer isNeedMergeUserName) {
        this.isNeedMergeUserName = isNeedMergeUserName;
    }

    public Integer getIsZjyUser() {
        return isZjyUser;
    }

    public void setIsZjyUser(Integer isZjyUser) {
        this.isZjyUser = isZjyUser;
    }

    public Integer getIsGameUser() {
        return isGameUser;
    }

    public void setIsGameUser(Integer isGameUser) {
        this.isGameUser = isGameUser;
    }

    public Integer getIsNeedUpdatePwd() {
        return isNeedUpdatePwd;
    }

    public void setIsNeedUpdatePwd(Integer isNeedUpdatePwd) {
        this.isNeedUpdatePwd = isNeedUpdatePwd;
    }

    public String getPwdMsg() {
        return pwdMsg;
    }

    public void setPwdMsg(String pwdMsg) {
        this.pwdMsg = pwdMsg;
    }
}
