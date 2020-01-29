package com.chlz.generator.init.pom.service;

/**
 * 项目初始化Service
 */
public interface PomInitService {

    /**
     * 重写pom并保存
     * @param pomDir
     */
    void coverPom(String pomDir);

}
