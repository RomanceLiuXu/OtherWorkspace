<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset=UTF-8>
<title>登录</title>
</head>
<body>
<form action="login.do" method="post">
<fieldset>
<label>用户登录</label><br/>
账号：<input type="text" name="username"><br/>
密码：<input type="text" name="password"><span></span><br/>
<input type="button" onclick="login()" value="登录">
</fieldset>
</form>
</body>
<script type="text/javascript" src="../js/jquery-2.2.4.min.js"></script>
<script type="text/javascript" src="../js/jquery.serializeJson-min.js"></script>
<script type="text/javascript">

function login(){
	var jsonObj = $("form").serializeJson();
	var jsonStr = JSON.stringify(jsonObj);
	$.ajax({
		type:"post",
		url:"../login",
		data:jsonStr,
		contentType:"application/json",
		success:function(data){
			console.log(data);
			if(data){
				location.href="../findPageAll";
			}else{
				$("span").html("<small>账号或密码错误</small>");
				$("span").css("color","red");
			}
		}
	});
}

</script>
</html>