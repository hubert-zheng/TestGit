package com.hand.test;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class TestReadXML {

	public static void main(String[] args) {
		try {
			
			DocumentBuilderFactory	factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = factory.newDocumentBuilder();
			Document document = builder.parse(new File("text.xml"));
			Element root = document.getDocumentElement(); //获取文档根元素
			System.out.println("cat="+root.getAttribute("cat"));
			NodeList list = root.getElementsByTagName("lan");
			//循环获取文档的内容
			for (int i = 0; i < list.getLength(); i++) {
				Element lan = (Element) list.item(i); //将Node类型转换为Element
				System.out.println("------------------");
				System.out.println("id="+lan.getAttribute("id"));
				
				//获取lan对象中的子节点      方法1(效率低)
//				Element name = (Element) lan.getElementsByTagName("name").item(0);
//				System.out.println("name="+name.getTextContent());
				
				//获取lan对象中的等价子节点      方法2
				NodeList chilelist = lan.getChildNodes();
				for (int j = 0; j < chilelist.getLength(); j++) {
					//无法得知获取的是id或name
					Node chile = chilelist.item(j);
//					//类型转换错误，getTagName()返回类型为DeferredTextImpl
//					System.out.println(chile.getTagName()+"+"+chile.getTextContent());
					//可见节点才输出
					if(chile instanceof Element){
					//获取节点名称
					System.out.println(chile.getNodeName()+"="+chile.getTextContent());
					}
				}
			}
			
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		} catch (SAXException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
