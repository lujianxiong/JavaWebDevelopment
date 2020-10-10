package cn.daxiong.web.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

@WebFilter("/*")
public class EncodingFilter implements Filter {

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
//处理POST请求编码问题
		request.setCharacterEncoding("utf-8");
		
		//强转处理request
		HttpServletRequest req = (HttpServletRequest) request;
		if (req.getMethod().equals("GET")) {  
//处理GET请求编码问题
			//1、new一个request的装饰类的对象
			EncodingRequest er = new EncodingRequest(req);
			//2、放行时，用我们自己的request
			chain.doFilter(er, response);
		}else if (req.getMethod().equals("POST")) {  //如果是POST就直接放行，我们在最开始处理了POST请求了
			chain.doFilter(request, response);
		}
		
	}
}
