<%@page import="com.lanou.SQLUtil2"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset=UTF-8>
<title>连接数据库添加数据</title>
</head>
<body>
	<%
		String str = "";
		//实例化
		SQLUtil2 util = new SQLUtil2();
		//获取数据
		String name = request.getParameter("code");
		String money = request.getParameter("money");
		if (name != null && !name.equals("") && money != null && !money.equals("")) {
			int m = Integer.parseInt(money);
			//准备sql语句
			String sql = "insert into my(name,money) values('" + name + "'," + m + ")";
			//调用方法
			boolean is = SQLUtil2.add(sql);
			if (is) {
				str = "添加成功";
			} else {
				str = "添加失败";
			}
		}
	%>
	<%=str%>
</body>
</html>