package cn.daxiong.servlet;
//演示获取类路径下的资源
import java.io.IOException;
import java.io.InputStream;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.IOUtils;

/**
 * Servlet implementation class BServlet
 */
@WebServlet("/BServlet")
public class BServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
////相对/classes目录
//		//1、先得到Class，再得到ClassLoader
//		ClassLoader c1 = getClass().getClassLoader();
//		//2、调用其getResourceAsStream()，得到一个InputStream
//		InputStream input = c1.getResourceAsStream("cn/daxiong/servlet/a.txt");
		
//相对当前.class文件所在的目录
		//1、得到class
		Class c2 = getClass();
		//2、得到InputStream
//		InputStream input = c2.getResourceAsStream("a.txt");
		//加个“/”，相表示相对classes目录下
		InputStream input = c2.getResourceAsStream("/a.txt");
		//3、读取输入流内容，转换成字符串返回（利用commons-io工具）
		String s = IOUtils.toString(input);	
		System.out.println(s);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
