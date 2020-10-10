package cn.daxiong;

import java.io.Serializable;

import javax.servlet.http.HttpSessionActivationListener;
import javax.servlet.http.HttpSessionEvent;

public class User implements HttpSessionActivationListener,Serializable{
	@Override
	public void sessionWillPassivate(HttpSessionEvent se) {
		System.out.println("啊～我陪session去火星了！（从内存跑到硬盘了）");
	}
	
	@Override
	public void sessionDidActivate(HttpSessionEvent se) {
		System.out.println("啊～我又回到地球了！（重新加载到内存了）");
	}

}
