<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>演示Cookie的MaxAge</h1>
<%-- 九大内置对象：request、response、session、application、pageContext、config、out、page、exception --%>
<%
	Cookie cookie1 = new Cookie("aaa","AAA");
	cookie1.setMaxAge(60*60);
	response.addCookie(cookie1);
%>

</body>
</html>