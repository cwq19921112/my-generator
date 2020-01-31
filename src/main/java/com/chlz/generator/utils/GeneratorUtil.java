package com.chlz.generator.utils;

import com.chlz.generator.bean.ColumnInfo;

import java.util.List;

public class GeneratorUtil {

    public static String generatePoProperties(List<ColumnInfo> columnInfos) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < columnInfos.size(); i++) {
            if (i != 0) {
                sb.append("    ");
            }
            ColumnInfo columnInfo = columnInfos.get(i);
            // TODO
//            sb.append("private ").append(TypeUtil.parseTypeFormSqlType(columnInfo.getType())).append(" ").append(columnInfo.getPropertyName()).append(";\n");
        }
        return sb.toString();
    }


    public static String generatePoMethods(List<ColumnInfo> columnInfos) {
        // TODO
        return null;
    }
}
