<%@page import="com.lanou.Student"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset=UTF-8>
<title>内置对象</title>
</head>
<body>

	<!-- out -->
<% 

Student s = new Student("liu","nan",18);
out.write("你好1");
out.print("你好2");
out.println(s);
out.print("你好3");
%>

<!--
request:跳转页面(jsp)
response:发送请求（跳转页面jsp） 
-->
<%
//重定向
// response.sendRedirect("demo1.jsp");
//response.sendRedirect("test.jsp?name=liuxu");

//分发
// request.getRequestDispatcher("demo1.jsp").forward(request, response);

//传递对象
// request.setAttribute("student", s);
//（由于地址栏没有发生变化，前端无法获取到所带的参数，但是在jsp中可以获取到）
// request.getRequestDispatcher("test.jsp?name=liuxu1").forward(request, response);


%>
<%--application --%>
   
<%


//设置applcation
// application.setAttribute("count", 1);
//删除
//application.removeAttribute("count");
// Integer a = (Integer)application.getAttribute("count");
//页面的计数器
 Integer num=(Integer) application.getAttribute("count");
 if(num==null){
	 application.setAttribute("count", 1);
	 num = 1;
 }else{
	 application.setAttribute("count", ++num);
 }
 
%>
<%! 
int n = 0;
%>
<% application.setAttribute("coun", ++n); 
 Integer n1 = (Integer)application.getAttribute("coun");
%>
 <%="第"+n1+"次访问" %> 
</body>
</html>