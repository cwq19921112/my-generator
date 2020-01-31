package com.chlz.generator.utils;

import java.io.File;

public class PathUtil {

    public static String appendPath(String... paths) {
        String resPath = "";
        for (String path : paths) {
            resPath = resPath + File.separator + path;
        }
        return resPath;
    }

    public static String package2Path(String packageName) {
        String path = "";
        if (StringUtil.isEmpty(packageName)) {
            return path;
        }

        String[] packages = packageName.split("\\.");
        for (String name : packages) {
            path = path + name + File.separator;
        }
        return path;
    }
}
