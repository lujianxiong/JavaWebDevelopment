<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>a.jsp</h1>
<!--请求转发 -->
<jsp:forward page="b.jsp">
	<jsp:param value="宋妍霏！" name="songyanfei"/>
	<jsp:param value="songyanfei,kuaidaowochuangshanglai" name="1hao"/>
</jsp:forward>

</body>
</html>