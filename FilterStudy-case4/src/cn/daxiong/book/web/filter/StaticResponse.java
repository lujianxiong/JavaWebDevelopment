package cn.daxiong.book.web.filter;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;

public class StaticResponse extends HttpServletResponseWrapper {
	private HttpServletResponse response;
	private PrintWriter pw;

	//path：html文件的路径
	public StaticResponse(HttpServletResponse response,String path) throws Exception{
		super(response);
		this.response = response;
		//创建一个与html文件路径绑定在一起的PrintWriter流对象
		pw = new PrintWriter(path, "utf-8");   //这个构造器是会自动创建path路径下的文件的
	}
	
	//jsp页面用这个方法进行输出，这样数据都输出到html文件中了
	public PrintWriter getWriter() {
		//返回一个与html绑定的PrintWriter对象
		return pw;
	}

}
