package cn.daxiong.test;
//把map中的属性直接封装在一个javabean中  (map的键必须和javabean中的属性名对应相同)
//map{"username":"宋妍霏", "password":"Lu's woman"}
import java.util.HashMap;
import java.util.Map;
import org.apache.commons.beanutils.BeanUtils;

import cn.daxiong.domain.User;

public class Demo2 {
	public static void main(String[] args) throws Exception{
		Map<String, String> map = new HashMap<String, String>();
		map.put("username", "宋妍霏");
		map.put("password", "Lu's woman");
		
		User user = new User();
		BeanUtils.populate(user, map);
		System.out.println(user);
	}

}
