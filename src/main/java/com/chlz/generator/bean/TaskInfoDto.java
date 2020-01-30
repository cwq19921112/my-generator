package com.chlz.generator.bean;

import java.util.List;

/**
 * 执行任务需要的信息
 */
public class TaskInfoDto {

    private String tableName;

    private String className;

    private List<ColumnInfoDto> columnInfoDtos;

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public List<ColumnInfoDto> getColumnInfoDtos() {
        return columnInfoDtos;
    }

    public void setColumnInfoDtos(List<ColumnInfoDto> columnInfoDtos) {
        this.columnInfoDtos = columnInfoDtos;
    }
}
