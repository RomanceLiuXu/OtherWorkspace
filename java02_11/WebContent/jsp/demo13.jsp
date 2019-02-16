
<%@page import="java.sql.SQLException"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.DriverManager"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset=UTF-8>
<title>jdbc</title>
</head>
<body>
 <div style="color:red"><%=getData() %></div>   
</body>
</html>

<%!//数据库连接
	public String getData() {
	Connection connection=null;
	PreparedStatement ps= null;
	ResultSet rs = null;
	String str = "";
		//1.加载驱动
		try{
		Class.forName("com.mysql.jdbc.Driver");
		//2.获取连接
	 connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/liuxudb2?useUnicode=true&characterEncoding=UTF-8", "root", "123456");
		//3.获取预解析对象
	 ps=	connection.prepareStatement("select * from student where id =4");
		//4.执行操作
		 rs = ps.executeQuery();
		//遍历
		while(rs.next()){
			//取值
			str = rs.getString("name");
		}
		
		}catch(Exception e){
			e.getStackTrace();
		}finally{
			if(connection!=null){
					try{
						connection.close();
					}catch(SQLException e){
						e.getStackTrace();
					}
			}
			if(rs!=null){
				try{
					rs.close();
				}catch(SQLException e){
					e.getStackTrace();
				}
		}
			if(ps!=null){
				try{
					ps.close();
				}catch(SQLException e){
					e.getStackTrace();
				}
		}
		}

			return str;
		
	}%>
