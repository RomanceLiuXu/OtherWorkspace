<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset=UTF-8>
<title>利用session保存登录状态</title>
</head>
<body>
<%
//获取demo4传过来的值
String code = request.getParameter("code");
String psw = request.getParameter("psw");
String enter = request.getParameter("enter");
if(code!=null&&psw!=null&&!code.equals("")&&!psw.equals("")){
	if(enter.equals("登录")){
		//设置sessio值
		session.setAttribute("code", code);
		session.setAttribute("psw", psw);
	}else{
		//清空session
		session.removeAttribute("code");
		session.removeAttribute("psw");
	}
	response.sendRedirect("home.jsp");
}else{
	//返回登录页面
	response.sendRedirect("demo4.jsp");
}

%>

</body>
</html>