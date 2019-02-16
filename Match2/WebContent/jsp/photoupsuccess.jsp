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
<meta charset="utf-8" />
<title></title>
<link rel="stylesheet" type="text/css" href="<%=basePath %>css/Photo.css" />
</head>
<body>
	<!--头顶层-->
	<div class="top1">
		<div class="top00">
			<div class="top1-1"></div>
			<div class="top1-2">每个渴望爱的人 都值得被真爱</div>
		</div>
	</div>

	<!--底部层-->
	<div class="wrap">
		<div class="top2">
			<span style="margin-left: 120px;">照片上传成功喽</span>
		</div>


		<img src="<%=basePath %>${paddress}" class="image">




		<div>
			<span class="up" id="photoup"></span>
		</div>
		<div class="mid">
			<!--底部图片-->
			<div class="photo">
				<span style="font-size: 28px; font-style: normal; color: black;">有缘网!你唯一的选择</span>
			</div>
		</div>
	</div>

</body>
<script type="text/javascript" src="<%=basePath %>js/jquery-2.2.4.min.js"></script>
<script src="<%=basePath %>js/bootstrap.min.js" type="text/javascript" charset="utf-8"></script>
<script type="text/javascript">
	/* var body = document.getElementsByTagName("body")[0];
	var usenaem = document.getElementById("usename");
	var usepswsave = document.getElementById("usepswsave");
	var present = document.getElementById("present"); */
	//总方法向servlet发送数据
	/* var href = location.href;
	var paddress = href.split("=")[1];

	/* 	var paddress = decodeURI(address);
	 console.log(paddress); */
// 	var tu = document.querySelector("img");
// 	tu.setAttribute("src", paddress); */

	var t = 5; //设定跳转的时间
	setInterval("refer()", 1000); //启动1秒定时 
	function refer() {
		if (t == 0) {
			location = "<%=basePath %>jsp/login.jsp"; //#设定跳转的链接地址 
		}
		document.getElementById('photoup').innerHTML = "" + t + "秒后跳转到登录页面"; // 显示倒计时 
		t--; // 计数器递减
	}
</script>
</html>