<%@page import="org.apache.jasper.tagplugins.jstl.core.If"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset=UTF-8>
<title>标题</title>
</head>
<body>
	<%-- 获取用户输入的内容和选择的运算符--%>
	<%
		String num1 = request.getParameter("num1");
		String num2 = request.getParameter("num2");
		String flag = request.getParameter("select");

		int one = Integer.parseInt(num1);
		int two = Integer.parseInt(num2);
		int sum = 0;
		if (flag.equals("+")) {
			//加法
			sum = one + two;

		} else if (flag.equals("-")) {
			sum = one - two;
		} else if (flag.equals("*")) {
			sum = one * two;
		} else {
			if (two != 0) {
				sum = one / two;
			}else{
				out.print("除数不能为0");
			}
		}
	%>
	<%=sum%>


</body>
</html>