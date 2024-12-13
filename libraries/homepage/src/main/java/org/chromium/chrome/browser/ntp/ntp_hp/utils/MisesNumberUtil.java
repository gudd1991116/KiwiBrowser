package org.chromium.chrome.browser.ntp.ntp_hp.utils;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by gudd on 2024/12/4.
 */
public class MisesNumberUtil {

    public static int comparePrices(String price1, String price2) {
        BigDecimal bd1 = parseToBigDecimal(price1);
        BigDecimal bd2 = parseToBigDecimal(price2);
        return bd1.compareTo(bd2);
    }

    public static BigDecimal parseToBigDecimal(String price) {
        if (price == null || price.isEmpty()) return BigDecimal.ZERO;
        try {
            return new BigDecimal(price);
        } catch (NumberFormatException e) {
            return BigDecimal.ZERO; // 默认值
        }
    }

    /**
     * 保留2位小数，是否增加"%"号
     * @param rate
     * @param addPercentage 是否增加%
     * @return
     */
    public static String formatToPercentage(double rate, boolean addPercentage) {
        if (rate != 0) {
            if (addPercentage) {
                return String.format(Locale.US, "%.2f%%", rate);
            } else {
                return String.format(Locale.US, "%.2f", rate);
            }
        } else {
            return "";
        }
    }

    /**
     * 保留小数点后有效2位
     * @param number
     * @return
     */
    public static String retainTwoDecimalPlaces(String number) {
        if (!number.contains(".")) {
            return number; // 没有小数点，直接返回原数
        }

        String[] parts = number.split("\\."); // 按小数点分割
        String integerPart = parts[0];
        String decimalPart = parts[1];

        // 规则 1: 小数点后第一位是 0，第二位不是 0
        if (decimalPart.charAt(0) == '0' && decimalPart.length() > 1 && decimalPart.charAt(1) != '0') {
            return integerPart + "." + decimalPart.substring(0, 2);
        }

        int zeroCount = 0;
        int firstNonZeroIndex = -1;

        // 遍历小数部分，统计连续的 0 并找到第一个非 0 的位置
        for (int i = 0; i < decimalPart.length(); i++) {
            if (decimalPart.charAt(i) == '0') {
                zeroCount++;
            } else {
                firstNonZeroIndex = i;
                break;
            }
        }

        // 如果小数部分全是 0，直接返回
        if (firstNonZeroIndex == -1) {
            return integerPart ;
        }

        // 规则 2: 如果从第一位开始连续 0 的最后一个 0 后第一位非 0，第二位是 0
        if (zeroCount > 0 && firstNonZeroIndex + 1 < decimalPart.length() &&
                decimalPart.charAt(firstNonZeroIndex + 1) == '0') {
            System.out.println("1111");
            return integerPart + "." + decimalPart.substring(0, firstNonZeroIndex + 1);
        }
        // 规则3:如果从第一位开始连续 0 的最后一个 0 后第一位非0，没有后面的数字了
        if (zeroCount > 0 && firstNonZeroIndex + 1 == decimalPart.length()) {
            System.out.println("2222");
            return integerPart + "." + decimalPart.substring(0, firstNonZeroIndex + 1);
        }

        // 规则 4: 如果从第一位开始连续 0 的最后一个 0 后第一位非 0，第二位非 0
        if (zeroCount > 0 && firstNonZeroIndex + 1 < decimalPart.length() &&
                decimalPart.charAt(firstNonZeroIndex + 1) != '0') {
            System.out.println("4444");
            return integerPart + "." + decimalPart.substring(0, firstNonZeroIndex + 2);
        }

        System.out.println("5555");
        // 规则 5: 其余情况保留 2 位小数
        return integerPart + "." + decimalPart.substring(0, Math.min(2, decimalPart.length()));
    }


}
