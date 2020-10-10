<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<script type="text/javascript">
function _change() {
	//1、得到img元素
	var imgEle = document.getElementById("img");
	//2、修改src为/JSPStudy2/VerifyCodeServlet
	imgEle.src = "/JSPStudy2/VerifyCodeServlet?a=" + new Date().getTime();
}
</script>

</head>
<body>
<!-- 本页面提供登录表单，还要显示错误信息 -->
<h1>登录</h1>
<%
	//读取名为un的cookie
	//如果为空，显示" "
	//如果不为空，显示un的值
	String un = "";
	Cookie[] cs = request.getCookies();  //获取请求中所有的cookie
	if(cs != null){  //如果存在cookie
		for(Cookie c:cs){  //遍历所有cookie
			if("un".equals(c.getName())){  //查找名为nu的cookie
				un = c.getValue();  //获取这个cookie的值
			}
		}
	}
%>
<%
	String message = "";
	String msg = (String)request.getAttribute("msg");    //获取request域中名为msg的属性
	if(msg != null){
		message = msg;
	}
%>
<font color="red"><b><%=message %></b></font>
<form action="/JSPStudy2/LoginServlet" method="post">
					<!-- 把Cookie中的用户名显示到用户名文本框中 -->
	用户名：<input type="text" name="username" value="<%=un %>" /><br>
	密    码：<input type="password" name="password" /><br>
	验证码：<input type="text" name="verifyCode" size="3" />
		  <img id="img" src="/JSPStudy2/VerifyCodeServlet" />
		  <a href="javascript:_change()">换一张</a>
		  <br>
		  <input type="submit" value="登录" />
</form>

</body>
</html>