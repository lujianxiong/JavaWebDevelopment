package cn.daxiong.dom4jTest;

import java.util.List;

import org.dom4j.Document;
import org.dom4j.Node;

import cn.daxiong.utils.Dom4jUtils;

public class TestDom4jXPATH {

	public static void main(String[] args) throws Exception{
		//selectName();
		selectSingleName();
	}
	
	//使用xpath查询xml中第一个p1下面的name元素
	public static void selectSingleName() throws Exception{
		//1、得到document
		Document document = Dom4jUtils.getDocument(Dom4jUtils.PATH);
		//2、直接使用selectSingleNode方法
		//XPATH：//p1[@id1='aaaa']/name
		Node name1 = document.selectSingleNode("//p1[@id1='aaaa']/name");
		//3、输出name里面的值
		String s = name1.getText();
		System.out.println(s);
	}

	//使用xpath查询xml中所有name元素的值
	public static void selectName() throws Exception{
		//1、得到document
		Document document = Dom4jUtils.getDocument(Dom4jUtils.PATH);
		//2、直接值用selectNodes("//name")方法得到所有name元素
		@SuppressWarnings("unchecked")
		List<Node> list = document.selectNodes("//name");
		//3、遍历list集合,每一个node就是name元素
		for (Node node : list) {
			System.out.println(node.getText());
		}
	}
	
	
	
	

}
