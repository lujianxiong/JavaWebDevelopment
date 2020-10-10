package cn.daxiong.service;

import java.io.FileOutputStream;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.Node;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

import cn.daxiong.vo.Student;

public class StuService {
	//增加一个学生
	public static void addStu(Student student) throws Exception{
		//1、创建解析器，得到document
		SAXReader reader = new SAXReader();
		Document document = reader.read("src/student.xml");
		//2、获取根节点
		Element root = document.getRootElement();
		//3、在根节点上创建stu标签
		Element stu = root.addElement("stu");
		//4、在stu标签上依次添加id name age
		Element id1 = stu.addElement("id");
		Element name1 = stu.addElement("name");
		Element age1 = stu.addElement("age");
		//5、给id name age 元素依次赋值
		id1.setText(student.getId());
		name1.setText(student.getName());
		age1.setText(student.getAge());
		//6、回写xml
		OutputFormat format = OutputFormat.createPrettyPrint();
		XMLWriter xmlWriter = new XMLWriter(new FileOutputStream("src/student.xml"),format);
		xmlWriter.write(document);
		xmlWriter.close();
	}

	//删除一个学生  (根据学生的id来进行删除)
	public static void delStu(String id) throws Exception{
		//1、创建解析器，得到document
		SAXReader resReader = new SAXReader();
		Document document = resReader.read("src/student.xml");
		//2、获取所有的id
		//使用xpath：//id  返回List集合
		@SuppressWarnings("unchecked")
		List<Node> ids = document.selectNodes("//id");
		//3、遍历list，判断id是否相同
		for (Node node : ids) {    //node是每一个id的元素
			//得到id的值
			String idv = node.getText();
			if (idv.equals(id)) {  //id相同
				//4、通过id获取父节点stu
				Element stu = node.getParent();
				//5、通过stu获取父节点student
				Element student = stu.getParent();
				//6、删除stu
				student.remove(stu);
			}
		}
		//7、回写xml
		OutputFormat format = OutputFormat.createPrettyPrint();
		XMLWriter xmlWriter = new XMLWriter(new FileOutputStream("src/student.xml"), format);
		xmlWriter.write(document);
		xmlWriter.close();
	}
	
	
	//查询学生信息  (根据id查询学生的信息)
	public static Student selectStuByid(String id) throws Exception{
		Student student = new Student();
		//1、创建解析器，得到document
		SAXReader reader = new SAXReader();
		Document document = reader.read("src/student.xml");
		//2、获取所有id
		@SuppressWarnings("unchecked")
		List<Node> ids = document.selectNodes("//id");
		//3、遍历list集合，判断id是否相同
		for (Node node : ids) {
			//得到id的值
			String idv = node.getText();
			if (idv.equals(id)) {
				//通过id获取父节点stu
				Element stu = node.getParent();
				//通过stu获取name、age的值
				String name = stu.element("name").getText();
				String age = stu.element("age").getText();
				student.setId(id);
				student.setName(name);
				student.setAge(age);
			}
		}
		return student;
	}
}
