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
		<title>登录</title>
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
				background-color: rosybrown;
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
			.class2 a{
				margin-top: 20px;
				float: right;
				font-size: 10px;
			}
		</style>
	</head>

	<body>
		<form action="http://localhost:8080/java03_06/login" method="post">
			<div class="class1">
				<span>QQ登录</span>
				<div class="class2">
					账号:
					<input type="text" name="name" placeholder="输入账号" style="width: 140px; height: 20px;" />
					<br />
					<br /> 密码:
					<input type="password" name="psw" placeholder="输入密码" style="width: 140px; height: 20px;" />
					<br />
					<br/>
					<input type="text" hidden  name="flag"/>
					<input type="submit" value="登录" />
					<input type="submit" value="保存登录" />
				</div>
			</div>
		</form>
	</body>
	<script type="text/javascript">
		var inputs = document.querySelectorAll("input");
		//点击的是登录
		inputs[3].onclick = function(){
			//设置标示的value值
 	    inputs[2].value="1";
			return check();
		} 
		//点击的是保存登录
		inputs[4].onclick = function(){
			//设置标示的value值
 	    inputs[2].value="2";
			return check();
		} 
		
		
		//非空判断
		function check() {
			if (inputs[0].value==null||inputs[0].value==""||inputs[1].value==null||inputs[1].value=="") {
				alert("输入不能为空");
				return false;
			} 
			return true;
		}
	</script>

</html>