package com.chlz.generator.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertyUtil {

    private static ClassLoader classLoader = PropertyUtil.class.getClassLoader();

    /**
     * 将类路径下的文件读取到InputStream
     *
     * @param name
     * @return
     */
    public static InputStream getResourceAsStream(String name) {
        return classLoader.getResourceAsStream(name);
    }

    /**
     * 将类路径下的文件读取到Properties
     *
     * @param name
     * @return
     */
    public static Properties getResourceAsProperties(String name) {
        Properties prop = new Properties();
        try {
            prop.load(getResourceAsStream(name));
        } catch (IOException e) {
            e.printStackTrace();
        }

        return prop;
    }

}
