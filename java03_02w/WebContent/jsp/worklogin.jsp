<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@  taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
	String path = request.getContextPath();
	//协议://+IP:+端口号+/+工程名+/
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
    System.out.print(path);
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
		<form action="login" method="post">
			<div class="class1">
				<span>QQ登录</span>
				<div class="class2">
					账号:
					<input type="text" name="code" placeholder="输入账号" style="width: 140px; height: 20px;" />
					<br />
					<br /> 密码:
					<input type="password" name="psw" placeholder="输入密码" style="width: 140px; height: 20px;" />
					<br />
					<input type="checkbox" name="remeber" />记住密码
					<br />
					<input type="submit" value="登录" />
					<a href="workreginster.jsp">还没账号?去注册..</a>
				</div>
			</div>
		</form>
	</body>
	<script src="<%=basePath %>js/jquery-2.2.4.min.js" type="text/javascript" charset="utf-8"></script>
	<script type="text/javascript">
		var inputs = document.querySelectorAll("input");
		var rem = inputs[2].value;
		inputs[3].onclick = function(){
	    if (inputs[2].checked) {
	    	    rem = "on";
	    }
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