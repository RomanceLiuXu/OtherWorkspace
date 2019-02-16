<%@page import="com.lanou.Student"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset=UTF-8>
<title>内置对象(不常用)</title>
</head>
<body>
	<%-- page 几乎不用--%>
	<%
		// 		Student student = new Student("hah", "ss", 18);
		// 		boolean is = page.equals(student);
	%>
	<!-- pageContext -->
	<!-- 四大容器 -->
	<%
		//application.setAttribute("aa", "aa");
		//request.setAttribute("aa", "bb");
		//session.setAttribute("aa", "cc");
		//pageContext.setAttribute("aa", "dd");
		//session.removeAttribute("aa");
	%>
	<%-- 通过pageContext给四大容器设置值 --%>
	<%
		pageContext.setAttribute("name", "lhl1", pageContext.APPLICATION_SCOPE);
		pageContext.setAttribute("name", "lhl2", pageContext.REQUEST_SCOPE);
		pageContext.setAttribute("name", "lhl3", pageContext.SESSION_SCOPE);
	%>

	<%-- 通过pageContext的findAttribute方法获取四大容器的值
	由大往小
	pageContext -->  request-->  session--> application
	
	--%>
	<%
		pageContext.setAttribute("one", "111");
		String one = (String) pageContext.getAttribute("one");
		// String aa = (String)pageContext.getAttribute("aa");不可以获取到值,为设置标示
		String aa = (String) pageContext.findAttribute("aa");//可以获取到值
	%>

	<%--通过pageContext及其标示获取四大容器的值 --%>
	<%
		String name = (String) pageContext.getAttribute("name", pageContext.APPLICATION_SCOPE);
		String name1 = (String) pageContext.getAttribute("name", pageContext.REQUEST_SCOPE);
		String name2 = (String) pageContext.getAttribute("name", pageContext.SESSION_SCOPE);
	%>



	<%=one%>
	<%=aa%>
	<%=name%>
	<%=name1%>
	<%=name2%>
</body>
</html>