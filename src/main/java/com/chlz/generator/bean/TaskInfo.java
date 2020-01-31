package com.chlz.generator.bean;

import java.util.List;

/**
 * 执行任务需要的信息
 */
public class TaskInfo {

    private String tableName;

    private String className;

    private List<ColumnInfo> columnInfos;

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

    public List<ColumnInfo> getColumnInfos() {
        return columnInfos;
    }

    public void setColumnInfos(List<ColumnInfo> columnInfos) {
        this.columnInfos = columnInfos;
    }
}
