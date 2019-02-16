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
		<title>注册</title>
		<style type="text/css">
			.class1 {
				width: 500px;
				height: 500px;
				position: absolute;
				left: 0;
				right: 0;
				top: 0;
				bottom: 0;
				margin: auto;
				background-color: burlywood;
			}
			
			.class2 {
				width: 200px;
				height: 200px;
				position: absolute;
				left: 0;
				right: 0;
				top: 0;
				bottom: 0;
				margin: auto;
			}
			
			.class2 a {
				margin-top: 20px;
				float: right;
				font-size: 10px;
			}
		</style>
	</head>

	<body>
		<form action="http://localhost:8080/java03_04hw/addemployee" method="post">
			<div class="class1">
				<span>QQ注册</span>
				<div class="class2">
					姓名:
					<input type="text" name="employee.name" placeholder="输入姓名" style="width: 140px; height: 20px;" />
					<br />
					<br /> 年龄:
					<input type="password" name="employee.age" placeholder="输入年龄" style="width: 140px; height: 20px;" />
					<br />
					<input type="radio" name="employee.sex" value="男" />男
					<input type="radio" name="employee.sex" value="女" />女
					<br /> 
					<input type="submit" value="注册" />
					<a href="login.jsp">已有账号，去登录..</a>
				</div>
			</div>
		</form>
	</body>
	
	<script type="text/javascript">
		var inputs = document.querySelectorAll("input");
		inputs[4].onclick = function() {
        
			return check();
		}
		//非空判断
		function check() {
			if(inputs[0].value == null || inputs[0].value == "" || inputs[1].value == null || inputs[1].value == "") {
				alert("输入不能为空");
				return false;
			}else if(!(inputs[2].checked||inputs[3].checked)){
				alert("请选择性别");
				return false;
			}
			return true;
		}
	</script>

</html>