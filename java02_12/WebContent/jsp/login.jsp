<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset=UTF-8>
<title>登录</title>
</head>
<body>
<form action="../login" method="post">
用户名:
<input type="text" name="username">
<br>
密码:
<input type="password" name="password">
<br>
<input type="text" hidden name="flag">
<input type="submit" value="登录">
<input type="submit" value="保存登录">
</form>

</body>
<script type="text/javascript">
//获取所有节点
var inputs = document.querySelectorAll("input");
//
inputs[3].onclick = function(){
	inputs[2].value = "1";
	return jumpInput();
	
}
inputs[4].onclick = function(){
	inputs[2].value = "0";
	return jumpInput();
}
function jumpInput(){
	if(inputs[0].value==null||inputs[0].value==""||inputs[1].value==null||inputs[1].value==""){
		alert("输入有误");
		return false;
	}
	return true;
}
</script>
</html>