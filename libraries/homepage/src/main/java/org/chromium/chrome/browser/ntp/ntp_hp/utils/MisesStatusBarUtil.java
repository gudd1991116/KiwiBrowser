package org.chromium.chrome.browser.ntp.ntp_hp.utils;

import android.app.Activity;
import android.graphics.Color;
import android.os.Build;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import androidx.annotation.StringDef;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Objects;

/**
 * Created by gudd on 2024/12/17.
 */
public class MisesStatusBarUtil {
    public static void setStatusBarFlags(Activity activity, boolean multiWindowShow, boolean nightMode, boolean nativePage) {
        try {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                Window window = activity.getWindow();
                if (window != null) {
                    window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
                    if (nightMode || (multiWindowShow && nativePage)) {
                        window.getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN & ~View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
                    } else {
                        window.getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN | View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
                    }
                    window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
                    window.setStatusBarColor(Color.TRANSPARENT);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void setSystemUiStatusBarFontColor(Activity activity, @MisesSystemTheme String themeModel) {
        try {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                Window window = activity.getWindow();
                if (window != null) {
                    window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
                    if (Objects.equals(themeModel, MisesSystemTheme.THEME_DARK)) {
                        window.getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN & ~View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
                    } else {
                        window.getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN | View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
                    }
                    window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @StringDef({MisesSystemTheme.THEME_DARK, MisesSystemTheme.THEME_LIGHT})
    @Retention(RetentionPolicy.SOURCE)
    public @interface MisesSystemTheme {
        String THEME_DARK = "dark";
        String THEME_LIGHT = "light";
    }
}
