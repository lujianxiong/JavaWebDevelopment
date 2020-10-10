<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>

<title>全站字符编码问题</title>
</head>
<body>

<a href="<c:url value='/AServlet?username=Daxiong'/>">点击这里</a> <br/>
<form action="<c:url value='/AServlet'/>" method="post">
	用户名：<input type="text" name="username" value="李四" />
	<input type="submit" value="提交" />
</form>

</body>
</html>