package com.coolcr.zhijiaoyun.utils;

import android.content.Context;
import android.content.SharedPreferences;

import com.coolcr.zhijiaoyun.base.BaseApplication;
import com.coolcr.zhijiaoyun.model.domain.CacheWithDuration;
import com.google.gson.Gson;

public class JsonCacheUtil {
    public static final String JSON_CACHE_SP_NAME = "json_cache_sp_name";
    private final SharedPreferences mSharedPreferences;
    private final Gson mGson;

    private JsonCacheUtil() {
        mSharedPreferences = BaseApplication.getAppContext().getSharedPreferences(JSON_CACHE_SP_NAME, Context.MODE_PRIVATE);
        mGson = new Gson();
    }

    /**
     * 保存
     *
     * @param key
     * @param value
     */
    public void saveCache(String key, Object value) {
        saveCache(key, value, -1L);
    }

    public void saveCache(String key, Object value, long duration) {
        SharedPreferences.Editor edit = mSharedPreferences.edit();
        String valueStr = mGson.toJson(value);
        if (duration != -1) {
            duration += System.currentTimeMillis();
        }

        CacheWithDuration cacheWithDuration = new CacheWithDuration(duration, valueStr);
        String cache = mGson.toJson(cacheWithDuration);
        edit.putString(key, cache);
        edit.apply();
    }

    public void delCache(String key) {
        mSharedPreferences.edit().remove(key).apply();
    }

    public <T> T getValue(String key, Class<T> clazz) {
        String valueWithDuration = mSharedPreferences.getString(key, null);
        if (valueWithDuration == null) {
            return null;
        }
        CacheWithDuration cacheWithDuration = mGson.fromJson(valueWithDuration, CacheWithDuration.class);
        //对事件进行判断
        long duration = cacheWithDuration.getDuration();
        if (duration != -1 && duration - System.currentTimeMillis() <= 0) {
            //数据过期了
            return null;
        } else {
            //数据没过期
            String cache = cacheWithDuration.getCache();
            T result = mGson.fromJson(cache, clazz);
            return result;
        }
    }


    private static JsonCacheUtil sJsonCacheUtil = null;

    public static JsonCacheUtil getInstance() {
        if (sJsonCacheUtil == null) {
            sJsonCacheUtil = new JsonCacheUtil();
        }
        return sJsonCacheUtil;
    }
}
