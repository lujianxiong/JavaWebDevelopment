<h1>b.jsp</h1>
<%
	request.setCharacterEncoding("utf-8");
	String s1 = request.getParameter("songyanfei");
	String s2 = request.getParameter("1hao");
	
	out.print(s1);
	out.print(s2);
%>