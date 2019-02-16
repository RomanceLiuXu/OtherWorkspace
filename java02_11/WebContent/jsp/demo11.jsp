<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%--执行指令（确定该页面是否是错误时跳转的页面） --%>
    <%@page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset=UTF-8>
<title>异常(exception)</title>
</head>
<body>
<div>出错啦</div>
<%-- exception--%>
<%

String msg = exception.getMessage();
String str = exception.fillInStackTrace().toString();
%>
<%=msg %>
<%=str %>
</body>
</html>