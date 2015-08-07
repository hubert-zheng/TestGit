package com.hand.test;

import java.io.File;
import java.io.StringWriter;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class TestWriterXML {

	public static void main(String[] args) {
		//创建DOMbuilderfactory
		try {
			
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = factory.newDocumentBuilder();
			Document document = builder.newDocument(); //获取document对象，用以生成节点
			
			Element root = document.createElement("languages");  //创建根节点
			root.setAttribute("cat", "IT");
			
			//节点1
			Element lan1 = document.createElement("lan");//创建lan1元素
			lan1.setAttribute("id", "1");  //键值对都是String 
			
			Element name1 = document.createElement("name");
			name1.setTextContent("Java");   //创建节点中带的信息字符串
			Element ide1 = document.createElement("ide");
			ide1.setTextContent("Eclipse");
			
			lan1.appendChild(name1);
			lan1.appendChild(ide1); //将两个子节点加到lan1节点中
			
			//节点2
			Element lan2 = document.createElement("lan");//创建lan1元素
			lan2.setAttribute("id", "2");  //键值对都是String 
			
			Element name2 = document.createElement("name");
			name2.setTextContent("Swift");   //创建节点中带的信息字符串
			Element ide2 = document.createElement("ide");
			ide2.setTextContent("Xcode");
			
			lan2.appendChild(name2);
			lan2.appendChild(ide2); //将两个子节点加到lan1节点中
			
			//节点3
			
			Element lan3 = document.createElement("lan");//创建lan1元素
			lan3.setAttribute("id", "3");  //键值对都是String 
			
			Element name3 = document.createElement("name");
			name3.setTextContent("C#");   //创建节点中带的信息字符串
			Element ide3 = document.createElement("ide");
			ide3.setTextContent("Visual Studio");
			
			lan3.appendChild(name3);
			lan3.appendChild(ide3); //将两个子节点加到lan1节点中
			
			root.appendChild(lan1);  //将lan1添加到根节点中root中
			root.appendChild(lan2);
			root.appendChild(lan3);
			document.appendChild(root); //将根节点添加到document对象
			
			//----文档内容创建完毕--------
			
			//输出
			TransformerFactory transformerFactory = TransformerFactory.newInstance();
			//将XML文档转换成其他格式
			Transformer transformer = transformerFactory.newTransformer();
			StringWriter writer = new StringWriter(); //写入Writer
			//第一个参数为XML文档源，第二个参数为输出
			transformer.transform(new DOMSource(document), new StreamResult(writer));
			//将writer读到的XML输出
			System.out.println(writer.toString());
			
			//输出成文件
			transformer.transform(new DOMSource(document), new StreamResult(new File("newxml.xml")));
		
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		} catch (TransformerConfigurationException e) {
			e.printStackTrace();
		} catch (TransformerException e) {
			e.printStackTrace();
		}
		
	}

}
