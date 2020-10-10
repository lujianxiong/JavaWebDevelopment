package cn.daxiong.uuid;

import java.util.UUID;

import cn.daxiong.commons.CommonUtils;

public class UUIDTest {
	public static void main(String[] args) {
		UUID uuid = UUID.randomUUID();
		String str = uuid.toString();
		str = str.replace("-", "");
		str = str.toUpperCase();
		System.out.println(str);
		
		System.out.println(CommonUtils.uuid());
	}
}
