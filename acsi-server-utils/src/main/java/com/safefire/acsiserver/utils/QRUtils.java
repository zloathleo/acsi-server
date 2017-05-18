package com.safefire.acsiserver.utils;

import org.apache.tomcat.util.codec.binary.Base64;

import java.nio.charset.Charset;

/**
 * Created by Leo on 2017/5/18.
 */
public class QRUtils {

    private static final String Utf8 = "UTF-8";
    private static final Charset CharsetUtf8 = Charset.forName(Utf8);

    public static final String generateProjectQRCode(String projectCode){
        return Base64.encodeBase64String(projectCode.getBytes(CharsetUtf8));
    }
}
