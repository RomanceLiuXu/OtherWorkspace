<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset=UTF-8>
<title>标题</title>
</head>
<body>
model传值：
${requestScope.user }<br/>
${requestScope.psw }<br/>
<hr/>
对象传值:
${user.username }
${user.password }
</body>
</html>