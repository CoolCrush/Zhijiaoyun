package com.coolcr.zhijiaoyun.utils;

import android.util.Log;

public class LogUtils {
    // 当前等级
    private static int currentLev = 4;
    private static final int DEBUG_LEV = 4;
    private static final int INFO_LEV = 3;
    private static final int WARNING_LEV = 2;
    private static final int ERROR_LEV = 1;

    public static void d(Object object, String msg) {
        if (currentLev >= DEBUG_LEV) {
            Log.d(object.getClass().getSimpleName(), msg);
        }
    }

    public static void i(Object object, String msg) {
        if (currentLev >= INFO_LEV) {
            Log.d(object.getClass().getSimpleName(), msg);
        }
    }

    public static void w(Object object, String msg) {
        if (currentLev >= WARNING_LEV) {
            Log.d(object.getClass().getSimpleName(), msg);
        }
    }

    public static void e(Object object, String msg) {
        if (currentLev >= ERROR_LEV) {
            Log.d(object.getClass().getSimpleName(), msg);
        }
    }
}
