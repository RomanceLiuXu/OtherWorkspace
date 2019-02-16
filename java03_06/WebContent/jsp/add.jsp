<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset=UTF-8>
<title>标题</title>
</head>
<body>
<form action="http://localhost:8080/java03_06/add" method="post">
姓名:
<input type="text" name="user.name"/>
<br>
密码:
<input type="text" name="user.psw">
<br>
<input type="radio" name="user.sex" value="男">男
<input type="radio" name="user.sex" value="女">女
<input type="submit">
</form>
</body>
</html>