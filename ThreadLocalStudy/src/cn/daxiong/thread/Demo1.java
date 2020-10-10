package cn.daxiong.thread;

import java.util.HashMap;
import java.util.Map;

//TreadLocal对象用法
public class Demo1 {

	public static void main(String[] args) {
		final ThreadLocal<String> t1 = new ThreadLocal<String>();
		t1.set("hello");  //存
		String s = t1.get();  //取
		t1.remove();  //删
		System.out.println(s);
		
		//匿名内部类
		new Thread() {
			public void run() {
				System.out.println("内部类"+t1.get());
			}
		}.start();
	}
}

/**
 * 我们模拟一下ThreadLocal类，它的内部其实是一个Map。它其实就相当于是银行的保险箱，一人一个小箱，你看不了别人箱子里的东西
 * @author 鲁建雄
 *
 * @param <T>
 */
class TL<T>{
	private Map<Thread,T> map = new HashMap<Thread, T>(); 
	
	public void set(T data) {
		//使用当前线程做key
		map.put(Thread.currentThread(), data);
	}
	
	public T get() {
		return map.get(Thread.currentThread());
	}
	
	public void remove() {
		map.remove(Thread.currentThread());
	}
	
}
