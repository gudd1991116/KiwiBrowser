package org.chromium.chrome.browser.ntp.ntp_hp.database.convert;

import android.text.TextUtils;

import androidx.room.TypeConverter;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.List;

/**
 * Created by gudd on 2024/12/24.
 */
public class MisesStringListConvert {

    @TypeConverter
    public String fromList(List<String> list){
        if (list == null) return "";
        return new Gson().toJson(list);
    }

    @TypeConverter
    public List<String> fromString(String value){
        if (value == null || TextUtils.isEmpty(value)) return null;
        Type listType = new TypeToken<List<String>>() {
        }.getType();
        return new Gson().fromJson(value, listType);
    }
}
