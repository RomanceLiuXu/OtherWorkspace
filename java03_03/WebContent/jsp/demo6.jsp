<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html>
<html>
<head>
<meta charset=UTF-8>
<title>通用标签</title>
</head>
<body>
	<%
		request.setAttribute("num", 4);
		List<String> strs = new ArrayList<String>();
		strs.add("aa");
		strs.add("bb");
		strs.add("cc");
		request.setAttribute("lists", strs);
	%>
	<s:if test="#request.num>10"> 成功 </s:if>
	<s:elseif test="#request.num>5">大于5</s:elseif>
	<s:else>小于等于5</s:else>

	<s:iterator value="#request.lists" var="item" begin="1" end="" step="2">

		<div>${item }</div>

	</s:iterator>

	<s:iterator>
		<s:property />
	</s:iterator>

	<s:iterator value="#request.lists" var="user">
		<s:property value="name" />
	</s:iterator>
	
</body>
</html>