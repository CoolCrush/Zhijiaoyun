package com.coolcr.zhijiaoyun.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.widget.FrameLayout;

import com.coolcr.zhijiaoyun.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import butterknife.BindView;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.mainFrameLayout)
    FrameLayout mFrameLayout;
    @BindView(R.id.mainNavigationView)
    BottomNavigationView mNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }
}