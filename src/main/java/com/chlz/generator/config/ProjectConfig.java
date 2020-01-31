package com.chlz.generator.config;

import com.chlz.generator.config.base.AbstractConfig;

public class ProjectConfig extends AbstractConfig {

    private String author;

    private String projectSaveDir;

    private String basePackageName;

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getProjectSaveDir() {
        return projectSaveDir;
    }

    public void setProjectSaveDir(String projectSaveDir) {
        this.projectSaveDir = projectSaveDir;
    }

    public String getBasePackageName() {
        return basePackageName;
    }

    public void setBasePackageName(String basePackageName) {
        this.basePackageName = basePackageName;
    }
}
