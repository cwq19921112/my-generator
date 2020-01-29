package com.chlz.generator.init.pom.service.impl;

import com.chlz.generator.constant.CommonCons;
import com.chlz.generator.init.pom.service.PomInitService;
import com.chlz.generator.utils.DocumentUtil;
import com.chlz.generator.utils.PathUtil;
import com.chlz.generator.utils.PropertyUtil;
import org.dom4j.Document;
import org.dom4j.Element;

import java.util.List;
import java.util.Properties;

public class PropPomInitServiceImpl implements PomInitService {

    @Override
    public void coverPom(String pomDir) {
        // 加载pom配置到Properties
        Properties pomConfigProp = PropertyUtil.getResourceAsProperties(CommonCons.Pom.POM_CONFIG_DIR);
        // 重写pom并保存
        coverPom(pomDir, pomConfigProp);
    }

    private void coverPom(String pomDir, Properties pomConfigProp) {
        // pom对应的document
        Document document = DocumentUtil.loadAsDocument(PathUtil.appendPath(pomDir,
                CommonCons.Pom.POM_NAME));

        Element rootElement = document.getRootElement();
        List<Element> elements = rootElement.elements();
        for (Element element : elements) {
            // 如果element的name在Properties中有配置过,则覆盖
            String elementName = element.getName();
            if (pomConfigProp.containsKey(elementName)) {
                element.setText(pomConfigProp.getProperty(elementName));
            }
        }

        String projectConfigDir = CommonCons.Project.PROJECT_CONFIG_DIR;
        String projectSaveKeyName = CommonCons.Project.PATH_KEY_NAME;
        String projectDir = PropertyUtil.getResourceAsProperties(projectConfigDir).getProperty(projectSaveKeyName);
        String pomPath = PathUtil.appendPath(projectDir, CommonCons.Pom.POM_NAME);
        // 保存pom
        DocumentUtil.saveDocument(pomPath, document);
    }

}
