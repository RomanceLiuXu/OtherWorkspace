<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset=UTF-8>
<title>标题</title>
</head>
<body>
<div>request:${requestScope.user }</div>
<div>request:${requestScope.person[0].name }</div>
<div>session:${sessionScope.age }</div>
<div>session:${sessionScope.usercode }</div>
<div>session:${sessionScope.usercode1 }</div>
<div>application:${applicationScope.age }</div>
</body>
</html>