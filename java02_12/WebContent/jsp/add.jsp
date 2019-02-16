<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset=UTF-8>
<title>登录</title>
</head>
<body>
<form action="../add" method="post">

<input type="text" name="name" placeholder="用户名">
<br>
<input type="text" name="sex" placeholder="性别">
<br>
<input type="password" name="psw" placeholder="密码">
<br>
<input type="text" hidden name="flag">
<input type="submit" value="添加" >

</form>

</body>
<script type="text/javascript">
//获取所有节点
var inputs = document.querySelectorAll("input");
//
inputs[4].onclick = function(){
	inputs[2].value = "1";
	return jumpInput();
	
}
function jumpInput(){
	if(inputs[0].value==null||inputs[0].value==""||inputs[1].value==null||inputs[1].value==""||inputs[2].value==null||inputs[2].value==""){
		alert("输入有误");
		return false;
	}
	return true;
}
</script>
</html>