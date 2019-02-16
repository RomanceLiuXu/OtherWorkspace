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
		<link rel="stylesheet" type="text/css" href="<%=basePath%>css/updatepsw.css" />
	</head>

	<body>
		<!--头顶层-->
		<div class="top1">
			<div class="top00">
				<div class="top1-1">
				</div>
				<div class="top1-2">
					每个渴望爱的人 都值得被真爱
				</div>
			</div>
		</div>
		<div id="div">
		</div>
		<div class="out">
			<!--底部层-->
			<div class="wrap">
				<div class="top2">
					<span style="margin-left: 120px;">修改密码</span>
				</div>
				<div class="mid">

					<div class="mid1_1">
						<span style="font-size: 18px;margin-right: 18px; ">
					<span style="color: red;" >*</span> 账号 :</span>
						<input type="text" id="usename" disabled="disabled" style="font-size: 15px; font-weight: bold; height: 28px;width:200px;   border: 1px solid black;" />
					</div>
					<div class="mid1_2">
						<span style="font-size: 	18px;margin-right: 18px;">
					<span style="color: red;">*</span> 确认新密码 :</span>
						<input type="password" id="oldpsw" placeholder="请填写旧密码" style="color:red; font-size: 12px; height: 28px;width:200px;  	border: 1px solid black;" />
					</div>
					<div class="mid1_2">
						<span style="font-size: 	18px;margin-right: 18px;">
					<span style="color: red;">*</span> 确认新密码 :</span>
						<input type="password" id="newpsw" placeholder="请输入新的密码" style="color:red; font-size: 12px; height: 28px;width:200px;  	border: 1px solid black;" />
					</div>
					<div class="mid1_2">
						<span style="font-size: 	18px;margin-right: 18px;">
					<span style="color: red;">*</span> 确认新密码 :</span>
						<input type="password" id="snewpsw" placeholder="请再次输入新的密码" style="color:red; font-size: 12px; height: 28px;width:200px;  	border: 1px solid black;" />
					</div>
					<div class="down" id="present">
						完成
					</div>
					<!--底部图片-->
					<div class="photo">
						<span style="font-size: 28px;font-style: normal;color: black;">有缘网!你唯一的选择</span>
					</div>
				</div>
			</div>

	</body>
	<script src="<%=basePath%>js/jquery-2.2.4.min.js" type="text/javascript" charset="utf-8"></script>
	<script src="<%=basePath%>js/bootstrap.min.js"></script>
	<script type="text/javascript">
		// 查找usename标签
		var usenaem = document.getElementById("usename");
		// 查找新密码的标签
		var newpsw = document.getElementById("newpsw");
		// 查找确认密码的标签
		var snewpsw = document.getElementById("snewpsw");
		//获取用户的id
		uid = location.href.split("?")[1].split("=")[1];
		// 请求查找每个人的接口查找每个人的信息
		$.ajax({
			type: "get",
			url: "<%=basePath%>per",
			async: true,
			data: {
				uid: uid
			},
			success: function(res) {
				//解析json串
				var result = eval("(" + res + ")");
				console.log(result);
				//获取数据库中用户的信息
				var name = result.user.name;
				//将信息赋值给前端不可改变
				usename.value = name;
				// 获取用户在数据库中的密码
				var psw = result.user.psw;
				console.log(psw);
				// 获取用户输入的密码
				var oldpsw = document.getElementById("oldpsw");
				// 设置点击完成的点击事件
				var present = document.getElementById("present");
				present.onclick = function() {
					// 如果输入密码为空，则弹出
					if(oldpsw.value == "" || newpsw.value == "" || snewpsw.value == "") {
						alert("密码不能为空");
					} else {
						// 判断旧密码是否正确
						if(oldpsw.value == psw) {
							// 判断新密码前后是否输入一致
							if(newpsw.value == snewpsw.value) {
								// 判断新旧密码是否一致
								if(oldpsw.value == newpsw.value) {
									alert("新旧密码不能一致")
								} else {
									//获取div的标签
									var div = document.getElementById('div');
									//让它浮动起来
									div.style.zIndex = 10;
									$.ajax({
										type: "get",
										url: "<%=basePath%>newpsw",
										async: true,
										data: {
											name: name,
											newpsw: newpsw.value
										},
										success: function(res) {
											//解析json串
											var result = eval("(" + res + ")");
											var flag = result.flag;
											if(flag == 0) {
												div.innerText = "恭喜修改密码失败"
												var t = 10; //设定跳转的时间 
												setInterval(function() {
													if(t == 0) {
														location = "<%=basePath%>jsp/login.jsp"; //#设定跳转的链接地址 
													}
													div.innerHTML = "" + t + "秒后跳转到登录页面"; // 显示倒计时 
													t--; // 计数器递减
												}, 1000); //启动1秒定时
											} else {
												div.innerText = "恭喜修改密码成功"
												var t = 10; //设定跳转的时间 
												setInterval(function() {
													if(t == 0) {
														location = "<%=basePath%>jsp/login.jsp"; //#设定跳转的链接地址 
													}
													div.innerHTML = "" + t + "秒后跳转到登录页面"; // 显示倒计时 
													t--; // 计数器递减
												}, 1000); //启动1秒定时
											}
										}
									});

								}

							} else {
								alert("前后密码输入不一致");
							}
						} else {
							// 旧密码输入不正确则弹出
							alert("密码输入错误");
						}
					}

				}

			}

		});
	</script>

</html>