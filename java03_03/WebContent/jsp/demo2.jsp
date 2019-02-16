<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset=UTF-8>
<title>标题</title>
</head>
<body>
<div>request:${requestScope.username }</div>
<div>session:${sessionScope.username }</div>
<div>application:${applicationScope.password }</div>
<div>${requestScope.list[0].name }</div>
</body>
</html>