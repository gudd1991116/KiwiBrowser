// Copyright 2013 The Chromium Authors. All rights reserved.
// Use of this source code is governed by a BSD-style license that can be
// found in the LICENSE file.

package org.chromium.chrome.browser;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import android.os.Bundle;

import androidx.annotation.Nullable;

import org.chromium.base.ActivityState;
import org.chromium.base.ApplicationState;
import org.chromium.base.ApplicationStatus;
import org.chromium.base.BuildConfig;
import org.chromium.base.CommandLineInitUtil;
import org.chromium.base.ContextUtils;
import org.chromium.base.DiscardableReferencePool;
import org.chromium.base.Log;
import org.chromium.base.Supplier;
import org.chromium.base.ThreadUtils;
import org.chromium.base.TraceEvent;
import org.chromium.base.annotations.MainDex;
import org.chromium.base.library_loader.ProcessInitException;
import org.chromium.base.memory.MemoryPressureMonitor;
import org.chromium.base.multidex.ChromiumMultiDexInstaller;
import org.chromium.build.BuildHooks;
import org.chromium.build.BuildHooksAndroid;
import org.chromium.build.BuildHooksConfig;
import org.chromium.chrome.browser.crash.PureJavaExceptionHandler;
import org.chromium.chrome.browser.crash.PureJavaExceptionReporter;
import org.chromium.chrome.browser.document.DocumentActivity;
import org.chromium.chrome.browser.document.IncognitoDocumentActivity;
import org.chromium.chrome.browser.init.InvalidStartupDialog;
import org.chromium.chrome.browser.metrics.UmaUtils;
import org.chromium.chrome.browser.preferences.ChromePreferenceManager;
import org.chromium.chrome.browser.tabmodel.document.ActivityDelegateImpl;
import org.chromium.chrome.browser.tabmodel.document.DocumentTabModelSelector;
import org.chromium.chrome.browser.tabmodel.document.StorageDelegate;
import org.chromium.chrome.browser.tabmodel.document.TabDelegate;
import org.chromium.chrome.browser.vr_shell.OnExitVrRequestListener;
import org.chromium.chrome.browser.vr_shell.VrIntentUtils;
import org.chromium.chrome.browser.vr_shell.VrShellDelegate;

import org.chromium.chrome.browser.BackgroundExtensions;

import java.lang.reflect.Method;
import java.util.Locale;
import java.util.Objects;

/**
 * Basic application functionality that should be shared among all browser applications that use
 * chrome layer.
 */
public class ChromeApplication extends Application {
    private static final String COMMAND_LINE_FILE = "chrome-command-line";
    private static final String TAG = "MetaBrowserApp";

    private static DocumentTabModelSelector sDocumentTabModelSelector;
    private DiscardableReferencePool mReferencePool;

    public BackgroundExtensions mBackgroundExtensions;
    public static int inistanceID = 0;

    @Nullable
    private io.horizontalsystems.bankwallet.core.App wApp;
    @Override
    public void onCreate() {
        super.onCreate();
        boolean browserProcess = ContextUtils.isMainProcess();
        String proName = ContextUtils.getProcessName();
        if (browserProcess && wApp != null){
            try {
                boolean wAppInitied = io.horizontalsystems.bankwallet.core.App.instance != null;
                Log.v(TAG,"onCreate wallet App at process:" + proName);
                androidx.work.WorkManager.initialize(this, Objects.requireNonNull(wApp).getWorkManagerConfiguration());
                Log.v(TAG,"onCreate wallet wApp initial:" + wAppInitied);
                Objects.requireNonNull(wApp).onCreate();//在调用onCreate
            }catch (Throwable e){
                Log.e("ChromeApplication","onCreate with exception:" + e.toString());
            }
        }//end browserPross
    }

