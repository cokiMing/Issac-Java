package com.cokiMing.util;

import org.dom4j.Document;
import org.dom4j.io.SAXReader;

import java.io.File;

/**
 * Created by wuyiming on 2017/7/31.
 */
public class XmlUtil {

    public static Document getDocument(String URL){
        SAXReader saxReader = new SAXReader();
        Document document;
        try{
            document = saxReader.read(new File(URL));
        }catch (Exception e){
            e.printStackTrace();
            throw new RuntimeException(e);
        }
        return document;
    }
}
