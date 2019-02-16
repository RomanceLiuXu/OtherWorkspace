<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset=UTF-8>
<title>异常处理页面</title>
</head>
<body>
    <h1>系统发生了故障，请稍后<a href="toAddEmp.do">重试!</a></h1>
    ${ex.message }
</body>
</html>