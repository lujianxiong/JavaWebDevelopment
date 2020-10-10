<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="cn.daxiong.domain.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	Address add = new Address();
	add.setCity("南京");
	add.setStreet("淳化街道");
	Employee emp = new Employee();
	emp.setName("宋妍霏");
	emp.setSalary(99999);
	emp.setAdd(add);
	request.setAttribute("emp", emp);
%>
<h1>使用EL获取request域的emp的address属性的street</h1>
<!-- 等同于request.getAttribute("emp").getAdd().getStreet()，但不能那样写，在EL表达式中，使用.属性 -->
${requestScope.emp.add.street } <br/>
${emp.hehe }

</body>
</html>