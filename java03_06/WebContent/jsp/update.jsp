<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset=UTF-8>
<title>修改用户</title>
</head>
<body>
<form action="http://localhost:8080/java03_06/update" method="post">
id:
<input type="text" name="user.uid"/>
<br>
姓名:
<input type="text" name="user.name">
<br>
<input type="submit">
</form>
</body>
</html>