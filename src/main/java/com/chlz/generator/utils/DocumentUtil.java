package com.chlz.generator.utils;

import org.apache.commons.io.Charsets;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.output.FileWriterWithEncoding;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

import java.io.File;
import java.io.IOException;

public class DocumentUtil {

    /**
     * 将指定位置的xml读取成Document
     * @param dir
     * @return
     */
    public static Document loadAsDocument(String dir) {
        SAXReader saxReader = new SAXReader();
        File file = new File(dir);
        try {
            return saxReader.read(file);
        } catch (DocumentException e) {
            e.printStackTrace();
        }

        return null;
    }

    /**
     * 保存Document
     * @param path
     * @param document
     */
    public static void saveDocument(String path, Document document) {
        File file = new File(path);
        XMLWriter xmlWriter = null;
        try {
            // 先删除旧的
            FileUtils.forceDelete(file);

            xmlWriter = new XMLWriter(new FileWriterWithEncoding(file, Charsets.UTF_8));
            xmlWriter.write(document);
            xmlWriter.flush();
            xmlWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
