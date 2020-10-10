package cn.daxiong.test;

import org.apache.commons.beanutils.BeanUtils;

public class Demo1 {

	public static void main(String[] args) throws Exception{
		String className = "cn.daxiong.domain.Person";
		Class clazz = Class.forName(className);
		Object bean = clazz.newInstance();
		
		BeanUtils.setProperty(bean, "name", "宋妍霏");
		BeanUtils.setProperty(bean, "age", "24");
		BeanUtils.setProperty(bean, "gender", "女");
		String age = BeanUtils.getProperty(bean, "age");
		System.out.println(age);
		System.out.println(bean.toString());
	}
}
