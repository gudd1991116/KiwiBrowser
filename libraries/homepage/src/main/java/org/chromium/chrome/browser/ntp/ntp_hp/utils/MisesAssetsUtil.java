package org.chromium.chrome.browser.ntp.ntp_hp.utils;

import android.content.Context;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * Created by gudd on 2024/11/15.
 */
public class MisesAssetsUtil {
    public static String loadJSONFromAsset(Context context, String fileName) {
        StringBuilder jsonString = new StringBuilder();
        try (InputStream is = context.getAssets().open(fileName);
             BufferedReader reader = new BufferedReader(new InputStreamReader(is))) {
            String line;
            while ((line = reader.readLine()) != null) {
                jsonString.append(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return jsonString.toString();
    }
}
