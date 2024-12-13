// Copyright 2018 The Chromium Authors. All rights reserved.
// Use of this source code is governed by a BSD-style license that can be
// found in the LICENSE file.

package org.chromium.chrome.browser.notifications;

import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Build;

import org.chromium.chrome.browser.download.DownloadBroadcastManager;
import org.chromium.components.offline_items_collection.ContentId;

/**
 * Provides {@link PendingIntent} and the flags used to build the PendingIntent.
 */
public class PendingIntentProvider {
    private PendingIntent mPendingIntent;
    private final int mFlags;

    /**
     * Creates {@link PendingIntent}that triggers {@link android.content.BroadcastReceiver}.
     * @See {@link PendingIntent#getBroadcast(Context, int, Intent, int)}.
     */
    public static PendingIntentProvider getBroadcast(
            Context context, int requestCode, Intent intent, int flags) {
        return new PendingIntentProvider(
                PendingIntent.getBroadcast(context, requestCode, intent, flags), flags);
    }

    /**
     * Creates {@link PendingIntent} that triggers {@link android.app.Service}.
     * @See {@link PendingIntent#getService(Context, int, Intent, int)} .
     */
    public static PendingIntentProvider getService(
            Context context, int requestCode, Intent intent, int flags) {
        return new PendingIntentProvider(
                PendingIntent.getService(context, requestCode, intent, flags), flags);
    }

    /**
     * Creates {@link PendingIntent} that triggers {@link android.app.Activity}.
     * @See {@link PendingIntent#getActivity(Context, int, Intent, int)})} .
     */
    public static PendingIntentProvider getActivity(
            Context context, int requestCode, Intent intent, int flags) {
        return new PendingIntentProvider(
                PendingIntent.getActivity(context, requestCode, intent, flags), flags);
    }

    public PendingIntentProvider(PendingIntent pendingIntent, int flags) {
        mPendingIntent = pendingIntent;
        mFlags = flags;
    }

    /**
     * Returns the {@link PendingIntent}.
     */
    public PendingIntent getPendingIntent() {
        return mPendingIntent;
    }

    /**
     * Returns the flags of {@link PendingIntent}.
     */
    public int getFlags() {
        return mFlags;
    }


    /*************************************************************************/
    /*  public for creating intent*/
    /**
     * Helper method to build a PendingIntent from the provided intent.
     * @param intent Intent to broadcast.
     * @param notificationId ID of the notification.
     */
    public static PendingIntent buildPendingIntent(
            Context context, Intent intent, int notificationId) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            return PendingIntentProvider.getService(
                    context, notificationId, intent,PendingIntent.FLAG_IMMUTABLE | PendingIntent.FLAG_UPDATE_CURRENT).getPendingIntent();
        } else {
            return PendingIntentProvider.getService(
                    context, notificationId, intent, PendingIntent.FLAG_UPDATE_CURRENT).getPendingIntent();
        }
    }

    public static PendingIntent buildPendingIntent(
            Context context, Intent intent, int notificationId,int flag){
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            return PendingIntentProvider.getService(
                    context, notificationId, intent,PendingIntent.FLAG_IMMUTABLE | flag).getPendingIntent();
        } else {
            return PendingIntentProvider.getService(
                    context, notificationId, intent, flag).getPendingIntent();
        }
    }

    public static PendingIntent buildPendingIntentActivity(
            Context context, Intent intent, int notificationId,int flag){
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            return PendingIntentProvider.getActivity(
                    context, notificationId, intent,PendingIntent.FLAG_IMMUTABLE | flag).getPendingIntent();
        } else {
            return PendingIntentProvider.getActivity(
                    context, notificationId, intent, flag).getPendingIntent();

        }
    }

    public static PendingIntent buildPendingIntentBroadcast(
            Context context, Intent intent, int notificationId,int flag){
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            return PendingIntentProvider.getBroadcast(
                    context, notificationId, intent,PendingIntent.FLAG_IMMUTABLE | flag).getPendingIntent();
        } else {
            return PendingIntentProvider.getBroadcast(
                    context, notificationId, intent, flag).getPendingIntent();
        }
    }
}
