package cn.daxiong.commons;

import java.util.UUID;

public class CommonUtils {
	public static String uuid() {
		return UUID.randomUUID().toString().replace("-", "").toUpperCase();
	}

}
