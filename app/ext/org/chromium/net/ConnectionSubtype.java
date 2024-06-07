
// Copyright 2024 The Chromium Authors. All rights reserved.
// Use of this source code is governed by a BSD-style license that can be
// found in the LICENSE file.

// This file is autogenerated by
//     java_cpp_enum.py
// From
//     ../../net/base/network_change_notifier.h

package org.chromium.net;

import androidx.annotation.IntDef;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@IntDef({
    ConnectionSubtype.SUBTYPE_UNKNOWN, ConnectionSubtype.SUBTYPE_NONE,
    ConnectionSubtype.SUBTYPE_OTHER, ConnectionSubtype.SUBTYPE_GSM, ConnectionSubtype.SUBTYPE_IDEN,
    ConnectionSubtype.SUBTYPE_CDMA, ConnectionSubtype.SUBTYPE_1XRTT, ConnectionSubtype.SUBTYPE_GPRS,
    ConnectionSubtype.SUBTYPE_EDGE, ConnectionSubtype.SUBTYPE_UMTS,
    ConnectionSubtype.SUBTYPE_EVDO_REV_0, ConnectionSubtype.SUBTYPE_EVDO_REV_A,
    ConnectionSubtype.SUBTYPE_HSPA, ConnectionSubtype.SUBTYPE_EVDO_REV_B,
    ConnectionSubtype.SUBTYPE_HSDPA, ConnectionSubtype.SUBTYPE_HSUPA,
    ConnectionSubtype.SUBTYPE_EHRPD, ConnectionSubtype.SUBTYPE_HSPAP, ConnectionSubtype.SUBTYPE_LTE,
    ConnectionSubtype.SUBTYPE_LTE_ADVANCED, ConnectionSubtype.SUBTYPE_BLUETOOTH_1_2,
    ConnectionSubtype.SUBTYPE_BLUETOOTH_2_1, ConnectionSubtype.SUBTYPE_BLUETOOTH_3_0,
    ConnectionSubtype.SUBTYPE_BLUETOOTH_4_0, ConnectionSubtype.SUBTYPE_ETHERNET,
    ConnectionSubtype.SUBTYPE_FAST_ETHERNET, ConnectionSubtype.SUBTYPE_GIGABIT_ETHERNET,
    ConnectionSubtype.SUBTYPE_10_GIGABIT_ETHERNET, ConnectionSubtype.SUBTYPE_WIFI_B,
    ConnectionSubtype.SUBTYPE_WIFI_G, ConnectionSubtype.SUBTYPE_WIFI_N,
    ConnectionSubtype.SUBTYPE_WIFI_AC, ConnectionSubtype.SUBTYPE_WIFI_AD,
    ConnectionSubtype.SUBTYPE_LAST
})
@Retention(RetentionPolicy.SOURCE)
public @interface ConnectionSubtype {
  int SUBTYPE_UNKNOWN = 0;
  int SUBTYPE_NONE = 1;
  int SUBTYPE_OTHER = 2;
  int SUBTYPE_GSM = 3;
  int SUBTYPE_IDEN = 4;
  int SUBTYPE_CDMA = 5;
  int SUBTYPE_1XRTT = 6;
  int SUBTYPE_GPRS = 7;
  int SUBTYPE_EDGE = 8;
  int SUBTYPE_UMTS = 9;
  int SUBTYPE_EVDO_REV_0 = 10;
  int SUBTYPE_EVDO_REV_A = 11;
  int SUBTYPE_HSPA = 12;
  int SUBTYPE_EVDO_REV_B = 13;
  int SUBTYPE_HSDPA = 14;
  int SUBTYPE_HSUPA = 15;
  int SUBTYPE_EHRPD = 16;
  int SUBTYPE_HSPAP = 17;
  int SUBTYPE_LTE = 18;
  int SUBTYPE_LTE_ADVANCED = 19;
  int SUBTYPE_BLUETOOTH_1_2 = 20;
  int SUBTYPE_BLUETOOTH_2_1 = 21;
  int SUBTYPE_BLUETOOTH_3_0 = 22;
  int SUBTYPE_BLUETOOTH_4_0 = 23;
  int SUBTYPE_ETHERNET = 24;
  int SUBTYPE_FAST_ETHERNET = 25;
  int SUBTYPE_GIGABIT_ETHERNET = 26;
  int SUBTYPE_10_GIGABIT_ETHERNET = 27;
  int SUBTYPE_WIFI_B = 28;
  int SUBTYPE_WIFI_G = 29;
  int SUBTYPE_WIFI_N = 30;
  int SUBTYPE_WIFI_AC = 31;
  int SUBTYPE_WIFI_AD = 32;
  int SUBTYPE_LAST = 32;
}
