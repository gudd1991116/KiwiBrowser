package org.chromium.chrome.browser.ntp.ntp_hp.model;

import androidx.annotation.IntDef;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * Created by gudd on 2024/12/4.
 */
@IntDef({MisesSortTypeEnum.UNSORTED, MisesSortTypeEnum.PRICE_DESC, MisesSortTypeEnum.PRICE_ASC, MisesSortTypeEnum.RATE_DESC, MisesSortTypeEnum.RATE_ASC})
@Retention(RetentionPolicy.SOURCE)
public @interface MisesSortTypeEnum {
    int UNSORTED = -1;
    int PRICE_DESC = 0;
    int PRICE_ASC = 1;
    int RATE_DESC = 2;
    int RATE_ASC = 3;
}
