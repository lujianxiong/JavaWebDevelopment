package cn.daxiong.web.listener;
//ServletContext生死监听
import javax.servlet.ServletContextEvent;

import javax.servlet.ServletContextListener;

public class AListener implements ServletContextListener {
	
	@Override
	public void contextInitialized(ServletContextEvent sce) {
		System.out.println("哇，我来也！");
	}
	
	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		System.out.println("哇！我挂了...");
	}

}
