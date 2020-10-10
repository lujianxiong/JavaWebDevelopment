package cn.daxiong.servlet;

import java.io.IOException;
import java.lang.reflect.Method;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public abstract class BaseServlet extends HttpServlet {

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String methodName = request.getParameter("method");
		if (methodName == null || methodName.trim().isEmpty()) {
			throw new RuntimeException("您没有传递method参数！无法确定您想要调用的方法！");
		}
		Class c = this.getClass();
		Method method = null;
		
		try {
			method = c.getMethod(methodName,
					HttpServletRequest.class,HttpServletResponse.class);
		} catch (Exception e) {
			throw new RuntimeException("您要调用的方法："+methodName+"，它不不存在！！！");
		}
		
		try {
			//正常调用：this.addUser(request,response);   反射调用：method.invoke(this,request,response);
			method.invoke(this, request,response);   
		} catch (Exception e) {
			System.out.println("您调用的方法"+methodName+"，它内部抛出了异常！！");
			throw new RuntimeException(e);
		}
	}
   
	protected void addUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("addUser()...");
	}

	protected void editUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("editUser()...");
	}
	
	protected void deleteUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("deleteUser()...");
	}

}
