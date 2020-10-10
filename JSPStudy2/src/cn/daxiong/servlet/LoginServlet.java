package cn.daxiong.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1、处理中文问题
				request.setCharacterEncoding("utf-8");
				
		/*
		 * 校验验证码：
		 * 1、从session中获取正确的验证码
		 * 2、从表单中获取用户填写的验证码
		 * 3、进行比较
		 * 4、如果相同，向下运行；否则保存错误信息到request域，转发到login.jsp
		 */
		String sessioncode = (String) request.getSession().getAttribute("session_vcode");
		String paramcode = request.getParameter("verifyCode");
		if (!paramcode.equalsIgnoreCase(sessioncode)) {  //如果两个code不相等
			request.setAttribute("msg", "验证码错误！！");
			request.getRequestDispatcher("/session2/login.jsp").forward(request, response);
			return;
		}

		//2、获取表单数据
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		//3、校验用户名和密码是否正确
		if (!"daxiong".equalsIgnoreCase(username)) {
			/* 
			 * 把用户名保存到cookie中，发送给客户端浏览器
			 * 当再次打开login.jsp时，login.jsp中会读取request中的cookie，把它显示到用户名文本框中。
			 */
			Cookie cookie = new Cookie("un", username);
			cookie.setMaxAge(60*60*24);  //设置cookie命长为一天
			response.addCookie(cookie);  //保存cookie
			
			//如果用户名不是daxiong（包括大小写）--> 登录成功！
			//获取session
			HttpSession session = request.getSession();
			//保存用户信息到session中
			session.setAttribute("username", username);
			//重定向到succ1.jsp  【重定向必须加项目名】  (转发不用加项目名)
			response.sendRedirect("/JSPStudy2/session2/succ1.jsp");  //这里重定向是因为用户信息保存在session中，重定向之后依然存在
		}else {
			//登录失败！
			//保存错误信息到request域中
			request.setAttribute("msg", "用户名或密码错误!!");
			//转发到login.jsp
			RequestDispatcher rd = request.getRequestDispatcher("/session2/login.jsp");  //得到转发器
			rd.forward(request, response);  //转发          这里转发因为重定向相当于第二次请求，request域中的东西就没了
			
		}
	}

}
