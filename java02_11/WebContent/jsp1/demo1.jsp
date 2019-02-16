<%@page import="com.lanou.Student"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset=UTF-8>
<title>作业1</title>
</head>
<body>

<!-- 分发 -->
<%
//response.sendRedirect("demo2.jsp?name=liuxu");

%>
<!-- 重定向 -->
<% 
//传递对象
Student student=new Student("kk","nan",12);
request.setAttribute("student", student);
//传递参数
request.setAttribute("name", "liuxu");
request.getRequestDispatcher("demo2.jsp?sex=nan").forward(request, response);
%>
</body>
</html>