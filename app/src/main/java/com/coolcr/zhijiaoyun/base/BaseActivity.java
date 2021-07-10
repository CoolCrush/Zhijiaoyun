package com.coolcr.zhijiaoyun.base;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import butterknife.ButterKnife;
import butterknife.Unbinder;

public abstract class BaseActivity extends AppCompatActivity {

    private Unbinder mBind;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutResId());
        mBind = ButterKnife.bind(this);
        initView();
        initEven();
        initPresenter();
        loadData();
    }

    /**
     * 需要加载数据就复写
     */
    protected void loadData() {

    }

    protected abstract void initPresenter();

    /**
     * 需要就复写
     */
    protected void initEven() {

    }

    protected abstract void initView();


    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mBind != null) {
            mBind.unbind();
        }
        this.release();
    }

    /**
     * 子类需要释放资源，覆盖此方法
     */
    protected void release() {

    }

    protected abstract int getLayoutResId();
}
