<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

	<head>
		<meta charset="utf-8" />
		<title></title>
	</head>

	<body>
		<form class="testform" action="" method="post">
			 账号:
			 <input type="text" name="code" datatype="s5-16" errormsg="用户名至少5个字符，最多16个字符" ignore="ignore" ajaxurl="http://localhost:8080/java02_14/myTest"/><br />
			 <span class="Validform_checktip"></span>
			 密码:
			<input type="password" name="psw" datatype="*6-15" errormsg="密码范围6-15位" /><br /> 
			确认密码:
			<input type="password" name="psw1" datatype="*" recheck="psw" errormsg="两次密码输入不一致" /><br /> 
			手机:
			<input type="text" name="phone" datatype="m" errormsg="手机格式不正确" />
			<input type="submit" value="提交" />
		</form>
	</body>
	<script src="js/jquery-2.2.4.min.js" type="text/javascript" charset="utf-8"></script>
	<script src="js/Validform_v5.3.2.js" type="text/javascript" charset="utf-8"></script>
	<script type="text/javascript">
	  $(".testform").Validform();
	  $(".testform").Validform(
	  	tiptype:2
	  	
	  );
//	  $.Tipmsg.tit="提示";
	</script>

</html>