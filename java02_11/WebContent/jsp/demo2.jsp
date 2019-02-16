<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>练习</title>
</head>
<body>
账号:
<input type="text" id="bt1">
<br/>
密码:
<input type="text" id="bt2">
<br/>
<input type="button" id="bt3" value="显示">
<br/>
<div id = "div1"></div>
<div id = "div2"></div>
</body>
<!-- <script src="js/jquery-2.2.4.min.js" type="text/javascript"></script> -->
<script type="text/javascript">

	/* var bt1 = document.getElementById("bt1");
	 var bt2 = document.getElementById("bt2");
	 var bt3 = document.getElementById("bt3");
	 var div1 = document.getElementById("div1");
	 var div2 = document.getElementById("div2");
	 bt3.onclick = function(){
	 var bv1 = bt1.value;
	 var bv2 = bt2.value;
	 div1.innerText = bv1;
	 div2.innerText = bv2;
	 } */

	 <%-- <%  String one = request.getParameter("one");  
	 
	 %> --%>
	 
	 
   $("#bt3").click(function(){

		$("#div1").innerText = $("#bt1").value;
		$("#div2").innerText = $("#bt2").value;

	}); 
</script>
</html>