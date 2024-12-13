package org.chromium.chrome.browser.ntp.ntp_hp.utils;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

/**
 * Created by gudd on 2024/12/4.
 */
public class MisesGsonUtil {

    public static <T> T convertJsonToObject(String json,TypeToken<T> typeToken){
        Gson gson = new Gson();
        return gson.fromJson(json, typeToken.getType());
    }
}
