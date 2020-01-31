package com.chlz.generator.enums;

public enum TemplateTypeEnum {

    PO(0, "Po.ftl"),
    DAO(1, "Dao.ftl"),
    SERVICE(2, "Service.ftl"),
    CONTROLLER(3, "Controller.ftl"),
    MAPPER(4, "Mapper.ftl"),
    INTERFACE(5, "Interface.ftl");

    private int type;

    private String ftlName;

    TemplateTypeEnum(int type, String ftlName) {
        this.type = type;
        this.ftlName = ftlName;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getFtlName() {
        return ftlName;
    }

    public void setFtlName(String ftlName) {
        this.ftlName = ftlName;
    }

    public static TemplateTypeEnum getEnumByType(int type) {
        for (TemplateTypeEnum typeEnum : TemplateTypeEnum.values()) {
            if (typeEnum.getType() == type) {
                return typeEnum;
            }
        }
        return null;
    }
}
