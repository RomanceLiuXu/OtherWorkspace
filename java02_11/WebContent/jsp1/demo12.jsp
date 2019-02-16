
<%@page import="java.sql.ResultSetMetaData"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="com.lanou.SQLUtil2"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset=UTF-8>
<title>加载表中的所有内容</title>
</head>
<body>
	<table border="1px" cellpadding="20px" style="border-collapse: collapse;">
		<caption>信息表</caption>
		<thead>
			<tr>
				<th>s_id</th>
				<th>s_name</th>
				<th>s_birth</th>
				<th>s_sex</th>
			</tr>
		</thead>
		<tbody>
<%
		//调用查询方法
		//准备sql语句
		String sql = "select * from Student";
		ResultSet rs = SQLUtil2.queryMethod(sql, null);
		//遍历结果集
		while (rs.next()) {
			//取值
			int id = rs.getInt("s_id");
			String name = rs.getString("s_name");
			String birth = rs.getString("s_birth");
			String sex = rs.getString("s_sex");%>
			<tr>
			<td><%=id %></td>
			<td><%=name %></td>
			<td><%=birth %></td>
			<td><%=sex %></td>
			</tr>

		<%}
		SQLUtil2.myClose(rs);
	%>
		</tbody>
	</table>



	
</body>
</html>
