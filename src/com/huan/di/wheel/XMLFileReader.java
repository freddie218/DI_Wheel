package com.huan.di.wheel;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.io.SAXReader;

import java.io.File;
import java.util.List;

import static com.huan.di.util.LocalLogger.log;

/**
 * Created with IntelliJ IDEA.
 * User: twer
 * Date: 4/11/13
 * Time: 9:38 PM
 * To change this template use File | Settings | File Templates.
 */
public class XMLFileReader {
    private SAXReader saxReader = new SAXReader();
    private Document document;

    public XMLFileReader(String fileName) {
        try {
            document = saxReader.read(new File(fileName));
        } catch (DocumentException e) {
            e.printStackTrace();
            log("error xml file: " + fileName);
        }
    }

    public Document getDocument() {
        return document;
    }

    public int nodeSize() {
        return document.getRootElement().elements("wheel").size();
    }

    public List nodeList(String nodeName) {
        return document.getRootElement().elements("wheel");
    }
}
