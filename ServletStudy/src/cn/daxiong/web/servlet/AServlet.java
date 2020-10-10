package cn.daxiong.web.servlet;
//查看Servlet接口中的方法
import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class AServlet implements Servlet {
	//它是生命周期方法  （由Tomcat来调用）
	//它会在Servlet销毁之前调用，并且只会被调用一次（它并不是Servlet销毁的方法、自杀的方法，是在销毁之前临终留遗言的方法）
	@Override
	public void destroy() {
		System.out.println("destory()...");
	}

	//获取Servlet的配置信息
	@Override
	public ServletConfig getServletConfig() {
		System.out.println("getServletConfig()...");
		return null;
	}

	//获取Servlet的信息
	@Override
	public String getServletInfo() {
		System.out.println("getServletInfo()...");
		return "我是一帅气的Servlet";
	}

	//它是生命周期方法  （由Tomcat来调用）
	//它会在Servlet对象创建之后马上执行，并且只执行一次  （出生之后调用）
	@Override
	public void init(ServletConfig servletConfig) throws ServletException {
		//获取指定初始化参数的值
		System.out.println(servletConfig.getInitParameter("宋妍霏"));
		System.out.println(servletConfig.getInitParameter("唐嫣"));
		//获取所有初始化参数的名称
		@SuppressWarnings("rawtypes")
		Enumeration e = servletConfig.getInitParameterNames();
		while(e.hasMoreElements()) {
			System.out.println(e.nextElement());
		}
	}

	//它是生命周期方法  （由Tomcat来调用）
	//它会被调用多次！！
	//每次处理请求都是在调用这个方法！
	@Override
	public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {
		System.out.println("service()...");
	}

}
