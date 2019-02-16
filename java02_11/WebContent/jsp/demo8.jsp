<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset=UTF-8>
<title>session(内置对象)\cookie</title>
</head>
<body>
<!-- session -->
<%

//设置session的值
// session.setAttribute("code", "lhl");
// session.setAttribute("psw", "123");
// //跳转
// response.sendRedirect("demo8_session.jsp");
%>
<!-- cookie 不是内置对象，需要自己实例化 -->
<% 
//设置cookie的值
Cookie cookie1 = new Cookie("name","lhl1");
Cookie cookie2 = new Cookie("password","123456");
//添加
response.addCookie(cookie1);
response.addCookie(cookie2);
response.sendRedirect("demo8_cookie.jsp");
%>
</body>
</html>