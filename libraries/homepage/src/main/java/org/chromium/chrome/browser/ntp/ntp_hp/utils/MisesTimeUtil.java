package org.chromium.chrome.browser.ntp.ntp_hp.utils;

/**
 * Created by gudd on 2024/12/3.
 */
public class MisesTimeUtil {
    public static String convertTsToTime(long timeStamp) {
        long currentTimeStamp = System.currentTimeMillis();
        if (String.valueOf(timeStamp).length() < 11) {
            timeStamp = timeStamp * 1000;
        }
        long diff = currentTimeStamp - timeStamp;

        long millisInOneDay = 24 * 60 * 60 * 1000L;
        long millisInOneMonth = millisInOneDay * 30;
        long millisInOneYear = millisInOneDay * 365;

        long days = diff / millisInOneDay;
        long months = diff / millisInOneMonth;
        long years = diff / millisInOneYear;

        if (days < 1) {
            return "today";
        } else if (days == 1) {
            return "yesterday";
        } else if (days <= 30) {
            return days + " days ago";
        } else if (months <= 1) {
            return "1 month ago";
        } else if (months < 12) {
            return months + " months ago";
        } else if (years == 1) {
            return "1 year ago";
        } else {
            return years + " years ago";
        }
    }

}
