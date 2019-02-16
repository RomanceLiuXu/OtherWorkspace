<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset=UTF-8>
<title>标题</title>
</head>
<body>
${user.name },欢迎你!
<form action="http://localhost:8080/java03_05w/user_destroy" method="post">
<input type="submit" value="注销">
</form>
</body>
</html>