package cn.daxiong.dom4jTest;

import java.util.List;

import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;

import cn.daxiong.utils.Dom4jUtils;


public class TestDom4j {

	public static void main(String[] args) throws Exception {
		//selectName();
		//selectFirstName();
		//selectSecondName();
//		addSex();
//		addAgeBefore();
//		modifyAge();
//		delSchool();
		getValues();
	}
	//获取第一个p1里的属性id1的值
	public static void getValues() {
		Document document = Dom4jUtils.getDocument(Dom4jUtils.PATH);
		Element root = document.getRootElement();
		Element p1 = root.element("p1");
		//得到p1的属性值
		String value = p1.attributeValue("id1");
		System.out.println(value);
	}
	
	//删除第一个p1下的第二个school元素<school>xiong</school>
	public static void delSchool() {
		Document document = Dom4jUtils.getDocument(Dom4jUtils.PATH);
		Element root = document.getRootElement();
		Element p1 = root.element("p1");
		List schools = p1.elements("school");
		Element school2 = (Element) schools.get(1);
		//删除school元素
		school2.getParent().remove(school2);  //获取school2的父节点,通过父节点删除
		Dom4jUtils.xmlWriter(Dom4jUtils.PATH, document);
	}
	
	//修改第一个p1下age元素的值为<age>300</age>
	public static void modifyAge() {
		Document document = Dom4jUtils.getDocument(Dom4jUtils.PATH);
		Element root = document.getRootElement();
		Element p1 = root.element("p1");
		Element age = p1.element("age");
		age.setText("300");
		Dom4jUtils.xmlWriter(Dom4jUtils.PATH, document);
	}
	
	//在第一个p1标签下age标签之前添加<school>xiong</school>
	public static void addAgeBefore() throws Exception{
		//SAXReader reader = new SAXReader();
		//Document document = reader.read("src/p1.xml");
		Document document = Dom4jUtils.getDocument(Dom4jUtils.PATH);
		Element root = document.getRootElement();
		Element p1 = root.element("p1");
		@SuppressWarnings("unchecked")
		List<Element> list = p1.elements();
		
		//创建元素
		Element school = DocumentHelper.createElement("school");
		//在school下创建文本
		school.setText("鲁大师");
		//通过list在特定位置添加元素
		list.add(1,school);
		
		//回写xml
//		OutputFormat format = OutputFormat.createPrettyPrint();
//		XMLWriter xmlWriter = new XMLWriter(new FileOutputStream("src/p1.xml"), format);
//		xmlWriter.write(document);
//		xmlWriter.close();
		Dom4jUtils.xmlWriter(Dom4jUtils.PATH, document);
	}
	
	//在第一个p1标签末尾添加一个元素<sex>nv</sex>
	public static void addSex() throws Exception{
//		//1、创建解析器
//		SAXReader reader = new SAXReader();
//		//2、得到document
//		Document document = reader.read("src/p1.xml");
		
		Document document = Dom4jUtils.getDocument(Dom4jUtils.PATH);
		//3、得到根节点
		Element root = document.getRootElement();
		//4、获取第一个p1
		Element p1 = root.element("p1");
		//5、在p1下面直接添加元素
		Element sex = p1.addElement("sex");
		//6、在添加完成之后的元素下面添加文本
		sex.setText("nv");
//		//7、回写xml
//		OutputFormat format = OutputFormat.createPrettyPrint();  //创建一个漂亮的格式（带缩进）
//		//OutputFormat format = OutputFormat.createCompactFormat();  //
//		XMLWriter xmlWriter = new XMLWriter(new FileOutputStream("src/p1.xml"), format);
//		xmlWriter.write(document);  //将内存中的数据写到文件中
//		xmlWriter.close();  //关闭输出流
		Dom4jUtils.xmlWriter(Dom4jUtils.PATH, document);
	}
	
	//查询xml中第二个name元素的值
	public static void selectSecondName() throws Exception{
		Document document = Dom4jUtils.getDocument(Dom4jUtils.PATH);
		Element root = document.getRootElement();
		@SuppressWarnings("unchecked")
		List<Element> p1s = root.elements("p1");
		Element s = p1s.get(1).element("name");
		System.out.println(s.getText());
	}
	
	//查询xml中第一个name元素的值
	public static void selectFirstName() throws Exception{
		Document document = Dom4jUtils.getDocument(Dom4jUtils.PATH);
		Element root = document.getRootElement();
		Element p1 = root.element("p1");
		Element s = p1.element("name");
		System.out.println(s.getText());
	}
	
	//查询xml中所有name元素的值
	public static void selectName() throws Exception{
//		//1、创建解析器
//		SAXReader saxReader = new SAXReader();
//		//2、得到document
//		Document document = saxReader.read("src/p1.xml");
		Document document = Dom4jUtils.getDocument(Dom4jUtils.PATH);
		//3、得到根节点
		Element root = document.getRootElement();
		//4、得到p1
		@SuppressWarnings("unchecked")
		List<Element> p1s = root.elements("p1");    //获取所有的p1元素
		//遍历list
		for (Element p1 : p1s) {
			//5、得到p1下面的name
			Element name = p1.element("name");    //获取第一个name元素
			//6、得到name里面的值
			String s = name.getText();
			System.out.println(s);
		}
	}

}