    // Called by the framework for ALL processes. Runs before ContentProviders are created.
    // Quirk: context.getApplicationContext() returns null during this method.
    @Override
    protected void attachBaseContext(Context context) {
        boolean browserProcess = ContextUtils.isMainProcess();
        String processName = ContextUtils.getProcessName();
        if (browserProcess) {
            UmaUtils.recordMainEntryPointTime();
            super.attachBaseContext(setLocal(context));
        }else{
            super.attachBaseContext(context);
        }
        checkAppBeingReplaced();
        ContextUtils.initApplicationContext(this);
        inistanceID++;
        Log.v(TAG,"ID:" + inistanceID + " App run in process: " + processName);
        if (browserProcess) {
            if (BuildConfig.IS_MULTIDEX_ENABLED) {
                ChromiumMultiDexInstaller.install(this);
            }

            // Renderers and GPU process have command line passed to them via IPC
            // (see ChildProcessService.java).
            Supplier<Boolean> shouldUseDebugFlags = new Supplier<Boolean>() {
                @Override
                public Boolean get() {
                    ChromePreferenceManager manager = ChromePreferenceManager.getInstance();
                    return manager.getCommandLineOnNonRootedEnabled();
                }
            };
            CommandLineInitUtil.initCommandLine(COMMAND_LINE_FILE, shouldUseDebugFlags);

            // Requires command-line flags.
            TraceEvent.maybeEnableEarlyTracing();
            TraceEvent.begin("ChromeApplication.attachBaseContext");

            // Register for activity lifecycle callbacks. Must be done before any activities are
            // created and is needed only by processes that use the ApplicationStatus api (which for
            // Chrome is just the browser process).
            ApplicationStatus.initialize(this);

            // Only browser process requires custom resources.
            BuildHooksAndroid.initCustomResources(this);

            // Disable MemoryPressureMonitor polling when Chrome goes to the background.
            ApplicationStatus.registerApplicationStateListener(newState -> {
                if (newState == ApplicationState.HAS_RUNNING_ACTIVITIES) {
                    MemoryPressureMonitor.INSTANCE.enablePolling();
                } else if (newState == ApplicationState.HAS_STOPPED_ACTIVITIES) {
                    MemoryPressureMonitor.INSTANCE.disablePolling();
                }
            });

            // Not losing much to not cover the below conditional since it just has simple setters.
            TraceEvent.end("ChromeApplication.attachBaseContext");
        }

        MemoryPressureMonitor.INSTANCE.registerComponentCallbacks();

        if (!ContextUtils.isIsolatedProcess()) {
            // Incremental install disables process isolation, so things in this block will actually
            // be run for incremental apks, but not normal apks.
            PureJavaExceptionHandler.installHandler();
            if (BuildHooksConfig.REPORT_JAVA_ASSERT) {
                BuildHooks.setReportAssertionCallback(
                        PureJavaExceptionReporter::reportJavaException);
            }
        }

        if (browserProcess && wApp == null){
            // Initial wallet
            try {
                String proName = ContextUtils.getProcessName();
                Log.v(TAG,"attachBaseContext wallet App in process:"+ proName);
                Log.v(TAG,"Initial Wallet-APP object !!");
                wApp = io.horizontalsystems.bankwallet.core.App.NewApp();
                Method sAttachBaseContextMethod = io.horizontalsystems.bankwallet.core.App.class.getDeclaredMethod("attachBaseContext",Context.class);
                sAttachBaseContextMethod.setAccessible(true);
                sAttachBaseContextMethod.invoke(wApp,context); //先attach
                Objects.requireNonNull(wApp).setLocale(Locale.ENGLISH);

            }catch (Throwable e){
                Log.e("ChromeApplication","attachBaseContext wallet app exception:" + e.toString());
            }
        }
    }

    /** Ensure this application object is not out-of-date. */
    private void checkAppBeingReplaced() {
        // During app update the old apk can still be triggered by broadcasts and spin up an
        // out-of-date application. Kill old applications in this bad state. See
        // http://crbug.com/658130 for more context and http://b.android.com/56296 for the bug.
        if (getResources() == null) {
            Log.e(TAG, "getResources() null, closing app.");
            System.exit(0);
        }
    }

