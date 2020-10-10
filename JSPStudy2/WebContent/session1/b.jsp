
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>从session域中获取数据</h1>
<%
	String s = (String)session.getAttribute("女神");
%>
<%=s %>
</body>
</html>