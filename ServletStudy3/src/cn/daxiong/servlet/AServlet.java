package cn.daxiong.servlet;
//给出多个请求处理方法
//请求处理方法：除了名称以外，都与service相同
import java.io.IOException;
import java.lang.reflect.Method;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/AServlet")
public class AServlet extends BaseServlet {
	
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
