package cn.daxiong.tag;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;

/*
 * SimpleTagSupport已经实现了SimpleTag接口
 * 它已经把所有tomcat传递来的数据都保存起来了，并且还提供了get方法供子类调用！
 */
public class MyTag2 extends SimpleTagSupport {
	@Override
	public void doTag() throws JspException, IOException {
		this.getJspContext().getOut().print("再 Hello 一次 Tag");
	}
}
