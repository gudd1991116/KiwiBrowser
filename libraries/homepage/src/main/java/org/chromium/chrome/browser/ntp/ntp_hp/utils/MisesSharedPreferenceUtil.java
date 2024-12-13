package org.chromium.chrome.browser.ntp.ntp_hp.utils;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by gudd on 2024/11/25.
 */

public class MisesSharedPreferenceUtil {
    public final static String SP_NAME = "mises_ntp_sp";

    public final static String KEY_CRYPTO_LIST_CACHE = "crypto_list_cache";
    public static String mKey_NtpCategoryForSp;
    public static String mKey_NtpTopSitesForSP;
    public static String mKey_NtpTopSitesManualAdd;
    public static String mKey_NtpTopSitesDefIconUrl;
    public static int mNtpType = 2;// Native page 的数据源类型，1:web2; 2:web3


    private static volatile MisesSharedPreferenceUtil instance;
    private final SharedPreferences sharedPreferences;

    private MisesSharedPreferenceUtil(Context context, String preferenceName) {
        sharedPreferences = context.getSharedPreferences(preferenceName, Context.MODE_PRIVATE);
    }

    /**
     * 初始化 SharedPreferenceUtil 单例
     *
     * @param context        应用上下文
     * @param preferenceName 存储文件名
     */
    public static void init(Context context, String preferenceName) {
        if (instance == null) {
            synchronized (MisesSharedPreferenceUtil.class) {
                if (instance == null) {
                    instance = new MisesSharedPreferenceUtil(context, preferenceName);
                }
            }
        }
    }

    /**
     * 获取 SharedPreferenceUtil 实例
     *
     * @return SharedPreferenceUtil 实例
     */
    public static MisesSharedPreferenceUtil getInstance(Context context) {
        mNtpType = 2;
        initSPKeyName(mNtpType);
        init(context, SP_NAME);
        return instance;
    }

    // 保存 String 类型
    public void putString(String key, String value) {
        sharedPreferences.edit().putString(key, value).apply();
    }

    public String getString(String key, String defaultValue) {
        return sharedPreferences.getString(key, defaultValue);
    }

    // 保存 int 类型
    public void putInt(String key, int value) {
        sharedPreferences.edit().putInt(key, value).apply();
    }

    public int getInt(String key, int defaultValue) {
        return sharedPreferences.getInt(key, defaultValue);
    }

    // 保存 boolean 类型
    public void putBoolean(String key, boolean value) {
        sharedPreferences.edit().putBoolean(key, value).apply();
    }

    public boolean getBoolean(String key, boolean defaultValue) {
        return sharedPreferences.getBoolean(key, defaultValue);
    }

    // 保存 float 类型
    public void putFloat(String key, float value) {
        sharedPreferences.edit().putFloat(key, value).apply();
    }

    public float getFloat(String key, float defaultValue) {
        return sharedPreferences.getFloat(key, defaultValue);
    }

    // 保存 long 类型
    public void putLong(String key, long value) {
        sharedPreferences.edit().putLong(key, value).apply();
    }

    public long getLong(String key, long defaultValue) {
        return sharedPreferences.getLong(key, defaultValue);
    }

    // 删除指定 key
    public void remove(String key) {
        sharedPreferences.edit().remove(key).apply();
    }

    // 清除所有数据
    public void clear() {
        sharedPreferences.edit().clear().apply();
    }

    // 检查 key 是否存在
    public boolean contains(String key) {
        return sharedPreferences.contains(key);
    }

    private static void initSPKeyName(int ntpType) {
        mKey_NtpCategoryForSp = ntpType + "ntp_category";
        mKey_NtpTopSitesForSP = ntpType + "ntp_topSite";
        mKey_NtpTopSitesManualAdd = ntpType + "ntp_topSite_manual";
        mKey_NtpTopSitesDefIconUrl = ntpType + "ntp_topSite_defUrl";
    }
}