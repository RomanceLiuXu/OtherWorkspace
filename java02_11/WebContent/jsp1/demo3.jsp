<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset=UTF-8>
<title>作业二</title>
<script type="text/javascript">

// myform.onsubmit = true;
//  onsubmit="method1()"
// sub.onclick = function(){
// method1();
// myform.onsubmit = method1();	
// }  
/* console.log(method1());
if(method1()){
	sub.type = "submit";
} */
/* sub.onclick=function(){
	if(method1()){
		formSubmit();
	}
} */


/* function formSubmit()
{
myfrom.submit();
}
 */
function method1(){
	 var code = document.getElementById("in1");
	 var psw = document.getElementById("in2");
	// var sub = document.getElementById("in3");
	 //var myform = document.getElementById("myform");
	if(code.value==""||psw.value==""||code.value==null||psw.value==null){
		alert("用户名或密码不能为空");
		return false;
	}
	return true;
}
</script>
</head>
<body>
<form id="myform" action="logincheck.jsp" method="get" onsubmit = "return method1();">
账号:
<input type="text" name="code" id="in1">
<br>
密码:
<input type="password" name="psw" id="in2">
<br>
<input type="submit" value = "登录" id="in3">
</form>
</body>

</html>
