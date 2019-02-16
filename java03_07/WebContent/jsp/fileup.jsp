<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>上传文件</title>
</head>
<body>
<form action="http://localhost:8080/java03_07/two" method="post" enctype="multipart/form-data">
<input type="file" name="file">
<input type="file" name="file">
<input type="file" name="file">
<input type="file" name="file">
<input type="submit" value="提交">
</form>
</body>
</html>