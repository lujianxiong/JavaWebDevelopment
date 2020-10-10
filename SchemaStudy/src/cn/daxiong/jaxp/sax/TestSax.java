package cn.daxiong.jaxp.sax;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import com.sun.org.apache.bcel.internal.generic.NEW;

import jdk.nashorn.internal.ir.Flags;

public class TestSax {

	public static void main(String[] args) throws Exception {
		// 1、创建解析器工厂
		SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();

		// 2、创建解析器
		SAXParser saxParser = saxParserFactory.newSAXParser();

		// 3、执行parse方法
		saxParser.parse("src/p1.xml", new MyDefault3());

	}
}

//获取整个xml文档内容
class MyDefault1 extends DefaultHandler {
	
	@Override
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
		System.out.print("<"+qName+">");
	}

	@Override
	public void characters(char[] ch, int start, int length) throws SAXException {
		System.out.print(new String(ch,start,length));
	}

	@Override
	public void endElement(String uri, String localName, String qName) throws SAXException {
		System.out.print("</"+qName+">");
	}

}

//获取所有name元素的值
class MyDefault2 extends DefaultHandler {
	boolean flag = false;
	@Override
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
		//判断qName是否是name元素
		if ("name".equals(qName)) {
			flag = true;
		}
	}

	@Override
	public void characters(char[] ch, int start, int length) throws SAXException {
		//当flag值为true的时候，表示解析到name元素，打印出文本内容
		if (flag == true) {
			System.out.println(new String(ch,start,length));
		}
	}

	@Override
	public void endElement(String uri, String localName, String qName) throws SAXException {
		//将flag设置为false，表示name元素结束
		if ("name".equals(qName)) {
			flag = false;
		}
	}
	
}

//获取第一个name元素的值
class MyDefault3 extends DefaultHandler {
	boolean flag = false;
	int index = 1;
	@Override
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
		//判断qName是否是name元素
		if ("name".equals(qName)) {
			flag = true;
		}
	}

	@Override
	public void characters(char[] ch, int start, int length) throws SAXException {
		//当flag值为true的时候，表示解析到name元素，打印出文本内容
		if (flag == true && index == 1) {
			System.out.println(new String(ch,start,length));
		}
	}

	@Override
	public void endElement(String uri, String localName, String qName) throws SAXException {
		//将flag设置为false，表示name元素结束
		if ("name".equals(qName)) {
			flag = false;
			index++;
		}
	}
	
}
