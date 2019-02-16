<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <!-- uri:路径  prefix:指的是标签头-->
<%@  taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title></title>
		<link rel="stylesheet" type="text/css" href="../css/bootstrap.min.css"/>
	</head>
	<body>
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

			<c:forEach items="${users }" var="user">
			<tr>
			<td>${user.uid }</td>
			<td>${user.name }</td>
			<td>${user.sex }</td>
			<td>${user.psw }</td>
			</tr>
			</c:forEach>
			</tbody>
		</table>
	</body>
</html>