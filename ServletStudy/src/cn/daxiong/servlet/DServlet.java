package cn.daxiong.servlet;
import java.io.FileInputStream;
//使用ServletContext获取资源路径
import java.io.IOException;
import java.io.InputStream;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DServlet
 */
@WebServlet("/DServlet")
public class DServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		//它得到的是有盘符的路径：D:/xxx/xx/x
//		//E:\tomcat\apache-tomcat-9.0.14\wtpwebapps\ServletStudy\login.html
//		String path = getServletContext().getRealPath("/login.html");
//		System.out.println(path);	
//		InputStream input = new FileInputStream(path);
//		
//		//获取资源的路径后，再创建出输入流对象
//		InputStream in = getServletContext().getResourceAsStream("/login.html");
		
		//获取当前路径下所有资源的路径
		Set<String> paths = getServletContext().getResourcePaths("/WEB-INF");
		System.out.println(paths);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
