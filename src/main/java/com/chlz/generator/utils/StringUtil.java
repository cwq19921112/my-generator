package com.chlz.generator.utils;

public class StringUtil {

    public static boolean isEmpty(Object str) {
        return str == null || "".equals(str);
    }

    /**
     * 首字母大写
     */
    public static String firstToUpperCase(String string) {
        StringBuilder sb = new StringBuilder();
        sb.append(string.substring(0, 1).toUpperCase()).append(string.substring(1));
        return sb.toString();
    }

}
