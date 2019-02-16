<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@  taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
<style type="text/css">
.class1 {
	width: 900px;
	height: 900px;
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
</head>
<body>
	<div class="class1">
		<div class="class2">
			<table border="1px" cellpadding="20px"
				style="border-collapse: collapse;">
				<thead>
					<tr>
						<td>id</td>
						<td>姓名</td>
						<td>密码</td>
						<td>性别</td>
						<td style="color: red;">是否删除</td>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${users }" var="user">
						<tr>
							<td>${user.uid}</td>
							<td>${user.name }</td>
							<td>${user.psw }</td>
							<td>${user.sex }</td>
							<td><a
								href="http://localhost:8080/java03_06/delete?uid=${user.uid }">删除</a></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
			<c:forEach begin="1" end="${pageNum }" var="page">
				<a href="http://localhost:8080/java03_06/page?page=${page }">${page }</a>
			</c:forEach>
			<div>
			<a href="http://localhost:8080/java03_06/jsp/add.jsp">添加用户</a>
			<a href="http://localhost:8080/java03_06/jsp/update.jsp">修改用户</a>
		</div>
		</div>
		
		<!-- 		<div style="margin-top:600px "> -->
		<!-- 		<input type="button" id="select" value="添加用户"/> -->
		<!-- 		<br> -->
		<!-- 		<iframe height="300px" width="800px" src="" id="ifr" ></iframe> -->
		<!-- 		</div> -->
	</div>
	<!-- <script type="text/javascript"> -->
	<!--  var but1 = document.getElementById("select"); -->
	<!--  var ifa = document.getElementById("ifr"); -->
	<!--  but1.onclick = function(){ -->
	<!-- 	 ifa.src="http://localhost:8080/java03_06/jsp/add.jsp" -->
	<!--  } -->
	<!-- </script> -->

</body>
</html>
