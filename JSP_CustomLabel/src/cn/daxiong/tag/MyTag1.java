package cn.daxiong.tag;
//自定义标签 1
import java.io.IOException;

import javax.servlet.jsp.JspContext;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.JspFragment;
import javax.servlet.jsp.tagext.JspTag;
import javax.servlet.jsp.tagext.SimpleTag;

public class MyTag1 implements SimpleTag{
	private PageContext pageContext;
	private JspFragment body;

	//所有的setXxx()方法都会在doTag()方法之前被tomcat调用！
	//因此在doTag()中就可以使用tomcat传递的对象！
	@Override
	public void doTag() throws JspException, IOException {
		pageContext.getOut().print("Hello tag!");
	}

	@Override
	public JspTag getParent() {
		return null;
	}

	@Override
	public void setJspBody(JspFragment jspBody) {
		this.body = jspBody;
	}

	@Override
	public void setJspContext(JspContext context) {
		this.pageContext = (PageContext) context;  //父类到子类需要强转
	}


	public void setParent(JspTag parent) {}

}
