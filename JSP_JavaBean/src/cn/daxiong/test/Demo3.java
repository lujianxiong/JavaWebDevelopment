package cn.daxiong.test;

import java.util.HashMap;
import java.util.Map;

import cn.daxiong.domain.User;
import cn.daxiong.utils.CommonUtils;

public class Demo3 {
	public static void main(String[] args) {
		Map<String, String> map = new HashMap<String, String>();
		map.put("username", "宋妍霏");
		map.put("password", "Lu's woman");
		
		User user = CommonUtils.toBean(map, User.class);
		System.out.println(user);
	}

}
