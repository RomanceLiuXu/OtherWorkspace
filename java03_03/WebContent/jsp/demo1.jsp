<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset=UTF-8>
<title>取值</title>
</head>
<body>
<div>request中的值:${requestScope.code }</div>
<div>request中的集合:${requestScope.per[0].name }</div>
<div>session中的值:${sessionScope.code }</div>
<div>application中的值:${applicationScope.code }</div>



</body>
</html>