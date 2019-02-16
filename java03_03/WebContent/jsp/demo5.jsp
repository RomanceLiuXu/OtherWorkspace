<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html>
<html>
<head>
<meta charset=UTF-8>
<title>ui标签</title>
</head>
<body>
	<!-- form表单  -->
	<s:form action="" method="post">
		<s:textfield name="code"></s:textfield>
		<s:password name="psw"></s:password>
		<s:reset value="重置"></s:reset>
		<s:submit value="登录"></s:submit>
	</s:form>
	<!-- 文本输入框 -->
	<s:textarea></s:textarea>
	<!-- 单选框 -->
	<s:radio list="#{1:'aa',2:'bb' }" name="sex"></s:radio>
	<!-- 复选框 -->
	<s:checkbox name="age" label="bb" value="true"></s:checkbox>
	<s:checkbox name="age" label="cc"></s:checkbox>
	<!-- 隐藏的input -->
	<s:hidden name="flag" value="lhl"></s:hidden>
</body>
</html>