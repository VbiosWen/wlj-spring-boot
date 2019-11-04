package org.geeksword.springboot.util.encipher;

import sun.misc.BASE64Encoder;

import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MD5Util {


    public static String md5(String str) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("md5");
            BASE64Encoder base64Encoder = new BASE64Encoder();
            return base64Encoder.encode(messageDigest.digest(str.getBytes(Charset.defaultCharset())));
        } catch (NoSuchAlgorithmException e) {
            return null;
        }
    }
}
