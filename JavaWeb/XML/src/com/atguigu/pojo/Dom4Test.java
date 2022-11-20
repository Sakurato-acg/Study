package com.atguigu.pojo;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.List;

public class Dom4Test {

    @Test
    public  void  test1() throws DocumentException {
        //输入流
        SAXReader saxReader=new SAXReader();
        saxReader.read("src/books.xml");

    }
    //读取xml生成类
    @Test
    public void  test2() throws DocumentException {
        SAXReader saxReader=new SAXReader();
        Document document = saxReader.read("src/books.xml");
        Element rootElement = document.getRootElement();
        List<Element> books = rootElement.elements("book");
        for (Element book: books) {
            //asXML()//把标签字符转成标签字符串
//            System.out.println(book.asXML());
            String name = book.elementText("name");
            String price = book.elementText("price");
            String author = book.elementText("author");
            String sn = book.attributeValue("sn");

            Book book1 = new Book(sn, name, new BigDecimal(price), author);


        }
    }
}
