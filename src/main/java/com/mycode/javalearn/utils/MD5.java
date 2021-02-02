package com.mycode.javalearn.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * @Description TODO
 * @Author toolman
 * @Date 2021/1/26 21:55
 **/
public class MD5 {

    private static final Logger LOGGER = LoggerFactory.getLogger(MD5.class);

    public static String md5(String str) {
        byte[] bytes = new byte[0];
        try {
            bytes = str.getBytes("UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return md5(bytes);
    }

    public static String md5(byte[] bytes) {
        MessageDigest messageDigest = null;

        try {
            messageDigest = MessageDigest.getInstance("MD5");
            messageDigest.reset();
            messageDigest.update(bytes);

        } catch (NoSuchAlgorithmException e) {
            LOGGER.error("NoSuchAlgorithmException caught!");
        }

        StringBuffer md5StrBuff = new StringBuffer();
        if (messageDigest != null) {
            byte[] byteArray = messageDigest.digest();
            for (int i = 0; i < byteArray.length; i++) {
                if (Integer.toHexString(0xFF & byteArray[i]).length() == 1) {
                    md5StrBuff.append("0").append(Integer.toHexString(0xFF & byteArray[i]));
                } else {
                    md5StrBuff.append(Integer.toHexString(0xFF & byteArray[i]));
                }
            }
        }
        return md5StrBuff.toString();
    }

}
