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
		<link rel="stylesheet" type="text/css" href="<%=basePath%>css/checkpsw.css" />
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
		
		
			<!--底部层-->
			<div class="wrap">
				<div class="top2">
					<span style="margin-left: 120px;">找回密码</span>
				</div>
				<div class="mid">

					<div class="mid1_1">
						<span style="font-size: 18px;margin-right: 18px; ">
					<span style="color: red;" >*</span> 账号 :</span>
						<input type="text" id="usename" placeholder="请您输入账号名" style="color:red; font-size: 12px;height: 28px;width:200px;   border: 1px solid black;" />
					</div>
					<div class="mid1_2">
						<span style="font-size: 	18px;margin-right: 18px;">
					<span style="color: red;">*</span> 密保数字 :</span>
						<input type="password" id="usepswsave" placeholder="请您输入密保数字" style="color:red; font-size: 12px; height: 28px;width:200px;  	border: 1px solid black;" />
					</div>
					<div class="down" id="present">
						确认
					</div>
					<!--底部图片-->
					<div class="photo">
						<span style="font-size: 28px;font-style: normal;color: black;">有缘网!你唯一的选择</span>
					</div>
				</div>
			</div>

	</body>
	<script type="text/javascript" src="<%=basePath%>js/jquery-2.2.4.min.js"></script>
	<script type="text/javascript">
		var body = document.getElementsByTagName("body")[0];
		var usenaem = document.getElementById("usename");
		var usepswsave = document.getElementById("usepswsave");
		var present = document.getElementById("present");
		//总方法向servlet发送数据
		present.onclick = function() {
			//判断用户名是否为空或者含有空格键
			if(usename.value == null || usename.value == "") {
				//如果不满足要求则弹出alter
				alert("请您输入用户名");
				//如果满足则继续判断其他的
			} else {
				//判断密报数字是否为空
				if(usepswsave.value < 0 || usepswsave.value > 9999 || usepswsave.value == "") {
					alert("请输入正确的密保数字");
				} else {
					//待所有项目完全满足要求后,即可向servlet发送数据
					$.ajax({
						type: "post",
						url: "<%=basePath%>findpsw",
						data: {
							name: usename.value,
							answer: usepswsave.value
						},
						async: true,
						success: function(res) {
							//此处返回一个boolean类型的值,如果为true,则显示注册成功,如果错误,则显示注册失败
							//(用户名已经存在)
							//接受返回的数据
							var result = JSON.parse(res);
							var is = result.flag;
							//var is = 1;
							console.log(is);
							if(is == 1) {
								location.href="<%=basePath%>jsp/newpsw.jsp?usename="+usename.value;
								//location.href="newpsw.html?usename=liuxu";
							} else {
								alert("用户名或者密保数字错误")
							}
						}
					});
				}
			}
		}
	</script>
</html>