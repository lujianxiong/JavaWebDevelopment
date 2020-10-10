<%@page import="cn.daxiong.web.listener.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	User user = new User();
	session.setAttribute("user", user);
%>

</body>
</html>