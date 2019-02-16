<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset=UTF-8>
<title>登录</title>
</head>
<body>
<form action="logincheck.jsp" method="get">
账号:
<input type="text" name="code">
<br>
密码:
<input type="password" name="psw">
<br>
<input type="submit" value = "登录">
</form>
</body>
<script type="text/javascript">

   var inputs = document.querySelectorAll("input");
   var sub = inputs[2];
   sub.onclick = function (){
	   if(inputs[0].value==""||inputs[0].value==null||inputs[1].value==""||inputs[1].value==null){
		   return false;
	   }
	   return true;
   }

</script>
</html>