package cn.daxiong.web.filter;
//从application中获取Map
//从request中得到当前客户端的IP
//进行统计工作，结果保存到Map中
import java.io.IOException;
import java.util.Map;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

@WebFilter("/*")
public class AFilter implements Filter {
	private FilterConfig fconfig;
	
	//在服务器启动时就会执行此方法，且本方法只执行一次
	public void init(FilterConfig filterConfig) throws ServletException {
		this.fconfig = filterConfig;
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		//1、得到application中的Map
		ServletContext app = fconfig.getServletContext();
		Map<String,Integer> map = (Map<String, Integer>) app.getAttribute("map");
		//2、从request中获取当前客户端的IP地址
		String ip = request.getRemoteAddr();
		//3、进行判断
		if (map.containsKey(ip)) {
			// ip在map中，次数+1并保存回去
			int count = map.get(ip);
			map.put(ip, count+1);
		}else {
			// ip不存在，第一次访问，设置访问次数为1
			map.put(ip, 1);
		}
		//把map放回到app中
		app.setAttribute("map", map);  
		//放行
		chain.doFilter(request, response);  
	}

}






