package com.chlz.generator.utils;

import com.chlz.generator.enums.TemplateTypeEnum;
import freemarker.template.Template;

import java.io.IOException;

public class TemplateUtil {

    /**
     * 获取模板
     */
    public static Template getTemplate(TemplateTypeEnum typeEnum) throws IOException {
        return FreemarketConfigUtils.getInstance().getTemplate(typeEnum.getFtlName());
    }
}
