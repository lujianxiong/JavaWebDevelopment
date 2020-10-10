package cn.daxiong.tag;
//带有属性的标签
import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class MyTag5 extends SimpleTagSupport {
	private boolean test;
	
	//这个方法会由tomcat来调用，并且在doTag()之前调用
	public void setTest(boolean test) {
		this.test = test;
	}

	@Override
	public void doTag() throws JspException, IOException {
		if (test) {
			//执行标签体
			//invoke里写nul和写getJspContext().getOut()是一样的
			this.getJspBody().invoke(null);  //如果传递的输出流为null，默认使用当前页面的out！
		}
	}
}
