package org.chromium.chrome.browser.ntp.ntp_hp.model;

/**
 * Created by gudd on 2024/11/12.
 */
public class MisesNewsDetailModel {
    private int Code;
    private MisesNewsFeedModel.AdsModel Result;

    public int getCode() {
        return Code;
    }

    public void setCode(int code) {
        Code = code;
    }

    public MisesNewsFeedModel.AdsModel getResult() {
        return Result;
    }

    public void setResult(MisesNewsFeedModel.AdsModel result) {
        Result = result;
    }
}
