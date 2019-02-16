<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>第一个jsp页面</title>
</head>
<body>
	<!-- 注释1（用户可见） -->
	<%-- 注释2 （用户不可见）--%>
	<div>你好</div>
	
	<!-- java代码 -->
	<% int a=10; %>
	<%=a %>
	<div style="color:red"><%=a %></div>
	
	<% for(int i=1 ; i<=10;i++){ %>
	<div style="color:red"> <%=i %></div>
	<% }%>
	<!-- 申明使用 -->
	<%! String str = "test";%>
	
	<div id="div1"></div>
</body>
<script type="text/javascript">
  var div1 = document.getElementById("div1");
  method1();
  function method1(){
	  div1.innerText = "<%=str %>";
  }
  
 
  
</script>
</html>





