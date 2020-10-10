<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>演示JSP的中的java脚本</h1>  <br>

<% 
	int a = 10;
%>

<%
	out.print(a++);
%>  <br>

<%=a %>  <br>

<%!
	int a = 100;
	public void fun1(){
		System.out.println(a);
	}
%>

<%
	out.print(this.a++);
	fun1();
%>

</body>
</html>