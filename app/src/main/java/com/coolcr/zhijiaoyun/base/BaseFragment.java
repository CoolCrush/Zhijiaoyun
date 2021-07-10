package com.coolcr.zhijiaoyun.base;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;


import com.coolcr.zhijiaoyun.R;
import com.coolcr.zhijiaoyun.utils.LogUtils;

import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

public abstract class BaseFragment extends Fragment {

    private State currentState = State.NONE;
    private View mSuccessView;
    private View mLoadingView;
    private View mErrorView;
    private View mEmptyView;

    public enum State {
        NONE, LOADING, SUCCESS, ERROR, EMPTY
    }

    private Unbinder mBind;
    private FrameLayout mFlBaseContainer;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = loadRootView(inflater, container);
        mFlBaseContainer = rootView.findViewById(R.id.flBaseContainer);
        loadRootView(inflater, container);
        loadStateView(inflater, container);
        mBind = ButterKnife.bind(this, rootView);
        initView(rootView);
        initEvent();
        initPresenter();
        loadData();
        return rootView;
    }

    /**
     * 子类可以复写
     */
    protected void initEvent() {

    }

    protected View loadRootView(LayoutInflater inflater, ViewGroup container) {
        return inflater.inflate(R.layout.base_fragment_layout, container, false);
    }

    /**
     * 加载各种状态的View
     *
     * @param inflater
     * @param container
     */
    private void loadStateView(LayoutInflater inflater, ViewGroup container) {
        //成功的View
        mSuccessView = loadSuccessView(inflater, container);
        mFlBaseContainer.addView(mSuccessView);
        //Loading的View
        mLoadingView = loadLoadingView(inflater, container);
        mFlBaseContainer.addView(mLoadingView);
        //Error的View
        mErrorView = loadErrorView(inflater, container);
        mFlBaseContainer.addView(mErrorView);
        //Empty的View
        mEmptyView = loadEmptyView(inflater, container);
        mFlBaseContainer.addView(mEmptyView);

        setUpState(State.NONE);
    }

    /**
     * 子类可以通过该方法根据状态设置显示的页面
     *
     * @param state
     */
    public void setUpState(State state) {
        currentState = state;
        //根据状态设置显示的页面
        mSuccessView.setVisibility(currentState == State.SUCCESS ? View.VISIBLE : View.GONE);
        mLoadingView.setVisibility(currentState == State.LOADING ? View.VISIBLE : View.GONE);
        mErrorView.setVisibility(currentState == State.ERROR ? View.VISIBLE : View.GONE);
        mEmptyView.setVisibility(currentState == State.EMPTY ? View.VISIBLE : View.GONE);
    }

    /**
     * 可以复写 LoadingView样式
     *
     * @param inflater
     * @param container
     * @return
     */
    protected View loadLoadingView(LayoutInflater inflater, ViewGroup container) {
        return inflater.inflate(R.layout.fragment_loading, container, false);
    }

    /**
     * 可以复写 ErrorView样式
     *
     * @param inflater
     * @param container
     * @return
     */
    protected View loadErrorView(LayoutInflater inflater, ViewGroup container) {
        return inflater.inflate(R.layout.fragment_error, container, false);
    }

    @OnClick(R.id.llError)
    public void retry() {
        LogUtils.d(this, "用户点击重试");
        onRetryClick();
    }

    /**
     * 如果子类需要网络错误以后的点击，就覆盖此方法
     */
    protected void onRetryClick() {

    }

    /**
     * 可以复写 EmptyView样式
     *
     * @param inflater
     * @param container
     * @return
     */
    protected View loadEmptyView(LayoutInflater inflater, ViewGroup container) {
        return inflater.inflate(R.layout.fragment_empty, container, false);
    }

    protected void initView(View rootView) {

    }

    protected void initPresenter() {
        //创建Presenter
    }

    /**
     * protected 允许复写
     */
    protected void loadData() {

    }

    protected View loadSuccessView(LayoutInflater inflater, ViewGroup container) {
        int resId = getRootViewResId();
        return inflater.inflate(resId, container, false);
    }

    protected abstract int getRootViewResId();

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        if (mBind != null) {
            mBind.unbind();
        }
        release();
    }

    protected void release() {

    }
}
