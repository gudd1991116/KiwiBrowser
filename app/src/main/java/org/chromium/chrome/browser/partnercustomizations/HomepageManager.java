// Copyright 2015 The Chromium Authors. All rights reserved.
// Use of this source code is governed by a BSD-style license that can be
// found in the LICENSE file.

package org.chromium.chrome.browser.partnercustomizations;

import android.content.SharedPreferences;
import android.text.TextUtils;

import org.chromium.base.ContextUtils;
import org.chromium.base.ObserverList;
import org.chromium.base.metrics.RecordHistogram;
import org.chromium.chrome.browser.util.FeatureUtilities;

import  org.chromium.chrome.browser.UrlConstants;


/**
 * Provides information regarding homepage enabled states and URI.
 *
 * This class serves as a single homepage logic gateway.
 */
public class HomepageManager {

    /**
     * An interface to use for getting homepage related updates.
     */
    public interface HomepageStateListener {
        /**
         * Called when the homepage is enabled or disabled or the homepage URL changes.
         */
        void onHomepageStateUpdated();
    }

    private static final String PREF_HOMEPAGE_ENABLED = "homepage";
    private static final String PREF_HOMEPAGE_CUSTOM_URI = "homepage_custom_uri";
    private static final String PREF_HOMEPAGE_USE_DEFAULT_URI = "homepage_partner_enabled";

    public static final String PREF_HOMEPAGE_SELECTION = "active_homepage_selection";
    private static HomepageManager sInstance;

    private final SharedPreferences mSharedPreferences;
    private final ObserverList<HomepageStateListener> mHomepageStateListeners;

    private HomepageManager() {
        mSharedPreferences = ContextUtils.getAppSharedPreferences();
        mHomepageStateListeners = new ObserverList<>();
    }

    /**
     * Returns the singleton instance of HomepageManager, creating it if needed.
     */
    public static HomepageManager getInstance() {
        if (sInstance == null) {
            sInstance = new HomepageManager();
        }
        return sInstance;
    }

    /**
     * Adds a HomepageStateListener to receive updates when the homepage state changes.
     */
    public void addListener(HomepageStateListener listener) {
        mHomepageStateListeners.addObserver(listener);
    }

    /**
     * Removes the given listener from the state listener list.
     * @param listener The listener to remove.
     */
    public void removeListener(HomepageStateListener listener) {
        mHomepageStateListeners.removeObserver(listener);
    }

    /**
     * Notify any listeners about a homepage state change.
     */
    public void notifyHomepageUpdated() {
        for (HomepageStateListener listener : mHomepageStateListeners) {
            listener.onHomepageStateUpdated();
        }
    }

    /**
     * @return Whether or not homepage is enabled.
     */
    public static boolean isHomepageEnabled() {
        if (PartnerBrowserCustomizations.isHomepageProviderAvailableAndEnabled()
                || FeatureUtilities.isHomePageButtonForceEnabled()) {
            return getInstance().getPrefHomepageEnabled();
        }
        return false;
    }

    /**
     * @return Whether to close the app when the user has zero tabs.
     */
    public static boolean shouldCloseAppWithZeroTabs() {
        return ContextUtils.getAppSharedPreferences().getBoolean("close_browser_after_last_tab", false);
    }

    /**
     * @return Whether or not homepage setting should be shown.
     */
    public static boolean shouldShowHomepageSetting() {
        return PartnerBrowserCustomizations.isHomepageProviderAvailableAndEnabled()
                || FeatureUtilities.isHomePageButtonForceEnabled();
    }

    /**
     * @return Homepage URI string, if it's enabled. Null otherwise or uninitialized.
     */
    public static String getHomepageUri() {
        HomepageManager manager = getInstance();
        String homepageUri = manager.getPrefHomepageUseDefaultUri()
                ? getDefaultHomepageUri()
                : manager.getPrefHomepageCustomUri();
        return TextUtils.isEmpty(homepageUri) ? null : homepageUri;
    }

    /**
     * @return The default homepage URI if the homepage is partner provided or the new tab page
     *         if the homepage button is force enabled via flag.
     */
    public static String getDefaultHomepageUri() {
        HomepageManager manager = getInstance();
        return PartnerBrowserCustomizations.isHomepageProviderAvailableAndEnabled()
                ? PartnerBrowserCustomizations.getHomePageUrl()
                : manager.getPrefHomepageCustomUri();
                //: UrlConstants.NTP_URL;   //LOCAL_NTP_URL
    }

    /**
     * Returns the user preference for whether the homepage is enabled. This doesn't take into
     * account whether the device supports having a homepage.
     *
     * @see #isHomepageEnabled
     */
    public boolean getPrefHomepageEnabled() {
        return mSharedPreferences.getBoolean(PREF_HOMEPAGE_ENABLED, true);
    }

    /**
     * Sets the user preference for whether the homepage is enabled.
     */
    public void setPrefHomepageEnabled(boolean enabled) {
        SharedPreferences.Editor sharedPreferencesEditor = mSharedPreferences.edit();
        sharedPreferencesEditor.putBoolean(PREF_HOMEPAGE_ENABLED, enabled);
        sharedPreferencesEditor.apply();
        RecordHistogram.recordBooleanHistogram(
                "Settings.ShowHomeButtonPreferenceStateChanged", enabled);
        notifyHomepageUpdated();
    }

    /**
     * @return User specified homepage custom URI string.
     */
    public String getPrefHomepageCustomUri() {
        //return mSharedPreferences.getString(PREF_HOMEPAGE_CUSTOM_URI, LOCAL_NTP_META3); //LOCAL_NTP_URL  LOCAL_NTP
        return getPrfHomepageMeatUri();
    }

    public String getPrfHomepageMeatUri() {
        // 1.CHANNEL RULES 2.Debug/Release RULES
        String metaHomepage = UrlConstants.LOCAL_NTP_META3;
        String selectedHomepage = mSharedPreferences.getString(PREF_HOMEPAGE_SELECTION,"WEB3").toUpperCase();
        if("WEB2".contentEquals(selectedHomepage)){
            metaHomepage = UrlConstants.LOCAL_NTP_META2;
        }
        return metaHomepage;
    }
    /**
     * Sets custom homepage URI
     */
    public void setPrefHomepageCustomUri(String customUri) {
        SharedPreferences.Editor sharedPreferencesEditor = mSharedPreferences.edit();
        sharedPreferencesEditor.putString(PREF_HOMEPAGE_CUSTOM_URI, customUri);
        sharedPreferencesEditor.apply();
    }

    /**
     * @return Whether the homepage URL is the default value.
     */
    public boolean getPrefHomepageUseDefaultUri() {
        return mSharedPreferences.getBoolean(PREF_HOMEPAGE_USE_DEFAULT_URI, true);
    }

    /**
     * Sets whether the homepage URL is the default value.
     */
    public void setPrefHomepageUseDefaultUri(boolean useDefaultUri) {
        SharedPreferences.Editor sharedPreferencesEditor = mSharedPreferences.edit();
        sharedPreferencesEditor.putBoolean(PREF_HOMEPAGE_USE_DEFAULT_URI, useDefaultUri);
        sharedPreferencesEditor.apply();
    }
}
