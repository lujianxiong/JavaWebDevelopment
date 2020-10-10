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
	pageContext.setAttribute("xxx", "pageContext_XXX");
	request.setAttribute("xxx", "request_XXX");
	session.setAttribute("xxx", "session_XXX");
	application.setAttribute("xxx", "application_XXX");
%>

${xxx } <br/>

${pageScope.xxx }  <br/>
${requestScope.xxx }  <br/>
${sessionScope.xxx }  <br/>
${applicationScope.xxx }  <br/>

</body>
</html>