<%@page import="java.util.ArrayList"%>
<%@page import="com.lanou.bean.Car"%>
<%@page import="java.util.List"%>
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
<base href="<%=basePath%>">
<meta charset=UTF-8>
<title>JSTL</title>
</head>
<body>
	<%=basePath%>
	<%
		List<Car> cars = new ArrayList<Car>();
		Car car1 = new Car(1, "aa");
		Car car2 = new Car(2, "bb");
		Car car3 = new Car(3, "cc");
		Car car4 = new Car(4, "ee");
		Car car5 = new Car(5, "ff");
		cars.add(car1);
		cars.add(car2);
		cars.add(car3);
		cars.add(car4);
		cars.add(car5);
		request.setAttribute("cars", cars);
		int n = -1;
		request.setAttribute("n", n);
	%>
	<%
		List<Car> lists = (List<Car>) request.getAttribute("cars");
	%>
	<%
		for (int i = 0; i < lists.size(); i++) {
			Car car = lists.get(i);
			request.setAttribute("car", car);
	%>
	<div>${car.type }</div>
	<%
		}
	%>

	<!-- 迭代标签 forEach-->

	<table>
		<thead>
			<tr>
				<th>id</th>
				<th>type</th>
			</tr>
		</thead>
		<tbody>
			<!-- 
		items：集合对象
		var:集合在的单个对象(自己取名)
		begin:循环开始的位置 (包含)
		end:循环结束的位置（包含）
		varStatus:存放循环相关的信息（名字自己取）
		eg:size---count
		   下标---index
		 -->
			<c:forEach items="${cars }" var="car">
				<tr>
					<td>${car.id }</td>
					<td>${car.type }</td>
				</tr>
			</c:forEach>
			<c:forEach items="${cars }" var="car" begin="0" end="4" step="1"
				varStatus="lhl">
				<tr>
					<td>${car.id }</td>
					<td>${car.type }</td>
					<td>${lhl.count }</td>
					<td>${lhl.index }</td>
				</tr>
			</c:forEach>
<%-- 			<c:if test="${5<6} "> --%>
<!-- 				<tr> -->
<!-- 					<td>c_if</td> -->
<!-- 					<td>返回true</td> -->
<!-- 				</tr> -->
<%-- 			</c:if> --%>
			<c:choose>
				<c:when test="${n>5 }">
					<tr>
						<td>c_when1</td>
						<td>${n }>5</td>
					</tr>
				</c:when>
				<c:when test="${n>3 }">
					<tr>
						<td>c_when2</td>
						<td>${n }>3</td>
					</tr>
				</c:when>
				<c:when test="${n>1 }">
					<tr>
						<td>c_when3</td>
						<td>${n }>1</td>
					</tr>
				</c:when>

				<c:otherwise>
					<tr>
						<td>otherwise</td>
						<td>其他结果</td>
					</tr>


				</c:otherwise>

			</c:choose>

			<tr>
				<td>c_out</td>
				<td><c:out value="aaaa">
					</c:out></td>
			</tr>

			<tr>
				<td>c_set</td>
				<td>
					<!--向某个容器中设置值  --> <c:set var="name" value="lhl" scope="request"></c:set>
					${requestScope.name }
				</td>
			</tr>

			<!-- 修改某个属性值 -->
			<tr>
				<td>c_set</td>
				<td>${car.type }</td>
				<c:set target="${car }" property="type" value="大众"></c:set>
				<td>${car.type }</td>
			</tr>


			<tr>
				<td>c_remove</td>
				<td><c:remove var="name" scope="request" />${requestScope.name }结束</td>
				<td></td>
			</tr>



		</tbody>
	</table>

</body>
</html>