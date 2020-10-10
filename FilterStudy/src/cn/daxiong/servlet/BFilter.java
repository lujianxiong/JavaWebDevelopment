package cn.daxiong.servlet;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class BFilter implements Filter {
	// 每次过滤时都会执行
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		System.out.println("BFilter#start");
		chain.doFilter(request, response); // 放行！！！
		System.out.println("BFilter#end");
	}
}
