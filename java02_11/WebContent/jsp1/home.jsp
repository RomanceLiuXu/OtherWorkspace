<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset=UTF-8>
<title>home</title>
</head>
<body>
<%
//获取session值
// String code= (String)session.getAttribute("code");
//获取cookie值 
Cookie[] cookies = request.getCookies();
String code ="";
//遍历
for(Cookie cookie : cookies){
	String name = cookie.getName();
	if(name.equals("code")){
		code = cookie.getValue();
	}
}

%>

<div><%=code %>,欢迎你</div>

</body>
</html>