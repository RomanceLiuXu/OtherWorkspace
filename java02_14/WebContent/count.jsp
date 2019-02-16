<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset=UTF-8>
<title>标题</title>
</head>
<body>
当前访问次数：${applicationScope.countRequest }
当前在线人数：${applicationScope.countSession }
<!-- 退出时访问Logout.do的Servlet将session删除 -->
<a href="Logout.do">退出</a>
</body>
</html>