<%@page import="java.sql.SQLException"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="com.lanou.SQLUtil2"%>
<%@page import="com.lanou.SQLOP"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset=UTF-8>
<title>登录验证</title>
</head>
<body>
<%! SQLUtil2 util = new SQLUtil2(); %>

<% 
ResultSet rs = null;
//获取用户输入的内容
String code = request.getParameter("code");
String psw = request.getParameter("psw");
session.setAttribute("code", code);
//application.setAttribute("code", code);
//request.setAttribute("code", code);
//pageContext.setAttribute("code", code);
//判断
if(code!=null&&!code.equals("")&&psw!=null&&!psw.equals("")){
	//使用工具类访问数据库
	//sal语句
	String sql = "select * from user";
	boolean flag = false;
	try{
	 rs = SQLUtil2.queryMethod(sql, null);
	//遍历结果集
	while(rs.next()){
		String name = rs.getString("name");
		String mpsw = rs.getString("psw");
		if(code.equals(name)&&psw.equals(mpsw)){
			//成功
			flag = true;
			
			//request.getRequestDispatcher("home.jsp").forward(request, response);
			break;
		}
	}
	
	}catch(Exception e){
		
	}finally{
		SQLUtil2.myClose(rs);
	}
	if(flag){
		
		response.sendRedirect("home.jsp");
	}else{
		response.sendRedirect("login.jsp");
	}
	
}

%>
</body>
</html>