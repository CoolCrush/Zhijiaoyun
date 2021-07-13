package com.coolcr.zhijiaoyun.ui.activity;

import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;

import com.coolcr.zhijiaoyun.R;
import com.coolcr.zhijiaoyun.base.BaseActivity;
import com.coolcr.zhijiaoyun.base.BaseApplication;
import com.coolcr.zhijiaoyun.model.domain.SignInEntity;
import com.coolcr.zhijiaoyun.model.domain.UserLoginBean;
import com.coolcr.zhijiaoyun.presenter.ILoginPresenter;
import com.coolcr.zhijiaoyun.presenter.impl.LoginPresenterImpl;
import com.coolcr.zhijiaoyun.ui.MainActivity;
import com.coolcr.zhijiaoyun.ui.adapter.LoginHistoryAdapter;
import com.coolcr.zhijiaoyun.ui.popupwindow.LoginHistoryPopupWindow;
import com.coolcr.zhijiaoyun.utils.PresenterManger;
import com.coolcr.zhijiaoyun.utils.ToastUtils;
import com.coolcr.zhijiaoyun.view.ILoginCallback;

import java.util.Collections;
import java.util.List;

import butterknife.BindView;

public class LoginActivity extends BaseActivity implements ILoginCallback {

    @BindView(R.id.etUsername)
    EditText etUsername;
    @BindView(R.id.etPassword)
    EditText etPassword;
    @BindView(R.id.cbRemember)
    CheckBox cbRemember;
    @BindView(R.id.btnLogin)
    Button btnLogin;
    @BindView(R.id.imgHistory)
    ImageView imgHistory;

    private ILoginPresenter mLoginPresenter;
    private LoginHistoryPopupWindow mPopupWindow;

    @Override
    protected void initPresenter() {
        mLoginPresenter = PresenterManger.getOurInstance().getLoginPresenter();
        mLoginPresenter.registerViewCallback(this);
    }

    @Override
    protected void initView() {
        mPopupWindow = new LoginHistoryPopupWindow();
    }

    @Override
    protected int getLayoutResId() {
        return R.layout.activity_login;
    }

    @Override
    protected void loadData() {

    }

    @Override
    protected void initEven() {
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = etUsername.getText().toString().trim();
                String password = etPassword.getText().toString().trim();
                boolean isRemember = cbRemember.isChecked();
                if (TextUtils.isEmpty(username) || TextUtils.isEmpty(password)) {
                    ToastUtils.showToast(getString(R.string.login_empty));
                } else {
                    mLoginPresenter.login(username, password, isRemember);
                }
            }
        });

        imgHistory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //获取登录历史记录
                mLoginPresenter.getLoginHistory();
            }
        });

        //弹窗点击，删除、选择
        mPopupWindow.setOnHistoryClickListener(new LoginHistoryAdapter.OnHistoryClickListener() {
            @Override
            public void onTextViewClick(int position, UserLoginBean data) {
                etUsername.setText(data.getUsername());
                if (data.isRemember()) {
                    etPassword.setText(data.getPassword());
                } else {
                    etPassword.setText("");
                }
                cbRemember.setChecked(data.isRemember());
                mPopupWindow.dismiss();
            }

            @Override
            public void onRemoveClick(int position, UserLoginBean data) {
                mLoginPresenter.delLoginHistory(data.getUsername());
            }
        });

    }

    @Override
    public void onSingInResult(SignInEntity signInEntity) {
        ToastUtils.showToast(getString(R.string.login_success));
        BaseApplication.setSignInEntity(signInEntity);
        Intent intent = new Intent(LoginActivity.this, MainActivity.class);
        startActivity(intent);
    }

    /**
     * 获取历史记录成功
     *
     * @param userLoginBeans
     */
    @Override
    public void onHistorySuccess(List<UserLoginBean> userLoginBeans) {
        mPopupWindow.setData(userLoginBeans);
        mPopupWindow.showAsDropDown(etUsername);
    }

    @Override
    public void onLoading() {

    }

    @Override
    public void onError() {
        ToastUtils.showToast(getString(R.string.login_error));
    }

    @Override
    public void onEmpty() {

    }

    /**
     * 释放资源
     */
    @Override
    protected void release() {
        if (mLoginPresenter != null) {
            mLoginPresenter.unregisterViewCallback(this);
        }
    }
}