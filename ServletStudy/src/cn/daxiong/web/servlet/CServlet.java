package cn.daxiong.web.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class CServlet extends BServlet {
	//覆写无参的init不会覆盖掉系统调用的init有参方法
	@Override
	public void init() {
		System.out.println("哇～～，我出生了，我好开心～～～～");
	}
	
	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		String value = getInitParameter("宋妍霏");
	}

}
