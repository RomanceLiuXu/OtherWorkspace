<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib uri="/struts-tags" prefix="s" %>  
<!DOCTYPE html>
<html>
<head>
<meta charset=UTF-8>
<title>值栈</title>
</head>
<body>
<s:debug></s:debug>
${requestScope.cc }
name:<s:property value="name"/>
user:<s:property value="user.name"/>
list:<s:property value="lists[0]"/>


<div>---------------------------------------------------------</div>


<!-- map区的值 -->
session-name:<s:property value="#session.uname"/>
session-list:<s:property value="#session.ulist[0]"/>



</body>
</html>