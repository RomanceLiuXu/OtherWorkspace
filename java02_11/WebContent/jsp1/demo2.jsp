<%@page import="com.lanou.Student"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset=UTF-8>
<title>作业1-接收</title>
</head>
<body>
<%
//分发-接收
// String name = request.getParameter("name");
//重定向-接收
String name1 = (String)request.getAttribute("name");
String sex = request.getParameter("sex");
//对象接收
Student stu =(Student)request.getAttribute("student");
%>
<%=name1+"--"+sex+stu %>

</body>
</html>