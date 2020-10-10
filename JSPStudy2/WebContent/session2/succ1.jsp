<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>succ1</h1>
<%
	String username = (String)session.getAttribute("username");
	if(username == null){
		//1、向request域中保存错误信息，转发到login.jsp
		request.setAttribute("msg", "你没有穿性感睡衣，不许侍寝！");
		//2、转发到login.jsp
		request.getRequestDispatcher("/session2/login.jsp").forward(request, response);	
		return;
	}
%>
欢迎<%=username %>女神来侍寝～～

</body>
</html>