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
<h1>这个页面谁都可以访问</h1>
<a href="<c:url value='/index.jsp'/>">游客入口</a>  <br />
<a href="<c:url value='/users/u.jsp'/>">会员入口</a>  <br />
<a href="<c:url value='/admin/a.jsp'/>">管理员入口</a>  <br />

</body>
</html>