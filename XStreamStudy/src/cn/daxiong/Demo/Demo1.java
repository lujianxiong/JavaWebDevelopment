package cn.daxiong.Demo;

import java.util.ArrayList;
import java.util.List;

import com.thoughtworks.xstream.XStream;

//演示XStream
public class Demo1 {

	public static void main(String[] args) {
		List<Province> pros = getProvinces();
		//创建XStream对象
		XStream xStream = new XStream();
		
		//给指定类型指定别名
		xStream.alias("china", List.class);  //List类型默认对应<List>，我们指定List类型别名为china
		xStream.alias("province", Province.class);  //Province类型对应<cn.daxiong.Demo.Province>，我们指定Province类型别名为province,类名就不会显示了
		xStream.alias("city", City.class);  //city类型对应<cn.daxiong.Demo.City>，我们指定City类型别名为city,类名就不会显示了
		
		//将javaBean中Province类型的name属性，变成XML文件中<province>元素的属性  
		xStream.useAttributeFor(Province.class,"name");  //指定Java中的Province类型的name属性应用为Attribute
		
		//去除<cities>这样的Collection类型的属性
		xStream.addImplicitCollection(Province.class, "cities");  //去除Province类的名为cities的List属性，  List属于Collection集合
		
		//去除不想要的JavaBean City类的discription属性，让它不生成对应的xml元素
		xStream.omitField(City.class,"description");
		
		//调用toXML把集合转成字符串
		String s = xStream.toXML(pros);
		System.out.println(s);
	}

	// 返回JavaBean集合
	public static List<Province> getProvinces() {
		Province p1 = new Province();
		p1.setName("南京");
		p1.addCity(new City("江宁区","jiangningqu"));
		p1.addCity(new City("雨花区","yuhuaqu"));
		p1.addCity(new City("玄武区","xuanwuqu"));
		
		Province p2 = new Province();
		p2.setName("湖北");
		p2.addCity(new City("武汉","wuhan"));
		p2.addCity(new City("荆州","jingzhou"));
		
		List<Province> provinces = new ArrayList<Province>();
		provinces.add(p1);
		provinces.add(p2);
		
		return provinces;
	
	}
}
