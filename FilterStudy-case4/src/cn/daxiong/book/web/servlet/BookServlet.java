package cn.daxiong.book.web.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.daxiong.book.dao.BookDao;

@WebServlet("/Book/*")
public class BookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private BookDao bookDao = new BookDao();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String pathInfo = request.getPathInfo();
		// 查找全部
		if ("/findAll".equals(pathInfo)) {
			request.setAttribute("bookList", bookDao.findAll());
			request.getRequestDispatcher("/show.jsp").forward(request, response);
		}
		
		// 按目录查找
		if ("/findByCategory".equals(pathInfo)) {
			String value = request.getParameter("category");
			int category = Integer.parseInt(value);
			request.setAttribute("bookList", bookDao.findByCategory(category));
			request.getRequestDispatcher("/show.jsp").forward(request, response);
			//response.sendRedirect(request.getContextPath()+"/show.jsp");
		}
	}

}
