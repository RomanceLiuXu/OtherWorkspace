<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
  
 <head>
    <meta charset="utf-8">
    
	<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no">
    <meta name="apple-mobile-web-app-capable" content="yes"> 
    
<link href="css/bootstrap.min.css" rel="stylesheet" type="text/css" />
<link href="css/bootstrap-responsive.min.css" rel="stylesheet" type="text/css" />

<link href="css/font-awesome.css" rel="stylesheet">
    <link href="http://fonts.googleapis.com/css?family=Open+Sans:400italic,600italic,400,600" rel="stylesheet">
    
<link href="css/style.css" rel="stylesheet" type="text/css">
<link href="css/signin.css" rel="stylesheet" type="text/css">

</head>
<% 
/* out.print(request.getParameter("id")); */
//创建数据库访问对象，获取对应的student
//将查询到的student保存到resquest中
%>
<body>
<div class="navbar">
		<div class="navbar-inner">
			<div class="container-fluid">
				<a class="btn btn-navbar" data-toggle="collapse"
					data-target=".top-nav.nav-collapse,.sidebar-nav.nav-collapse">
					<span class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
				</a> <a class="brand" href="#"><span>蓝鸥学员管理系统</span></a>

				<!-- start: Header Menu -->
				<div class="nav-no-collapse header-nav">
					<ul class="nav pull-right">
						<!-- start: User Dropdown -->
						<li class="dropdown"><a class="btn dropdown-toggle"
							data-toggle="dropdown" href="#"> <i
								class="halflings-icon white user"></i> ${stu.name} <span
								class="caret"></span>
						</a>
							<ul class="dropdown-menu">
								<li class="dropdown-menu-title"><span>账号设置</span></li>
								<li><a href="LogOutAction"><i
										class="halflings-icon off"></i>退出登录</a></li>
							</ul></li>
						<!-- end: User Dropdown -->
					</ul>
				</div>
			</div>
		</div>
	</div>
	<!-- start: Header -->
<div class="account-container register">
	
	<div class="content clearfix">
		
		<form action="ChangeStudentAction" method="post" id="sform">
		   <input type="hidden" name="id" value="id">
			<h1>学员信息修改</h1>			
			
			<div class="login-fields">
				<div class="field">
				    <b>姓名:</b>
					<label for="firstname">First Name:</label>
					<input type="text" id="firstname" name="name" value="name" class="login" />
				</div> <!-- /field -->
				
				<div class="field">
				    <b>性别:</b>			
					<label for="lastname">Last Name:</label>	
					<input type="text" id="lastname" name="sex" value="stu.sex" class="login" />
				
				</div> <!-- /field -->
				
				<div class="field">
				   <b>数学:</b>
					<label for="email">Email Address:</label>
					<input type="text" id="email" name=math value="stu.math" class=""/>
				</div> <!-- /field -->
				
				<div class="field">
				    <b>英语:</b>
					<label for="password">Password:</label>
					<input type="text" id="password" name="english" value="stu.english" class="login"/>
				</div> <!-- /field -->
				
				<div class="field">
				    <b>语文:</b>
					<label for="confirm_password">Confirm Password:</label>
					<input type="text" id="email" name="chinese" value="stu.chinese" class=""/>
					
				</div> <!-- /field -->
				
			</div> <!-- /login-fields -->
			
			<div style="text-align: center;" >					
				<input class="button btn btn-primary btn-large" style="float:none;" type="reset">撤销</button>
				<button class="button btn btn-primary btn-large" style="float:none;"  type="submit">确认</button>
			</div> <!-- .actions -->
		</form>
		
	</div> <!-- /content -->
	
</div> <!-- /account-container -->
<script src="js/jquery-1.9.1.min.js"></script>
<script src="js/bootstrap.js"></script>

<script src="js/signin.js"></script>


</body>

 </html>
