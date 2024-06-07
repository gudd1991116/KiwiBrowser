
// Copyright 2024 The Chromium Authors. All rights reserved.
// Use of this source code is governed by a BSD-style license that can be
// found in the LICENSE file.

// This file is autogenerated by
//     java_cpp_enum.py
// From
//     ../../components/signin/core/browser/signin_investigator.h

package org.chromium.signin;

import androidx.annotation.IntDef;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@IntDef({
    InvestigatedScenario.UPGRADE_LOW_RISK, InvestigatedScenario.UPGRADE_HIGH_RISK,
    InvestigatedScenario.SAME_ACCOUNT, InvestigatedScenario.DIFFERENT_ACCOUNT,
    InvestigatedScenario.HISTOGRAM_COUNT
})
@Retention(RetentionPolicy.SOURCE)
public @interface InvestigatedScenario {
  /**
   * First signin and should not be warned. As little friction as possible should get between the
   * user and signing in.
   */
  int UPGRADE_LOW_RISK = 0;
  /**
   * First signin but should be warned. There is a reason to believe this signin may not be what the
   * user wanted.
   */
  int UPGRADE_HIGH_RISK = 1;
  /**
   * Relogging with the same account.
   */
  int SAME_ACCOUNT = 2;
  /**
   * User is switching accounts, can be very dangerous depending on the amount of local syncable
   * data.
   */
  int DIFFERENT_ACCOUNT = 3;
  /**
   * Always the last enumerated type.
   */
  int HISTOGRAM_COUNT = 4;
}
