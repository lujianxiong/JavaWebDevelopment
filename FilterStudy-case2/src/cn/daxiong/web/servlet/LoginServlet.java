package cn.daxiong.web.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1、首先获取用户名
		String name = request.getParameter("username");
		//2、判断用户名中是否包含daxiong
		if (name.contains("daxiong")) {
			// 包含daxiong，就是管理员,并将信息保存到session中
			request.getSession().setAttribute("admin", name);
		}else {
			// 不包含daxiong，就是普通会员,并将信息保存到session中
			request.getSession().setAttribute("username", name);
		}
		//3、转发到index.jsp
		request.getRequestDispatcher("/index.jsp").forward(request, response);
	}

}
