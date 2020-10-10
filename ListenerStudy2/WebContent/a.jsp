<%@page import="cn.daxiong.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>向session中保存数据</h1>
<%
	session.setAttribute("xxx", new User());
%>

</body>
</html>