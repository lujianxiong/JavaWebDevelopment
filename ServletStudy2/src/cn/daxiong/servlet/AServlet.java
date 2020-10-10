package cn.daxiong.servlet;
//统计访问量
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AServlet
 */
@WebServlet("/AServlet")
public class AServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1、获取ServletContext对象
		ServletContext app = getServletContext();
		//2、从ServletContext对象中获取名为count的属性
		Integer count = (Integer) app.getAttribute("count");
		if (count == null) {
			//3、如果不存在，说明是第一次访问，向ServletContext中保存名为count的属性，值为1
			app.setAttribute("count", 1);
		}else {
			//4、如果存在，给访问量+1，保存
			app.setAttribute("count", count+1);
		}
		
		//向浏览器输出
		PrintWriter pw = response.getWriter();
		pw.print("<h1>"+count+"</h1>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
