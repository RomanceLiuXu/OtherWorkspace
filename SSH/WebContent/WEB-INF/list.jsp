<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   <%@taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
   <%@taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt"%>
<!DOCTYPE html >
<html>
<head>
<meta  charset=UTF-8>
<title>标题</title>
<style type="text/css">
	.row0{
		background-color: red;
	}
	.row1{
		background-color: green;
	}
</style>
</head>
<body>
	<table align="center" border="1" width="500px">
		<tr>
			<td width="100px">编号</td>
			<td width="100px">姓名</td>
			<td width="100px">职位</td>
			<td width="100px">薪水</td>
			<td width="100px">入职日期</td>
		</tr>
		<c:forEach items="${emps }" var="emp" varStatus="s">
			<tr align="center" class="row${s.index%2==0?1:0 }">
				<td>${emp.id }-${s.index }</td>
				<td>${emp.name }</td>
				<td>${emp.job }</td>
				<td>${emp.salary }</td>
				<td>
					<fmt:formatDate value="${emp.hiredate }" pattern="yyyy-MM-dd"/>
				</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>