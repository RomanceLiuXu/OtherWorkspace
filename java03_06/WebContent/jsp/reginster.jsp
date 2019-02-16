<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html>
<html>
<head>
<meta charset=UTF-8>
<title>注册</title>
</head>
<body>
<s:form action="http://localhost:8080/java03_06/reginster" method="post">
<s:textfield key="global.name" name="user.name"></s:textfield>
<br>
<s:textfield key="global.psw" name="user.psw"></s:textfield>
<br>
<s:textfield key="global.sex" name="user.sex"></s:textfield>
<br>
<s:submit key="global.reginster"></s:submit>
</s:form>


</body>
</html>