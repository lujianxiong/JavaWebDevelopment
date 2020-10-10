package cn.daxiong.web.servlet;
//模拟GenericServlet
import java.io.IOException;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class BServlet implements Servlet {
	private ServletConfig config;

	@Override
	public void destroy() {
		System.out.println("啊～我要死了...");
	}

	//请放心，这个方法一定会在init()方法之后被调用！
	//init()被调用后，本类的成员this.config已经有值了！
	@Override
	public ServletConfig getServletConfig() {
		return this.config;
	}

	//没有用的东西，爱实现不实现
	@Override
	public String getServletInfo() {
		return "我是一个快乐的Servlet";
	}

	//由Tomcat来调用，并且只调用一次
	//它是这些方法中第一个被调用的，它会在构造器之后马上被调用！！
	@Override
	public void init(ServletConfig config) throws ServletException {
		//将tomcat传递的ServletConfig值赋给本类的一个成员，其实就是把它保存起来，方便在其他方法中使用！
		this.config = config;
		init();
	}
	
	//这个方法是本类自己定义的！不是Servlet接口中的方法
	//这个方法是我们用来给子类扩充init方法用的
	public void init() {
		
	}

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		//这里可以使用ServletConfig的成员
		System.out.println("每次处理请求都会被调用");
	}
	
	public ServletContext getServletContext() {
		return config.getServletContext();
	}
	
	public String getServletName() {
		return config.getServletName();
	}
	
	public String getInitParameter(String name) {
		return config.getInitParameter(name);
	}

}
