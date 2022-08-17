package com.jh.sl.util;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.Base64;

public class CommonUtils {

    public static String decodeBase64(String v) {
        return new String(Base64.getDecoder().decode(v), StandardCharsets.UTF_8);
    }

    public static String encodeBase64(String v) {
        return Base64.getEncoder().encodeToString(v.getBytes(StandardCharsets.UTF_8));
    }

    public static String load(String f) {
        try (InputStream is = CommonUtils.class.getResourceAsStream(f)) {
            if (is == null) {
                return "";
            }
            return new String(is.readAllBytes(), StandardCharsets.UTF_8);
        } catch (IOException e) {
            e.printStackTrace();
            return "";
        }
    }

}
