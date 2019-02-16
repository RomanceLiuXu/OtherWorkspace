<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset=UTF-8>
<title>标题</title>
</head>
<body>
 ${requestScope.name }这是一个jsp页面
 <br>
 <div>接收对象:${car.name }</div>
 接收list集合:${cars[0]['name'] }
 <br>
 <div>接收map集合:${maps.one.price }</div>
</body>
</html>