package cn.daxiong.web.servlet;

import java.io.IOException;
import java.io.InputStream;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

/**
 * Servlet implementation class CityServley
 */
@WebServlet("/CityServlet")
public class CityServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CityServlet() {
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
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/xml;charset=utf-8");  //注意：发送xml形式的文件，这里要修改
		try {
			SAXReader reader = new SAXReader();
			InputStream input = this.getClass().getResourceAsStream("/china.xml");
			Document doc = reader.read(input);
			//1、获取省份名称
			String pname = request.getParameter("pname");
			//2、使用省份名称查找到对应的<province>元素
			Element proEle = (Element) doc.selectSingleNode("//province[@name='"+pname+"']");   //例如：province[@name='北京']
			//3、把<province>元素转换成字符串，发送给客户端
			String xmlStr  = proEle.asXML();    //asXML()方法：将该元素的开始到结束包含的所有内容组成字符串String
			response.getWriter().print(xmlStr);   //这里发送的xml文件，在上面设置了发送内容的格式为text/xml
		} catch (Exception e) {
			e.printStackTrace();
		}
	
	}

}
