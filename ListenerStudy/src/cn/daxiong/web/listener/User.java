package cn.daxiong.web.listener;

import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionBindingListener;

public class User implements HttpSessionBindingListener{
	private String username;
	private String password;
	
	public User() {
		super();
	}
	public User(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}

	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "User [username=" + username + ", password=" + password + "]";
	}
	
	
	@Override
	public void valueBound(HttpSessionBindingEvent event) {
		System.out.println("啊～Session添加了我！");
	}
	
	
	@Override
	public void valueUnbound(HttpSessionBindingEvent event) {
		System.out.println("哇～无情的Session抛弃了我！");
	}
	
}
