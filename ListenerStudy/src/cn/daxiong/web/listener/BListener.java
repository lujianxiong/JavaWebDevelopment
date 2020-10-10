package cn.daxiong.web.listener;

import javax.servlet.ServletContextAttributeEvent;
import javax.servlet.ServletContextAttributeListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class BListener implements ServletContextAttributeListener {

    public void attributeAdded(ServletContextAttributeEvent scae)  { 
    	System.out.println("您向application中添加了名为："+scae.getName()+"，值为："
    				+scae.getValue()+"的属性！");
    }

    public void attributeReplaced(ServletContextAttributeEvent scae)  { 
    	System.out.println(scae.getName()+"="+scae.getValue()+", "
    			+scae.getServletContext().getAttribute(scae.getName()));
    }
	
    public void attributeRemoved(ServletContextAttributeEvent scae)  { 
    	System.out.println(scae.getName()+"="+scae.getValue());
    }

}
