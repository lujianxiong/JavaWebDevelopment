package cn.daxiong.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/AServlet")
public class AServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1、获取参数
		String s1 = request.getParameter("num1");
		String s2 = request.getParameter("num2");
		//2、转换成int类型
		int num1 = Integer.parseInt(s1);
		int num2 = Integer.parseInt(s2);
		//3、进行加运算
		int sum = num1 + num2;
		//4、把结果保存到request域中
		request.setAttribute("result", sum);
		//5、转发到result.jsp
		request.getRequestDispatcher("/jia/result.jsp").forward(request, response);
	}

}
