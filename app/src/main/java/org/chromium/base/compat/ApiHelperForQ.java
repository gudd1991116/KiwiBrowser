// Copyright 2019 The Chromium Authors
// Use of this source code is governed by a BSD-style license that can be
// found in the LICENSE file.

package org.chromium.base.compat;

import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Build;

import androidx.annotation.RequiresApi;

import java.util.concurrent.Executor;

@RequiresApi(Build.VERSION_CODES.Q)
public final class ApiHelperForQ {
    private ApiHelperForQ() {}

    public static boolean bindIsolatedService(Context context, Intent intent, int flags,
                                              String instanceName, Executor executor, ServiceConnection connection) {
        return context.bindIsolatedService(intent, flags, instanceName, executor, connection);
    }


}