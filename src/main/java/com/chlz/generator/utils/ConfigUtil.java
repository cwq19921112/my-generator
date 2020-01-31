package com.chlz.generator.utils;

import com.chlz.generator.config.CommonConfig;
import com.chlz.generator.config.ProjectConfig;
import com.chlz.generator.config.base.AbstractConfig;

import java.util.Properties;

public class ConfigUtil {

    private static CommonConfig commonConfig;

    private static ProjectConfig projectConfig;

    static {
        // 初始化基础配置
        initBaseConfig();

    }

    private static void initBaseConfig() {
        initConfig("template/config/base-config.properties", commonConfig);
    }

    private static void initProjectConfig() {
        initConfig("config/project-config.properties", projectConfig);
    }

    private static void initConfig(String configDir, AbstractConfig config) {
        Properties baseConfProp = PropertyUtil.getResourceAsProperties(configDir);
        baseConfProp.keySet().forEach(key -> {
            String keyStr = (String) key;
            ObjectUtil.setField(config, keyStr, baseConfProp.getProperty(keyStr));
        });
    }

    public static CommonConfig getCommonConfig() {
        return commonConfig;
    }

    public static ProjectConfig getProjectConfig() {
        return projectConfig;
    }

}
