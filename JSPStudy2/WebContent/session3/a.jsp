<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<a href="/JSPStudy2/AServlet;JSSESSIONID=<%= session.getId() %>">点击这里</a>
<a href="/JSPStudy2/AServlet;JSSESSIONID=<%= session.getId() %>">点击这里</a>
<a href="/JSPStudy2/AServlet;JSSESSIONID=<%= session.getId() %>">点击这里</a><br>

<%
	//他会查看Cookie是否存在，如果不存在，在指定的url后添加JSESSIONID参数
	//如果Cookie存在，它就不会在url后面添加任何东西！
	out.print(response.encodeURL("/JSPStudy2/AServlet"));
%>
</body>
</html>