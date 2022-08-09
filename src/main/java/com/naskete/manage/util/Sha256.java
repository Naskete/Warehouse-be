package com.naskete.manage.util;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Sha256 {
    private static String sha(String str) {
        String res = null;
        MessageDigest messageDigest;
        try {
            messageDigest = MessageDigest.getInstance("SHA-256");
            messageDigest.update(str.getBytes(StandardCharsets.UTF_8));
            byte byteBuffer[] = messageDigest.digest();
            StringBuffer hexString = new StringBuffer();
            // 将byte转换为string
            for (byte b : byteBuffer) {
                String hex = Integer.toHexString(0xff & b);
                if (hex.length() == 1) {
                    hexString.append('0');
                }
                hexString.append(hex);
            }
            res = hexString.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return res;
    }
    public static String encode(String password) {
        return sha(password);
    }

    public static boolean check(String password, String sha256) {
        return encode(password).equals(sha256);
    }
}
