<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<meta http-equiv="Pragma" content="no-cache">
		<meta http-equiv="Cache-Control" content="no-cache">
		<meta http-equiv="Expires" content="0">
		<title>办公系统</title>
		<link href="css/login.css" rel="stylesheet" type="text/css" />
	</head>

	<body>
		<div class="login_box">
			<div class="login_l_img"><img src="images/login-img.png" /></div>
			<div class="login">
				<div class="login_logo">
					<a href="#"><img src="images/login_logo.png" /></a>
				</div>
				<div class="login_name">
					<p>自动化办公系统</p>
				</div>
				<form method="post" action="loginCheckAction" onsubmit="return nullCheck()">
					<input name="emp.jobnum" type="text" placeholder="请输入工号">&nbsp;<small class="flag"></small>
					<span id="password_text" onclick="this.style.display='none';document.getElementById('password').style.display='block';document.getElementById('password').focus().select();">请输入密码</span>
					<input name="emp.password" placeholder="请输入密码" type="password" id="password" style="display:none;" onblur="if(this.value==''){document.getElementById('password_text').style.display='block';this.style.display='none'};" />
					<input value="登录" style="width:100%;" type="submit">
				</form>
			</div>
			<div class="copyright">苏米科技有限公司 版权所有©2016-2018 技术支持电话：000-00000000</div>
		</div>
	</body>
	<script src="js/jquery-2.2.4.min.js" type="text/javascript" charset="utf-8"></script>
	<script type="text/javascript">
		//判断工号和密码是否为空
		function nullCheck() {
			var uname = $("input[name='emp.jobnum']").val();
			var psw = $("input[name='emp.password']").val();
			console.log(uname + "--" + psw);
			if(uname == "" || psw == "") {
				//工号和密码有空值
				$("small[class='flag']").text("账号和密码不能为空");
				$("small[class='flag']").css('color', 'red');
				return false;
			} else{
				//以18开头四位数以上
				var reg = /^18\d{2,}$/;
				if(!reg.test(uname)) {
					//工号密码都不为空，但账号不符合规则
					$("small[class='flag']").text("工号格式错误");
					$("small[class='flag']").css('color', 'red');
					return false;
				} else {
					//工号和密码都不为空，且账号符合规则
					$("small[class='flag']").text("");
					return true;
				}
			}
		}

	</script>

</html>