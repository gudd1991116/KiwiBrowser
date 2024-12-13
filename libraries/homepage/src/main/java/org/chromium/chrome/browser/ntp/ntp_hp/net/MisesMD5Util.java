package org.chromium.chrome.browser.ntp.ntp_hp.net;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Created by gudd on 2024/11/11.
 */
public class MisesMD5Util {
    public static String to32BitMD5(String input) {
        try {
            // 获取 MD5 实例
            MessageDigest md = MessageDigest.getInstance("MD5");
            // 计算 MD5 哈希值
            byte[] digest = md.digest(input.getBytes());
            // 将字节数组转换为 16 进制字符串
            StringBuilder sb = new StringBuilder(32);
            for (byte b : digest) {
                sb.append(String.format("%02x", b & 0xff));
            }
            // 返回 32 位字符串
            return sb.toString();

        } catch (NoSuchAlgorithmException e) {
            return null;
        }
    }
}
