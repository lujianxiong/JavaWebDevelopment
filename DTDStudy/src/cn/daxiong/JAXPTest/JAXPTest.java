package cn.daxiong.JAXPTest;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.Text;


/**
 * 实现JAXP操作xml文件
 * 
 * @author 鲁建雄
 *
 */
public class JAXPTest {

	public static void main(String[] args) throws Exception {
		// selectALL();
		//selectSin();
		//addSex();
		//modifySex();
		//delSex();
		listElement();
	}
	
	//遍历节点，将所有元素的名称打印出来
	public static void listElement() throws Exception{
		// 1、创建解析器工厂
		DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
		
		// 2、根据解析器工厂创建解析器
		DocumentBuilder builder = builderFactory.newDocumentBuilder();
		
		// 3、解析xml并返回document
		Document document = builder.parse("src/person.xml");
		
		//通过list1方法递归实现遍历操作
		list1(document);
	}
	
	//递归遍历的方法
	private static void list1(Node node) {
		//判断是元素类型的时候才进行打印
		if (node.getNodeType() == Node.ELEMENT_NODE) {
			System.out.println(node.getNodeName());
		}
		
		//得到第一层子节点
		NodeList list = node.getChildNodes();
		//遍历list
		for (int i = 0; i < list.getLength(); i++) {
			//得到每一个节点
			Node node1 = list.item(i);
			//继续得到node1的子节点
			//这里就可以使用递归
			list1(node1);
		}
	}

	//删除<sex>nan</sex>节结点
	public static void delSex() throws Exception{
		// 1、创建解析器工厂
		DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
		
		// 2、根据解析器工厂创建解析器
		DocumentBuilder builder = builderFactory.newDocumentBuilder();
		
		// 3、解析xml并返回document
		Document document = builder.parse("src/person.xml");
		
		// 4、获取sex节点
		Node sex = document.getElementsByTagName("sex").item(0);
		
		// 5、获取sex父节点
		Node p1 = sex.getParentNode();
		
		// 6、通过父节点删除： removeChild方法
		p1.removeChild(sex);
		
		// 7、回写xml
		TransformerFactory transformerFactory = TransformerFactory.newInstance();
		Transformer transformer = transformerFactory.newTransformer();
		transformer.transform(new DOMSource(document), new StreamResult("src/person.xml"));
		
		
	}
	
	
	//修改第一个p1下的sex内容为nan
	public static void modifySex() throws Exception{
		// 1、创建解析器工厂
		DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
		
		// 2、根据解析器工厂创建解析器
		DocumentBuilder  builder = builderFactory.newDocumentBuilder();
		
		// 3、解析xml并返回document
		Document document = builder.parse("src/person.xml");
		
		// 4、得到sex
		Node sex = document.getElementsByTagName("sex").item(0);
		
		// 5、修改sex的值：setTextContent
		sex.setTextContent("nan");
		
		// 6、回写xml
		TransformerFactory transformerFactory = TransformerFactory.newInstance();
		Transformer transformer = transformerFactory.newTransformer();
		transformer.transform(new DOMSource(document), new StreamResult("src/person.xml"));
	}

	// 在第一个p1下面（末尾）添加<sex>nv</sex>
	public static void addSex() throws Exception {
		// 1、创建解析器工厂
		DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();

		// 2、根据解析器工厂创建解析器
		DocumentBuilder builder = builderFactory.newDocumentBuilder();

		// 3、解析xml并返回document
		Document document = builder.parse("src/person.xml");
		
		// 4、得到第一个p1  （得到所有的p1，使用item方法）
		Node p1 = document.getElementsByTagName("p1").item(0);
		
		// 5、创建sex标签：createElement
		Element sex = document.createElement("sex");
		
		// 6、创建文本：createTextNode
		Text text = document.createTextNode("nv");
		
		// 7、把文本添加到sex下面：appendChild
		sex.appendChild(text);
		
		// 8、把sex添加到第一个p1下面
		p1.appendChild(sex);
		
		// 9、回写xml文件
		TransformerFactory transformerFactory = TransformerFactory.newInstance();
		Transformer transformer = transformerFactory.newTransformer();
		transformer.transform(new DOMSource(document), new StreamResult("src/person.xml"));
		
	}

	// 查询xml中第一个name元素的值
	public static void selectSin() throws Exception {
		// 1、创建解析器工厂
		DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();

		// 2、根据解析器工厂创建解析器
		DocumentBuilder builder = builderFactory.newDocumentBuilder();

		// 3、解析xml并返回document
		Document document = builder.parse("src/person.xml");

		// 4、得到所有的name元素
		NodeList list = document.getElementsByTagName("name");

		// 5、取集合中第一个name元素
		Node name1 = list.item(0);

		// 6、得到第一个name元素中的值
		String s = name1.getTextContent();

		// 7、输出值
		System.out.println(s);
	}

	// 查询所有name元素的值
	private static void selectALL() throws Exception {
		// 1、创建解析器工厂
		DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();

		// 2、根据解析器工厂创建解析器
		DocumentBuilder builder = builderFactory.newDocumentBuilder();

		// 3、解析xml返回document
		Document document = builder.parse("src/person.xml");

		// 4、得到所有的name元素
		NodeList list = document.getElementsByTagName("name");

		// 遍历list集合
		for (int i = 0; i < list.getLength(); i++) {
			// 得到每一个name元素
			Node name = list.item(i);
			// 得到name元素里的值
			String s = name.getTextContent();
			System.out.println(s);
		}
	}
}
