<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	Date date = new Date();
	request.setAttribute("date", date);
%>
<fmt:formatDate value="${requestScope.date }" pattern="yyyy-MM-dd HH:mm:ss"/>
<hr/>

<%
request.setAttribute("num1", 3.1);
%>
<fmt:formatNumber value="${requestScope.num1 }" pattern="0.000" /> <br/>
<fmt:formatNumber value="${requestScope.num1 }" pattern="#.###" />




</body>
</html>