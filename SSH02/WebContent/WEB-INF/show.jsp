<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset=UTF-8>
<title>标题</title>
<style type="text/css">
* {
	font-size: 30px;
}

body {
	background-image: url("../image/background.jpg");
	background-size: cover;
}

table tr td {
	text-align: center;
}

.row0 {
	background-color: red;
}

.row1 {
	background-color: green;
}
a{
float: right;
font-size: 30px;
text-decoration: none;
color: black;
}
a:hover{
color: yellow;
text-decoration: underline;
}
</style>
</head>
<body>
<a href="toAddEmp.do">添加</a>
	<table border="2px" cellpadding="10px" align="center"
		style="border-collapse: collapse">
		<caption>员工列表</caption>
		<thead>
			<tr>
				<td>id</td>
				<td>uname</td>
				<td>gender</td>
				<td>age</td>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${emps }" var="emp" varStatus="s">
				<tr class="row${s.index%2 }">
					<td>${emp.id }</td>
					<td>${emp.uname }</td>
					<td>${emp.gender }</td>
					<td>${emp.age }</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>

</body>
</html>