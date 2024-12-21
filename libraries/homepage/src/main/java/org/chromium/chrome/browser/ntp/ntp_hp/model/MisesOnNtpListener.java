package org.chromium.chrome.browser.ntp.ntp_hp.model;

/**
 * Created by gudd on 2024/11/13.
 */
public interface MisesOnNtpListener {
    void updateNewsOptin(boolean isOptin);
    void getFeed(boolean isNewContent);
    void loadNewContent();
    void checkForBraveStats();
    void focusSearchBox();
    void launchWallet();
    void showAppMenu();
}
