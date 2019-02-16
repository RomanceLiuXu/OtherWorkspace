<%@page import="com.lanou.Student"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset=UTF-8>
<title>接收数据</title>
</head>
<body>

	<%
		/* String name = request.getParameter("name");
		out.print(name); */

		Student student = (Student) request.getAttribute("student");
		
	%>
<%=student %>

</body>
</html>