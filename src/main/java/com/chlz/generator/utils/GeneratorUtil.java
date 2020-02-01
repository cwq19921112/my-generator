package com.chlz.generator.utils;

import com.chlz.generator.bean.ColumnInfo;

import java.sql.Types;
import java.util.List;

public class GeneratorUtil {

    public static String generatePoProperties(List<ColumnInfo> columnInfos) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < columnInfos.size(); i++) {
            if (i != 0) {
                sb.append("    ");
            }
            ColumnInfo columnInfo = columnInfos.get(i);

            sb.append("private ").
                    append(TypeUtil.parseTypeFormSqlType(columnInfo.getType())).
                    append(" ").
                    append(columnInfo.getPropertyName()).
                    append(";\n");
        }
        return sb.toString();
    }

    public static String generatePoMethods(List<ColumnInfo> columnInfos) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < columnInfos.size(); i++) {
            if (i != 0) {
                sb.append("    ");
            }
            ColumnInfo columnInfo = columnInfos.get(i);
            sb.append("public void set").
                    append(StringUtil.firstToUpperCase(columnInfo.getPropertyName())).
                    append(" (").
                    append(TypeUtil.parseTypeFormSqlType(columnInfo.getType())).
                    append(" ").
                    append(columnInfo.getPropertyName()).
                    append(") {this.").
                    append(columnInfo.getPropertyName()).
                    append(" = ").
                    append(columnInfo.getPropertyName()).
                    append(";} \n");
            if (columnInfo.getType() == Types.BIT || columnInfo.getType() == Types.TINYINT) {
                sb.append("    ").
                        append("public ").
                        append(TypeUtil.parseTypeFormSqlType(columnInfo.getType())).
                        append(" is").
                        append(StringUtil.firstToUpperCase(columnInfo.getPropertyName())).
                        append("(){ return ").
                        append(columnInfo.getPropertyName()).
                        append(";} \n");
            } else {
                sb.append("    ").
                        append("public ").
                        append(TypeUtil.parseTypeFormSqlType(columnInfo.getType())).
                        append(" get").
                        append(StringUtil.firstToUpperCase(columnInfo.getPropertyName())).
                        append("(){ return ").
                        append(columnInfo.getPropertyName()).
                        append(";} \n");
            }
        }
        return sb.toString();
    }
}
