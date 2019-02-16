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
		<link rel="stylesheet" type="text/css" href="<%=basePath %>css/secondProject.css" />
	</head>

	<body>
		<!--头顶层-->
		<div class="top1">
			<div class="top00">
				<div class="top1-1">
					<!--<span>珍爱网</span>
					<br />
					<span>zhenai.com</span>-->
				</div>
				<div class="top1-2">
					每个渴望爱的人 都值得被真爱
				</div>
			</div>
		</div>

		<div class="out">
			<!--底部层-->
			<div class="wrap">
				<div class="top2">
					<span style="margin-left: 120px;">请编辑个人资料</span>
				</div>
				<div class="mid">

					<!--上传图片-->
					<div class="float">
						
						
						<!-- <div class="up"> -->
						<!-- 去掉部分此部分重新跳转页面进行图片加载 -->
							<!-- <form action="fileup" class="up" enctype="multipart/form-data" method="post">
								<input type="file" name="file" id="file1" />
								<input type="submit" value="上传" />
							</form> -->
						<!-- </div> -->
						<p>
							<!--此处需要连接一个上传地址-->
							<img src="<%=basePath %>img/head.jpeg" width="150px" height="160px" style="margin-top: 0px;">
						</p>
					</div>
                     <!-- 使用form表单 -->
                    <form action="<%=basePath %>register_register" method="post">
					<div class="mid1_1">
						<span style="font-size: 18px;margin-right: 18px; ">
					<span style="color: red;" >*</span> 姓 名 :</span>
						<input type="text" id="usename" placeholder="请您输入账号名" name="user.name" style="color:red; font-size: 12px;height: 28px;width:200px;   border: 1px solid black;" />
					</div>
					<div class="mid1_2">
						<span style="font-size: 	18px;margin-right: 18px;">
					<span style="color: red;">*</span> 密 码 :</span>
						<input type="password" id="usepsw1" placeholder="请您输入密码" name="user.psw" style="color:red; font-size: 12px; height: 28px;width:200px;  	border: 1px solid black;" />
					</div>
					<div class="mid1_2_1">
						<span style="font-size: 	18px;margin-right: 18px;">
					<span style="color: red;">*</span> 确 认 密 码 :</span>
						<input type="password" id="usepsw2" placeholder="请您确认密码"  style="color:red; font-size: 12px; height: 28px;width:200px;  	border: 1px solid black;" />
					</div>
					<div class="mid1_2_2">
						<span style="font-size: 	18px;margin-right: 18px;">
					<span style="color: red;">*</span> 密 保 数 字 :</span>
						<input type="password" id="usepswsave" placeholder="请您输入四位密保数字" name="user.answer" style="color:red; font-size: 12px; height: 28px;width:200px;  	border: 1px solid black;" />
					</div>
					<div class="mid1_4">
						<span style="font-size: 	18px;margin-right: 18px;">
					<span style="color: red;">*</span> 年 龄 :</span>
						<input type="text" id="useage" placeholder="请您输入0-120之间数字" name="user.age" style="color:red; font-size: 12px;height: 28px;width:200px;  	border: 1px solid black;" />
					</div>
										<div class="mid1_4">
						<span style="font-size: 	18px;margin-right: 18px;">
					<span style="color: red;">*</span> 邮 箱 :</span>
						<input type="text" id="vcode" placeholder="请您输入邮箱" name="vcode" style="color:red; font-size: 12px; height: 28px;width:200px;  	border: 1px solid black;" />
					</div>
					
                   <div class="mid1_2_2">
						<span style="font-size: 	18px;margin-right: 18px;">
					<span style="color: red;">*</span> 邮 箱 验 证 :</span>
						<input type="text" id="mail" placeholder="请您输入邮箱验证码" name="mailcode" style="color:red; font-size: 12px; height: 28px;width:200px;  	border: 1px solid black;" />
					</div>
					
					<div class="mid1_3">
						<span style="color: red;">*</span>
						<!--<span style="font-size: 	18px;margin-right: 18px;">性 别 :</span>
				<input type="text" style="color:red; font-size: 18px;height: 28px;width:200px;  	border: 1px solid black;"/>-->
						<input type="radio" class="sex" name="user.sex" checked value="男">男</input>
						<input type="radio" class="sex" name="user.sex" value="女" style="margin-left: 30px;">女</input>
					</div>

					<select class="mid1_5" name="province" style="font-size: 18px;">
						<option>省份</option>
						<option>陕西</option>
						<option>山西</option>
						<option>广东</option>
					</select>
					<select class="mid1_6" name="city" style="font-size: 18px;">
						<option>城市</option>
					</select>
				</div>
				<!--<div class="right">
					<span style="text-align: center;margin-bottom: 5px;">点击上传照片</span>
				</div>-->
				<div class="read">
					<input type="checkbox" class="procoloread" name="vehicle" value="read" checked="checked" style="height: 20xp;width: 20px;" />
					<a href="read.html">真爱网服务协议</a>
				</div>
<!-- 				<div class="down" id="present"> -->
<!-- 					确认注册 -->
<!-- 				</div> -->
				<input type="submit" id="present" class="down" value="确认注册">
				</form>
				<!--底部图片-->
				<div class="photo">
					<span style="font-size: 28px;font-style: normal;color: black;">有缘网!你唯一的选择</span>
				</div>
			</div>
		</div>

	</body>
	<script type="text/javascript" src="<%=basePath %>js/jquery-2.2.4.min.js" ></script>
	<script type="text/javascript" src="<%=basePath %>js/reginster.js" ></script>
</html>