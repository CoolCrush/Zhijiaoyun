package com.coolcr.zhijiaoyun.utils;

import android.widget.Toast;

import com.coolcr.zhijiaoyun.base.BaseApplication;


public class ToastUtils {
    private static Toast sToast;

    public static void showToast(String tips) {
        if (sToast == null) {
            sToast = Toast.makeText(BaseApplication.getAppContext(), tips, Toast.LENGTH_SHORT);
        } else {
            sToast.setText(tips);
        }
        sToast.show();
    }
}
