package cn.daxiong.util;

public class Math {
	private Math() {}    //构造方法私有化，不让外部产生对象
	public static int add(int x, int y) {
		int result = 0;
		result = x + y;
		return result;
	}
}
