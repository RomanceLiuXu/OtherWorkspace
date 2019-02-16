<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset=UTF-8>
<title>利用cookie保存登录状态</title>
</head>
<body>
	<%
		//获取demo4传过来的值
		String code = request.getParameter("code");
		String psw = request.getParameter("psw");
		String enter = request.getParameter("enter");
		if (code != null && psw != null && !code.equals("") && !psw.equals("")) {
			if (enter.equals("保存登录")) {
				//设置cookie值
				Cookie cookie1 = new Cookie("code", code);
				Cookie cookie2 = new Cookie("psw", psw);
				//添加
				response.addCookie(cookie1);
				response.addCookie(cookie2);
			} else {
				//清空存在的cookie
				if (request.getCookies() != null) {
					for (Cookie cookie : request.getCookies()) {
						//遍历清空
						cookie.setMaxAge(0);
					}
				}
			}
			//调到主页面
			response.sendRedirect("home.jsp?code=" + code);
		} else {
			//返回登录页面
			response.sendRedirect("demo4.jsp");
		}
	%>


</body>
</html>