<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset=UTF-8>
<title>config</title>
</head>
<body>
<%--获取和servlet相关的一些信息 --%>
	<%
		String name = config.getServletName();
		String path = config.getServletContext().getRealPath("WEB-INFO");
	%>
	<%=name + "---" + path%>
</body>
</html>