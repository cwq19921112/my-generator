package com.chlz.generator.constant;

/**
 * 常量类
 */
public interface CommonCons {

    /**
     * Pom相关的常量
     */
    interface Pom {

        /**
         * pom配置的类路径(groupId,artifactId等)
         */
        String POM_CONFIG_DIR = "config/pom-config.properties";

        /**
         * pom名称
         */
        String POM_NAME = "pom.xml";

    }

    /**
     * 项目相关的常量
     */
    interface Project {

        /**
         * 项目的配置路径(项目保存的路径等)
         */
        String PROJECT_CONFIG_DIR = "config/project-config.properties";

        /**
         * 项目保存的路径key的名称
         */
        String PATH_KEY_NAME = "projectSaveDir";

        /**
         * 项目模板的路径
         */
        String PROJECT_TEMPLATE_DIR = "template/project-init";

    }

}
