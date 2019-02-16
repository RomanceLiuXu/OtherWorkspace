<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html>
<html>
<head>
<meta charset=UTF-8>
<title>文件下载</title>
</head>
<body>
<!-- <a href="/http://localhost:8080/java03_07/myimg/daidu.jpg" download="baidu.jpg">下载</a> -->

<s:a href="http://localhost:8080/java03_07/three?filename=baidu.jpg">下载</s:a>
</body>
</html>