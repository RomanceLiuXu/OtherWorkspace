<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <!-- 执行指令（指定报错时要跳转的页面） -->
    <%@ page errorPage="demo11.jsp" %>
    <%@ page  %>
<!DOCTYPE html>
<html>
<head>
<meta charset=UTF-8>
<title>异常</title>
</head>
<body>


<%
int a = 3 / 0;
out.print(a);

%>



</body>
</html>