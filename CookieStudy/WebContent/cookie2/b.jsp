<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>删除Cookie</h1>
<%
	Cookie cookie1 = new Cookie("aaa","AAA");
	cookie1.setMaxAge(0);
	response.addCookie(cookie1);
%>

</body>
</html>