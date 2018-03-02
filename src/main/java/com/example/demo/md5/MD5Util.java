package com.example.demo.md5;

import java.security.MessageDigest;

public class MD5Util {
    private static final String SALT = "tamboo";

    public static String encode(String password) {
        password = password + SALT;
        MessageDigest md5 = null;
        try {
            md5 = MessageDigest.getInstance("MD5");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        char[] charArray = password.toCharArray();
        byte[] byteArray = new byte[charArray.length];

        for (int i = 0; i < charArray.length; i++)
            byteArray[i] = (byte) charArray[i];
        byte[] md5Bytes = md5.digest(byteArray);
        StringBuffer hexValue = new StringBuffer();
        for (int i = 0; i < md5Bytes.length; i++) {
            int val = ((int) md5Bytes[i]) & 0xff;
            if (val < 16) {
                hexValue.append("0");
            }

            hexValue.append(Integer.toHexString(val));
        }
        return hexValue.toString();
    }

//    public static void main(String[] args) {
//        System.out.println(MD5Util.encode("admin"));
//        System.out.println(MD5Util.encode("1001"));
//        System.out.println(MD5Util.encode("1002"));
//        System.out.println(MD5Util.encode("1003"));
//        System.out.println(MD5Util.encode("1004"));
//        System.out.println(MD5Util.encode("1005"));
//        System.out.println(MD5Util.encode("1006"));
//        System.out.println(MD5Util.encode("1007"));
//        System.out.println(MD5Util.encode("1008"));
//        System.out.println(MD5Util.encode("1009"));
//        System.out.println(MD5Util.encode("1010"));
//        System.out.println(MD5Util.encode("1011"));
//        System.out.println(MD5Util.encode("1012"));
//        System.out.println(MD5Util.encode("1013"));
//        System.out.println(MD5Util.encode("1014"));
//
//
//    }
}

