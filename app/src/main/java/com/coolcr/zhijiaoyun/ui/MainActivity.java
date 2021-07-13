package com.coolcr.zhijiaoyun.ui;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.FrameLayout;

import com.coolcr.zhijiaoyun.R;
import com.coolcr.zhijiaoyun.base.BaseFragment;
import com.coolcr.zhijiaoyun.ui.fragment.AboutFragment;
import com.coolcr.zhijiaoyun.ui.fragment.HomeFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.mainFrameLayout)
    FrameLayout mFrameLayout;
    @BindView(R.id.mainNavigationView)
    BottomNavigationView mNavigationView;
    private HomeFragment mHomeFragment;
    private AboutFragment mAboutFragment;
    private FragmentManager mSupportFragmentManager;
    private Unbinder mBind;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mBind = ButterKnife.bind(this);
        mHomeFragment = new HomeFragment();
        mAboutFragment = new AboutFragment();


        switchFragment(mHomeFragment);

        mNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                if (menuItem.getItemId() == R.id.menuHome) {
                    switchFragment(mHomeFragment);
                } else if (menuItem.getItemId() == R.id.menuAbout) {
                    switchFragment(mAboutFragment);
                }
                return true;
            }
        });

    }

    /**
     * 切换界面
     *
     * @param fragment
     */
    private void switchFragment(Fragment fragment) {
        mSupportFragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = mSupportFragmentManager.beginTransaction();
        transaction.replace(R.id.mainFrameLayout, fragment);
        transaction.commit();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mBind != null) {
            mBind.unbind();
        }
    }
}