    @MainDex
    @Override
    public void onTrimMemory(int level) {
        super.onTrimMemory(level);
        // The conditions are expressed using ranges to capture intermediate levels possibly added
        // to the API in the future.
        if ((level >= TRIM_MEMORY_RUNNING_LOW && level < TRIM_MEMORY_UI_HIDDEN)
                || level >= TRIM_MEMORY_MODERATE) {
            if (mReferencePool != null) mReferencePool.drain();
        }
    }

    /**
     * Shows an error dialog following a startup error, and then exits the application.
     * @param e The exception reported by Chrome initialization.
     */
    public static void reportStartupErrorAndExit(final ProcessInitException e) {
        Activity activity = ApplicationStatus.getLastTrackedFocusedActivity();
        if (ApplicationStatus.getStateForActivity(activity) == ActivityState.DESTROYED) {
            return;
        }
        InvalidStartupDialog.show(activity, e.getErrorCode());
    }

    /**
     * Returns the singleton instance of the DocumentTabModelSelector.
     * TODO(dfalcantara): Find a better place for this once we differentiate between activity and
     *                    application-level TabModelSelectors.
     * @return The DocumentTabModelSelector for the application.
     */
    public static DocumentTabModelSelector getDocumentTabModelSelector() {
        ThreadUtils.assertOnUiThread();
        if (sDocumentTabModelSelector == null) {
            ActivityDelegateImpl activityDelegate = new ActivityDelegateImpl(
                    DocumentActivity.class, IncognitoDocumentActivity.class);
            sDocumentTabModelSelector = new DocumentTabModelSelector(activityDelegate,
                    new StorageDelegate(), new TabDelegate(false), new TabDelegate(true));
        }
        return sDocumentTabModelSelector;
    }

    /**
     * @return The DiscardableReferencePool for the application.
     */
    @MainDex
    public DiscardableReferencePool getReferencePool() {
        ThreadUtils.assertOnUiThread();
        if (mReferencePool == null) {
            mReferencePool = new DiscardableReferencePool();
        }
        return mReferencePool;
    }

    @Override
    public void startActivity(Intent intent) {
        startActivity(intent, null);
    }

    @Override
    public void startActivity(Intent intent, Bundle options) {
        if (VrShellDelegate.canLaunch2DIntents() || VrIntentUtils.isVrIntent(intent)) {
            super.startActivity(intent, options);
            return;
        }

        VrShellDelegate.requestToExitVr(new OnExitVrRequestListener() {
            @Override
            public void onSucceeded() {
                if (!VrShellDelegate.canLaunch2DIntents()) {
                    throw new IllegalStateException("Still in VR after having exited VR.");
                }
                startActivity(intent, options);
            }

            @Override
            public void onDenied() {}
        });
    }

    @Override
    public void onConfigurationChanged(Configuration configure){
        super.onConfigurationChanged(configure);
        try {
            Log.d(TAG,"onConfigurationChanged wallet App");
            //wApp.onConfigurationChanged(configure);
        }catch (Throwable e){
            Log.e("ChromeApplication","onCreate with exception:" + e.toString());
        }
    }

    @SuppressWarnings("deprecation")
    private Context setLocal(Context context){
        Configuration configuration = Resources.getSystem().getConfiguration();
        String versionName = com.bose.meta.browser.BuildConfig.VERSION_NAME;
        Locale needLocal = null;
        if(versionName.endsWith(".cn")){
            needLocal = Locale.CHINA;
            Locale.setDefault(needLocal);
        }
        if(versionName.endsWith(".en")){
            needLocal = Locale.ENGLISH;
            Locale.setDefault(needLocal);
        }
        if(needLocal != null){
            Log.d(TAG,"Need Set Location:%s,ver:%s",needLocal.toString(),versionName);
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                configuration.setLocale(needLocal);
                return context.createConfigurationContext(configuration);
            } else {
                configuration.locale = needLocal;
                getResources().updateConfiguration(configuration, getBaseContext().getResources().getDisplayMetrics());
                return context;
            }
        }
        else  return context;
    }
}
