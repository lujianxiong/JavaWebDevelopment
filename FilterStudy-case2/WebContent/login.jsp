<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>登录</h1>
${ErrorMsg }
<form action="<c:url value='/LoginServlet' />" method="post">
	用户名：<input type="text" name="username" />
	<input type="submit" value="登录" />
</form>

</body>
</html>