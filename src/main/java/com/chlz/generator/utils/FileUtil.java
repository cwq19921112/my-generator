package com.chlz.generator.utils;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;

public class FileUtil {

    private static ClassLoader classLoader = FileUtil.class.getClassLoader();

    /**
     * 复制类路径下的目录到指定目录
     *
     * @param srcDir
     * @param destDir
     */
    public static void copyClasspathDirectory(String srcDir, String destDir) {
        srcDir = classLoader.getResource(srcDir).getPath();

        try {
            FileUtils.copyDirectory(new File(srcDir), new File(destDir));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
