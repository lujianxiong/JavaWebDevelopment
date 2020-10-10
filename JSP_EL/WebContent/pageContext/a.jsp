<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
${pageContext.request.contextPath }
<hr>

<a href="${pageContext.request.contextPath }/el/a.jsp">点击这里</a>

<form action="${pageContext.request.contextPath }/cookie/a.jsp" method="post">
	<input type="submit" value="提交" />
</form>

</body>
</html>