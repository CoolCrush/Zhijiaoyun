package com.coolcr.zhijiaoyun.ui.popupwindow;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.PopupWindow;

import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.coolcr.zhijiaoyun.R;
import com.coolcr.zhijiaoyun.base.BaseApplication;
import com.coolcr.zhijiaoyun.model.domain.UserLoginBean;
import com.coolcr.zhijiaoyun.ui.adapter.LoginHistoryAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by CoolCrush
 * On 2021/7/12
 * Email CoolCrush@126.com
 */
public class LoginHistoryPopupWindow extends PopupWindow {

    private LoginHistoryAdapter mAdapter;
    private RecyclerView recyclerView;
    private LoginHistoryAdapter.OnHistoryClickListener onHistoryClickListener = null;

    public LoginHistoryPopupWindow() {
        //设置布局
        View rootView = LayoutInflater.from(BaseApplication.getAppContext()).inflate(R.layout.popup_window_login_list, null);
        initView(rootView);
        initEvent();
        int width = ViewGroup.LayoutParams.MATCH_PARENT;
        int height = 600;
        setContentView(rootView);
        setOutsideTouchable(true);
        setWidth(width);
        setHeight(height);
    }

    private void initEvent() {
    }

    private void initView(View rootView) {
        Context appContext = BaseApplication.getAppContext();
        recyclerView = rootView.findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(appContext, RecyclerView.VERTICAL, false));
        //设置分割线
        recyclerView.addItemDecoration(new DividerItemDecoration(appContext, DividerItemDecoration.VERTICAL));
        mAdapter = new LoginHistoryAdapter();
        recyclerView.setAdapter(mAdapter);
    }

    public void setData(List<UserLoginBean> userLoginBeans) {
        mAdapter.setData(userLoginBeans);
    }

    public void setOnHistoryClickListener(LoginHistoryAdapter.OnHistoryClickListener onHistoryClickListener) {
        mAdapter.setOnHistoryClickListener(onHistoryClickListener);
    }
}
