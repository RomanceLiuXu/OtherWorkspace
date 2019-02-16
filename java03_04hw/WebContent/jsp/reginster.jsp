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
<s:form action="http://localhost:8080/java03_04hw/reginster" method="post">
<s:textfield name="student.code" placeholder="输入账号" label="用户名"></s:textfield>
<s:password name="student.psw" placeholder="输入密码" label="密码"></s:password>
<s:password name="student.age" placeholder="输入年龄" label="年龄"></s:password>
<s:radio list="#{1:'男',2:'女' }" name="student.sex"></s:radio>
<s:reset value="重置"></s:reset>
<s:submit value="登录"></s:submit>
</s:form>
</body>
</html>