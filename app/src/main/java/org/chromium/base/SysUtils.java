// Copyright 2013 The Chromium Authors. All rights reserved.
// Use of this source code is governed by a BSD-style license that can be
// found in the LICENSE file.

package org.chromium.base;

import android.annotation.TargetApi;
import android.app.ActivityManager;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.StrictMode;
import android.util.Log;

import java.util.Date;
import java.util.Locale;
import java.text.SimpleDateFormat;

import org.chromium.base.annotations.CalledByNative;
import org.chromium.base.annotations.JNINamespace;
import org.chromium.base.metrics.CachedMetrics;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Exposes system related information about the current device.
 */
@JNINamespace("base::android")
public class SysUtils {
    // A device reporting strictly more total memory in megabytes cannot be considered 'low-end'.
    private static final int ANDROID_LOW_MEMORY_DEVICE_THRESHOLD_MB = 512;
    private static final int ANDROID_O_LOW_MEMORY_DEVICE_THRESHOLD_MB = 1024;

    private static final String TAG = "SysUtils";

    private static Boolean sLowEndDevice;
    private static Integer sAmountOfPhysicalMemoryKB;

    private static CachedMetrics.BooleanHistogramSample sLowEndMatches =
            new CachedMetrics.BooleanHistogramSample("Android.SysUtilsLowEndMatches");

    private SysUtils() { }

    /**
     * Return the amount of physical memory on this device in kilobytes.
     * @return Amount of physical memory in kilobytes, or 0 if there was
     *         an error trying to access the information.
     */
    private static int detectAmountOfPhysicalMemoryKB() {
        // Extract total memory RAM size by parsing /proc/meminfo, note that
        // this is exactly what the implementation of sysconf(_SC_PHYS_PAGES)
        // does. However, it can't be called because this method must be
        // usable before any native code is loaded.

        // An alternative is to use ActivityManager.getMemoryInfo(), but this
        // requires a valid ActivityManager handle, which can only come from
        // a valid Context object, which itself cannot be retrieved
        // during early startup, where this method is called. And making it
        // an explicit parameter here makes all call paths _much_ more
        // complicated.

        Pattern pattern = Pattern.compile("^MemTotal:\\s+([0-9]+) kB$");
        // Synchronously reading files in /proc in the UI thread is safe.
        StrictMode.ThreadPolicy oldPolicy = StrictMode.allowThreadDiskReads();
        try {
            FileReader fileReader = new FileReader("/proc/meminfo");
            try {
                BufferedReader reader = new BufferedReader(fileReader);
                try {
                    String line;
                    for (;;) {
                        line = reader.readLine();
                        if (line == null) {
                            Log.w(TAG, "/proc/meminfo lacks a MemTotal entry?");
                            break;
                        }
                        Matcher m = pattern.matcher(line);
                        if (!m.find()) continue;

                        int totalMemoryKB = Integer.parseInt(m.group(1));
                        // Sanity check.
                        if (totalMemoryKB <= 1024) {
                            Log.w(TAG, "Invalid /proc/meminfo total size in kB: " + m.group(1));
                            break;
                        }

                        return totalMemoryKB;
                    }

                } finally {
                    reader.close();
                }
            } finally {
                fileReader.close();
            }
        } catch (Exception e) {
            Log.w(TAG, "Cannot get total physical size from /proc/meminfo", e);
        } finally {
            StrictMode.setThreadPolicy(oldPolicy);
        }

        return 0;
    }

    /**
     * @return Whether or not this device should be considered a low end device.
     */
    @CalledByNative
    public static boolean isLowEndDevice() {
        if (sLowEndDevice == null) {
            sLowEndDevice = detectLowEndDevice();
        }
        return sLowEndDevice.booleanValue();
    }

    @CalledByNative
    public static long firstInstallDate() {
        Context context = ContextUtils.getApplicationContext();
        if (context == null)
            return 0;
        PackageInfo packageInfo;
        try {
            packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 0);
        } catch (NameNotFoundException e) {
            packageInfo = null;
        }
        return packageInfo == null ? 0 : (packageInfo.firstInstallTime / 1000);
    }

    @CalledByNative
    public static boolean isBottomToolbarEnabled() {
        return ContextUtils.getAppSharedPreferences().getBoolean("enable_bottom_toolbar", false);
    }

    @CalledByNative
    public static String referrerString() {
        return ContextUtils.getAppSharedPreferences().getString("install_referrer", "");
    }

    /**
     * @return Whether or not this device should be considered a low end device.
     */
    public static int amountOfPhysicalMemoryKB() {
        if (sAmountOfPhysicalMemoryKB == null) {
            sAmountOfPhysicalMemoryKB = detectAmountOfPhysicalMemoryKB();
        }
        return sAmountOfPhysicalMemoryKB.intValue();
    }

    /**
     * @return Whether or not the system has low available memory.
     */
    @CalledByNative
    public static boolean isCurrentlyLowMemory() {
        ActivityManager am =
                (ActivityManager) ContextUtils.getApplicationContext().getSystemService(
                        Context.ACTIVITY_SERVICE);
        ActivityManager.MemoryInfo info = new ActivityManager.MemoryInfo();
        am.getMemoryInfo(info);
        return info.lowMemory;
    }

    /**
     * Resets the cached value, if any.
     */
    @VisibleForTesting
    public static void resetForTesting() {
        sLowEndDevice = null;
        sAmountOfPhysicalMemoryKB = null;
    }

    public static boolean hasCamera(final Context context) {
        final PackageManager pm = context.getPackageManager();
        // JellyBean support.
        boolean hasCamera = pm.hasSystemFeature(PackageManager.FEATURE_CAMERA);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1) {
            hasCamera |= pm.hasSystemFeature(PackageManager.FEATURE_CAMERA_ANY);
        }
        return hasCamera;
    }

    @TargetApi(Build.VERSION_CODES.KITKAT)
    private static boolean detectLowEndDevice() {
        if (CommandLine.isInitialized()) {
            if (CommandLine.getInstance().hasSwitch(BaseSwitches.ENABLE_LOW_END_DEVICE_MODE)) {
                return true;
            }
            if (CommandLine.getInstance().hasSwitch(BaseSwitches.DISABLE_LOW_END_DEVICE_MODE)) {
                return false;
            }
        }

        sAmountOfPhysicalMemoryKB = detectAmountOfPhysicalMemoryKB();
        boolean isLowEnd = true;
        if (sAmountOfPhysicalMemoryKB <= 0) {
            isLowEnd = false;
        } else if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            isLowEnd = sAmountOfPhysicalMemoryKB / 1024 <= ANDROID_O_LOW_MEMORY_DEVICE_THRESHOLD_MB;
        } else {
            isLowEnd = sAmountOfPhysicalMemoryKB / 1024 <= ANDROID_LOW_MEMORY_DEVICE_THRESHOLD_MB;
        }

        // For evaluation purposes check whether our computation agrees with Android API value.
        Context appContext = ContextUtils.getApplicationContext();
        boolean isLowRam = false;
        if (appContext != null && Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            isLowRam = ((ActivityManager) ContextUtils.getApplicationContext().getSystemService(
                                Context.ACTIVITY_SERVICE))
                               .isLowRamDevice();
        }
        sLowEndMatches.record(isLowEnd == isLowRam);

        return isLowEnd;
    }

    /**
     * Creates a new trace event to log the number of minor / major page faults, if tracing is
     * enabled.
     */
    public static void logPageFaultCountToTracing() {
        nativeLogPageFaultCountToTracing();
    }

    private static native void nativeLogPageFaultCountToTracing();
}
