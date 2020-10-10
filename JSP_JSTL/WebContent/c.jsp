<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<c:set var="code" value="<script>alert('hello');</script>" scope="request" />
<c:out value="${code }" />  <br/>

<c:url value="/AServlet" /> <br/>
${pageContext.request.contextPath }/AServlet  <br/>

<a href="<c:url value='/demo.jsp' />">点击这里，回到主页</a>  <br/>

<c:url value="/demo.jsp" >
	<c:param name="username" value="宋妍霏"></c:param>
</c:url>
<hr />

<c:if test="${empty param.name }">您没有给出名为name的参数</c:if>
<hr/>

<c:choose>
	<c:when test="${empty param.name }">您没有给出名为name的参数</c:when>
	<c:otherwise>您给出了name的参数!参数值为${param.name }</c:otherwise>
</c:choose>
<br/>

<c:forEach var="i" begin="1" end="10" step="2">
	${i } <br/>
</c:forEach>
<hr/>

<%
	String[] strs = {"one","two"};
	request.setAttribute("strs", strs);
%>
<c:forEach items="${requestScope.strs }" var="str">
	${str } <br/>
</c:forEach>
<hr/>

<%
	ArrayList<String> list = new ArrayList<String>();
	list.add("一");
	list.add("二");
	list.add("三");
	pageContext.setAttribute("list", list);
%>
<c:forEach items="${list }" var="ele" varStatus="vs">
	${vs.index } ${vs.count } ${vs.first } ${vs.last } ${vs.current }<br/>
</c:forEach>


</body>
</html>