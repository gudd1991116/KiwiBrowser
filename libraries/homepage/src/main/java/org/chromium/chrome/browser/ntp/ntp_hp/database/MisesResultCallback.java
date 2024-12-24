package org.chromium.chrome.browser.ntp.ntp_hp.database;

/**
 * Created by gudd on 2024/12/24.
 */
public interface MisesResultCallback<T> {
    void onSuccess(T result);
    void onError(Throwable throwable);
}
