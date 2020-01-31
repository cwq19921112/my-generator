package com.chlz.generator.utils;

import com.chlz.generator.enums.TemplateTypeEnum;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import org.apache.commons.io.FileUtils;

import java.io.*;

public class FileUtil {

    private static ClassLoader classLoader = FileUtil.class.getClassLoader();

    /**
     * 复制类路径下的目录到指定目录
     *
     * @param srcDir
     * @param destDir
     */
    public static void copyClasspathDirectory(String srcDir, String destDir) {
        srcDir = classLoader.getResource(srcDir).getPath();

        try {
            FileUtils.copyDirectory(new File(srcDir), new File(destDir));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void generateToJava(TemplateTypeEnum typeEnum, Object data, String filePath) throws IOException,
            TemplateException {
        File file = new File(filePath);
        if (file.exists()) {
            FileUtils.forceDelete(file);
        }

        Template tpl = TemplateUtil.getTemplate(typeEnum);
        // 写入文件
        FileOutputStream fos = new FileOutputStream(filePath);
        OutputStreamWriter osw = new OutputStreamWriter(fos, "UTF-8");
        BufferedWriter bw = new BufferedWriter(osw, 1024);
        tpl.process(data, bw);
        fos.close();
    }

}
