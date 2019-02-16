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
					<span style="margin-left: 120px;">输入新密码</span>
				</div>
				<div class="mid">

					<div class="mid1_1">
						<span style="font-size: 18px;margin-right: 18px; ">
					<span style="color: red;" >*</span> 新密码 :</span>
						<input type="password" id="first" placeholder="请您输入密码" style="color:red; font-size: 12px;height: 28px;width:200px;   border: 1px solid black;" />
					</div>
					<div class="mid1_2">
						<span style="font-size: 	18px;margin-right: 18px;">
					<span style="color: red;">*</span> 确认新密码 :</span>
						<input type="password" id="second" placeholder="请您再次确认密码" style="color:red; font-size: 12px; height: 28px;width:200px;  	border: 1px solid black;" />
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
		var first = document.getElementById("first");
		var second = document.getElementById("second");
		var present = document.getElementById("present");
		var href = 	location.href;
		var usename = href.split("=")[1];
		//总方法向servlet发送数据
		present.onclick = function() {
			//判断密码是否为空或者含有空格键
				//判断前后密码是否一致
				if(first.value ==""||first.value ==null){
					alert("输入有误");
				}else{
				if(first.value != second.value) {
					alert("前后两次密码不一致");
				} else {
					//待所有项目完全满足要求后,即可将数据传输发送至servlet
					$.ajax({
						type: "post",
						url: "<%=basePath%>newpsw",
						data: {
							name: usename,
							newpsw:first.value
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
							//var result = req.getActiveAttrib("flag")
							if(is==1) {
								body.innerHTML="<span>密码修改成功<a href='<%=basePath%>jsp/login.jsp'>登录.....</a></span>";
								
								//alert("修改成功")
							} else {
								alert("修改失败")
							}
						}
					});
				}
				}
			}
	</script>
</html>