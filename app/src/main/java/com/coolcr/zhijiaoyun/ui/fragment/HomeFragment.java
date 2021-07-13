package com.coolcr.zhijiaoyun.ui.fragment;

import android.view.View;

import com.coolcr.zhijiaoyun.R;
import com.coolcr.zhijiaoyun.base.BaseFragment;
import com.coolcr.zhijiaoyun.presenter.impl.HomePresenter;
import com.coolcr.zhijiaoyun.utils.PresenterManger;
import com.coolcr.zhijiaoyun.view.IHomeCallback;

/**
 * Created by CoolCrush
 * On 2021/7/13
 * Email CoolCrush@126.com
 */
public class HomeFragment extends BaseFragment implements IHomeCallback {

    private HomePresenter mHomePresenter;

    @Override
    protected int getRootViewResId() {
        return R.layout.fragment_home;
    }

    @Override
    protected void initView(View rootView) {
        setUpState(State.SUCCESS);
    }

    @Override
    protected void initPresenter() {
        mHomePresenter = PresenterManger.getOurInstance().getHomePresenter();
        mHomePresenter.registerViewCallback(this);
    }

    @Override
    protected void loadData() {
        mHomePresenter.getMyCourse();
    }

    @Override
    public void onLoading() {

    }

    @Override
    public void onError() {

    }

    @Override
    public void onEmpty() {

    }
}
