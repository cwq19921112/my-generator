package com.chlz.generator;

import com.chlz.generator.config.CommonConfig;
import com.chlz.generator.constant.CommonCons;
import com.chlz.generator.init.pom.service.PomInitService;
import com.chlz.generator.init.pom.service.impl.PropPomInitServiceImpl;
import com.chlz.generator.utils.FileUtil;
import com.chlz.generator.utils.PropertyUtil;
import org.apache.commons.io.Charsets;
import org.apache.commons.io.output.FileWriterWithEncoding;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

import java.io.File;
import java.lang.reflect.Field;
import java.util.List;

public class Test {

    public static void main(String[] args) throws Exception{
//        test();
        CommonConfig commonConfig = new CommonConfig();
        Class<? extends CommonConfig> aClass = commonConfig.getClass();
        Field field = aClass.getDeclaredField("po");
        field.setAccessible(true);
        field.set(commonConfig,"demoPo");
        System.out.println(commonConfig.getPo());
    }

    private static void test() {
        String srcDir = "template/project-init";
        String destDir = PropertyUtil.getResourceAsProperties(CommonCons.Project.PROJECT_CONFIG_DIR).getProperty(CommonCons.Project.PATH_KEY_NAME);
        FileUtil.copyClasspathDirectory(srcDir, destDir);

        PomInitService pomInitService = new PropPomInitServiceImpl();
        pomInitService.coverPom(destDir);
    }

    private static void temp() throws Exception {
        SAXReader saxReader = new SAXReader();
        File file = new File("D:/test/generator-test/pom.xml");
        Document document = saxReader.read(file);

        Element rootElement = document.getRootElement();
        List<Element> elements = rootElement.elements();
        for (Element element : elements) {
            System.out.println(element.getName());
            element.setText("cwq");
        }

        XMLWriter xmlWriter = new XMLWriter(new FileWriterWithEncoding(file, Charsets.UTF_8));
        xmlWriter.write(document);
        xmlWriter.flush();
        xmlWriter.close();
    }

}
