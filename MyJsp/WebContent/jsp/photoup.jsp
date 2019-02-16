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
<meta charset="utf-8" />
<title></title>
<link rel="stylesheet" type="text/css" href="<%=basePath %>css/Photo.css" />
</head>
<body>
	<div id="one">
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
				<span style="margin-left: 120px;">离注册成功就差一小步了,快点上传照片吧!</span>
			</div>


			<img src="<%=basePath %>img/head.jpeg" class="image">




			<div id="photoup">
				<form action="fileup" class="up" enctype="multipart/form-data"
					method="post">
					<input type="file" name="file" id="file1" /> <input type="text"
						name="uuid" hidden id="uiddd" /> <input type="submit" id="ok"
						value="上传" />
				</form>
			</div>
			<div class="mid">
				<!--底部图片-->
				<div class="photo">
					<span style="font-size: 28px; font-style: normal; color: black;">有缘网!你唯一的选择</span>
				</div>
			</div>
		</div>
	</div>




</body>
<script type="text/javascript" src="<%=basePath %>js/jquery-2.2.4.min.js"></script>
<script type="text/javascript">
	window.onload = function() {
		var id = location.href;
		var uid = id.split("=")[1];
		var uidname = document.getElementById("uiddd");
		uidname.value = uid;
	}
</script>
</html>