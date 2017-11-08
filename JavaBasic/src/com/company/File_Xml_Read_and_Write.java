package com.company;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;

/**
 * XML文件读写
 * Created by moqiaowen on 2017/5/17.
 */
public class File_Xml_Read_and_Write {

    public static void main(String[] args) throws Exception {
        readXml();

    }

    public static void readXml() throws Exception {
        DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();


        File file = new File("language.xml");
        System.out.println(file.exists());
//        Document document = builder.parse(new File("language.xml"));

//        Element root = document.getDocumentElement();
//        NodeList list = root.getElementsByTagName("lan");
//
//
//        for (int i = 0; i < list.getLength(); i++) {
//            Element lan = (Element) list.item(i);
//            System.out.println(lan.getAttribute("id"));
//
//            //后面太麻烦了，需要用再查资料
//            //可用Dom4j等第三方来读取xml文件
//        }

        Document document = builder.parse(new File("test.html"));
        Element root = document.getDocumentElement();
        NodeList list = root.getElementsByTagName("html");

        System.out.println(list);
    }
}
