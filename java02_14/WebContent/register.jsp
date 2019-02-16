<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
	<form action="<%=basePath %>login.do" method="post">
		账  号:<input type="text" name="code"><br/>
		密  码:<input type="text" name="password"><br/>
		邮  箱:<input type="text" name="password"><input type="button" value="获取验证码"><br/>
		验证码:<input type="text" name="vcode"><br>
		<img id="checkImage" alt="验证码" src="<%=basePath %>validateCode.do"><a href="javascript:void(0);" onclick="myImg();">换一张</a> 
		<input type="submit" value="提交">
	</form>
</body>
<script src="js/jquery-2.2.4.min.js" type="text/javascript"
	charset="utf-8"></script>
<script type="text/javascript">
	function myImg(){
		var t = new Date().getTime();
		document.getElementById("checkImage").src="http://localhost:8080/java02_14/validateCode.do?t="+t;
	}	
</script>
</html>