<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset=UTF-8>
<title>获取cookie的数据</title>
</head>
<body>
<%
Cookie[] cookies = request.getCookies();
//遍历
for(Cookie cookie : cookies){
	String key = cookie.getName();
	if(!key.equals("JSESSIONID")){
		String value = cookie.getValue();%>
	<%=key+":"+value %>
<% }}

%>
</body>
</html>