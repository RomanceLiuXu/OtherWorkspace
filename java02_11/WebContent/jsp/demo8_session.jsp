<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset=UTF-8>
<title>获取session的值</title>
</head>
<body>

<%
session.removeAttribute("code");
// String code = (String)session.getAttribute("code");
String psw = (String)session.getAttribute("psw");

%>
<%-- <%=code %> --%>
<%=psw %>
</body>
</html>