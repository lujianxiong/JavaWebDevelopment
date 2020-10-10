<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="dx" uri="/WEB-INF/tlds/daxiong-tag.tld" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<dx:myTag5 test="${empty param.xxx }">
	<h1><dx:myTag4/></h1>
</dx:myTag5>

<h1><dx:myTag1/></h1>

<h2><dx:myTag2/></h2>

<hr/>
<%
	request.setAttribute("xx", "宋妍霏");
%>
<dx:myTag3>${xx }</dx:myTag3>
	
</body>
</html>