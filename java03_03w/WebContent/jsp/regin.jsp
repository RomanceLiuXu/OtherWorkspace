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
<s:form action="reginster" method="post">
<s:textfield name="username" label="用户名"></s:textfield>
<s:password name="psw" label="密码"></s:password>
<s:password name="cpsw" label="确认密码"></s:password>
<s:textfield name="name" label="姓名"></s:textfield>
<s:textfield name="age" label="年龄"></s:textfield>
<s:textfield name="birth" label="出生日期"></s:textfield>
<s:textfield name="email" label="邮箱地址"></s:textfield>
<s:reset name="reset" value="重置"></s:reset>
<s:submit name="sub" value="提交"></s:submit>
</s:form>
</body>
</html>