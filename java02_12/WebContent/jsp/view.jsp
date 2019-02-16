<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <!-- uri:路径  prefix:指的是标签头-->
<%@  taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
	String path = request.getContextPath();
	//协议://+IP:+端口号+/+工程名+/
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<base href="<%=basePath%>">
		<title></title>
		<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css"/>
	</head>
	<body>
		<a href="jsp/add.jsp">添加</a>
		<a href="jsp/update.jsp">修改</a>
		<a href="jsp/delete.jsp">删除</a>
		<a href="select">查找</a>
		<table class="table">
			<caption>用户信息表</caption>
			<thead style="background-color: #419641;">
				<tr>
					<th>uid</th>
					<th>name</th>
					<th>sex</th>
					<th>psw</th>
				</tr>
			</thead>
			<tbody>
			<tr>
			<td>${user.uid }</td>
			<td>${user.name }</td>
			<td>${user.sex }</td>
			<td>${user.psw }</td>
			</tr>
			</tbody>
		</table>
		<c:if test="">
		
		</c:if>
		<div>操作结果为:${isAdd }</div>
	</body>
</html>