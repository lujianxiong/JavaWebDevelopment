package cn.daxiong.web.servlet;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.io.SAXReader;

/**
 * Servlet implementation class ProvinceServlet
 */
@WebServlet("/ProvinceServlet")
public class ProvinceServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProvinceServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//响应所有省份名称
		response.setContentType("text/html;charset=utf-8");
		try {
			//1、创建解析器对象
			SAXReader reader = new SAXReader();
			//2、调用解析器的读方法，传递一个流对象，得到Document
			InputStream input = this.getClass().getResourceAsStream("/china.xml");  //src下的要用/开头
			Document doc = reader.read(input);
			//查询所有province的name属性，得到一堆的属性对象
			@SuppressWarnings("unchecked")
			List<Attribute> arrlist = doc.selectNodes("//province/@name"); //XPATH
			//循环遍历，把所有属性值连接成一个字符串，然后发送给客户端
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < arrlist.size(); i++) {
				sb.append(arrlist.get(i).getValue());    //把每个属性的值存放到sb中
				if(i<arrlist.size()-1) {
					sb.append(",");
				}
			}
			response.getWriter().print(sb);
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
