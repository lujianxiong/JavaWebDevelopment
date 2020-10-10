package cn.daxiong.web.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

/**
 * Servlet Filter implementation class AdminFilter
 */
@WebFilter("/admin/*")
public class AdminFilter implements Filter {

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		//1、得到session
		HttpServletRequest hreq = (HttpServletRequest) request;
		String admin = (String) hreq.getSession().getAttribute("admin");
		//2、判断session中是否有admin，如果存在，放行！
		if (admin != null) {
			chain.doFilter(request, response);
		}else {
			request.setAttribute("ErrorMsg", "您可能是个啥，但不是管理员，不要瞎溜达!");
			request.getRequestDispatcher("/login.jsp").forward(request, response);
		}
	}

}
