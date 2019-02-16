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
<meta charset="UTF-8">
<title></title>
<style type="text/css">
.class1 {
	width: 800px;
	height: 800px;
	background-color: burlywood;
	position: absolute;
	left: 0;
	right: 0;
	top: 0;
	bottom: 0;
	margin: auto;
}

.class2 {
	width: 600px;
	height: 600px;
	position: absolute;
	left: 0;
	right: 0;
	top: 0;
	bottom: 0;
	margin: auto;
}
</style>
<!-- <link rel="stylesheet" type="text/css" -->
<%-- 	href="<%=basePath%>css/bootstrap.min.css" /> --%>
</head>
<body>
	<div class="class1">
		<div class="class2">
			<table border="1px" cellpadding="20px" style="border-collapse: collapse;"> 
				<thead>
					<tr>
						<td>编号</td>
						<td>账号</td>
						<td>密码</td>
						<td>性别</td>
						<td style="color: red;">是否删除</td>
					</tr>

				</thead>
				<tbody>
					<c:forEach items="${pagefind }" var="p">
						<tr>
							<td>${p.uid }</td>
							<td>${p.name }</td>
							<td>${p.psw }</td>
							<td>${p.sex }</td>
							<td><a href="<%=basePath %>delete?uid=${p.uid }">删除</a></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
			<c:forEach var="pagenum" begin="1" end="${sessionScope.allpage }">
					<a style="margin:0 5px" href="<%=basePath %>pagew?page=${pagenum }">${pagenum }</a>
				</c:forEach>
		</div>

<!-- 		<nav aria-label="Page navigation" style="text-align: center;"> -->
<!-- 			<ul class="pagination"> -->
<%-- 				<c:forEach var="pagenum" begin="1" end="${sessionScope.allpage }"> --%>
<%-- 					<li><a href="<%=basePath %>pagew?page=${pagenum }">${pagenum }</a></li> --%>
<%-- 				</c:forEach> --%>
<!-- 			</ul> -->
<!-- 		</nav> -->
	</div>
</body>
<script src="<%=basePath%>js/jquery-2.2.4.min.js"
	type="text/javascript" charset="utf-8"></script>
<script src="<%=basePath%>js/bootstrap.min.js" type="text/javascript"
	charset="utf-8"></script>

</html>
