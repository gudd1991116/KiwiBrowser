
// Copyright 2024 The Chromium Authors. All rights reserved.
// Use of this source code is governed by a BSD-style license that can be
// found in the LICENSE file.

// This file is autogenerated by
//     java_cpp_enum.py
// From
//     ../../components/sync/protocol/sync_protocol_error.h

package org.chromium.components.sync;

import androidx.annotation.IntDef;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@IntDef({
    ProtocolErrorClientAction.UPGRADE_CLIENT, ProtocolErrorClientAction.CLEAR_USER_DATA_AND_RESYNC,
    ProtocolErrorClientAction.ENABLE_SYNC_ON_ACCOUNT,
    ProtocolErrorClientAction.STOP_AND_RESTART_SYNC,
    ProtocolErrorClientAction.DISABLE_SYNC_ON_CLIENT,
    ProtocolErrorClientAction.STOP_SYNC_FOR_DISABLED_ACCOUNT,
    ProtocolErrorClientAction.RESET_LOCAL_SYNC_DATA, ProtocolErrorClientAction.UNKNOWN_ACTION
})
@Retention(RetentionPolicy.SOURCE)
public @interface ProtocolErrorClientAction {
  /**
   * Upgrade the client to latest version.
   */
  int UPGRADE_CLIENT = 0;
  /**
   * Clear user data and setup sync again.
   */
  int CLEAR_USER_DATA_AND_RESYNC = 1;
  /**
   * Set the bit on the account to enable sync.
   */
  int ENABLE_SYNC_ON_ACCOUNT = 2;
  /**
   * Stop sync and restart sync.
   */
  int STOP_AND_RESTART_SYNC = 3;
  /**
   * Wipe this client of any sync data.
   */
  int DISABLE_SYNC_ON_CLIENT = 4;
  /**
   * Account is disabled by admin. Stop sync, clear prefs and show message on settings page that
   * account is disabled.
   */
  int STOP_SYNC_FOR_DISABLED_ACCOUNT = 5;
  /**
   * Generated in response to CLIENT_DATA_OBSOLETE error. ProfileSyncService should stop sync
   * engine, delete directory and restart sync engine.
   */
  int RESET_LOCAL_SYNC_DATA = 6;
  /**
   * The default. No action.
   */
  int UNKNOWN_ACTION = 7;
}
