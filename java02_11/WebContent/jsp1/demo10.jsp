<%@page import="com.lanou.SQLUtil2"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset=UTF-8>
<title>连接数据库修改操作</title>
</head>
<body>
<%
		String str = "";
		//实例化
		SQLUtil2 util = new SQLUtil2();
		//获取数据
		String id = request.getParameter("id");
		String name = request.getParameter("code");
		String money = request.getParameter("money");
		if (name != null && !name.equals("") && money != null && !money.equals("")&&id!=null&&!id.equals("")) {
			int m = Integer.parseInt(money);
			int i = Integer.parseInt(id);
			//准备sql语句
			String sql = "update my set name='"+name+"'"+",money="+m+" where id="+i;
			System.out.print(sql);
			//调用方法
			boolean is = SQLUtil2.add(sql);
			if (is) {
				str = "修改成功";
			} else {
				str = "修改失败";
			}
		}
	%>
	<%=str%>

</body>
</html>