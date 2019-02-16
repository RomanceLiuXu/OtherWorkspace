<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

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
<meta charset=UTF-8>
<title>标题</title>
</head>
<body>

	<table>
		<thead>
			<tr>
				<td>name</td>
				<td>age</td>
				<td>sex</td>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${pageFind }" var="user">
			<tr>
				<td>${user.name }</td>
				<td>${user.age }</td>
				<td>${user.sex }</td>
			</tr>
			</c:forEach>
		</tbody>
	</table>
	<c:forEach  var="pagenum" begin="1" end="${sessionScope.allPage }">
	    <a href="<%=basePath %>page?page=${pagenum }">${pagenum }</a>
	</c:forEach>
	
	
<%-- <a href="<%=basePath %>page?page=1">1</a>
<a href="<%=basePath %>page?page=2">2</a>
<a href="<%=basePath %>page?page=3">3</a> --%>
</body>
</html>