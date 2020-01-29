package com.chlz.generator.utils;

public class PathUtil {

    private static final String PATH_DELIMITER = "/";

    public static String appendPath(String parent, String fileName) {
        return parent + PATH_DELIMITER + fileName;
    }

}
