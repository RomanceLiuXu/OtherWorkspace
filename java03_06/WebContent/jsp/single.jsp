<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset=UTF-8>
<title>个人中心</title>
</head>
<body>
个人信息:
<div style="width: auto;height: 300px;">
<div>姓名:${user.name }</div>
<div>性别:${user.sex }</div>
<div style="width: 100px ;height: 100px;border: 1px solid;"><img style="height: 100px;" src="${basePath}" class="image"></div>
</div>
</body>
</html>