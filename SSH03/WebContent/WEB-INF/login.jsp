<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset=UTF-8>
<title>登录</title>
<script type="text/javascript" src="<%=request.getContextPath() %>/js/jquery-2.2.4.min.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/js/jquery.serializeJson-min.js"></script>
<script type="text/javascript">
//点击登录按钮，将数据提交给springmvc
  function login(){
	//一次性将表单中数据序列化成请求实体字符串格式
	var requestData = $("form").serialize();
	console.log(requestData);
	  $.ajax({
		  type:"post",
		  url:"login.do",
		 /*  data:"username=admmin&password=123", */
		 data:
			/* username:$("input[name='username']").val(),
			password:$("input[name='password']").val() */
			requestData
		 ,
		  success:function(data){
			  console.log(data);
		  }
	  });
  }
//ajax提交json字符串格式数据给springmvc
  function login1(){
	var requestJson = '{"username":"'+$("input[name='username']").val()+'","password":"'+$("input[name='password']").val()+'"}';
	//直接将表单中数据全部序列化json字符串格式
	//1.将表单中数据序列化json对象
	var jsonStr = $("form").serializeJson();
	//2.将json对象转换成json字符串
	if (typeof requestData != 'string') {
		jsonStr = JSON.stringify(jsonStr);
    }
	console.log(jsonStr,typeof jsonStr);
	  $.ajax({
		  type:"post",
		  url:"login1.do", 
		  data:jsonStr,
		  contentType:"application/json",//告诉服务器提交的数据类型为json
		  success:function(data){
			  console.log(data);
		  }
	  });
	  
  }

</script>
</head>
<body>
<form action="login.do" method="post">
<fieldset>
<label>用户登录</label><br/>
账号：<input type="text" name="username"><br/>
密码：<input type="password" name="password"><br/>
<input type="button" value="登录" onclick="login1()"/>
</fieldset>
</form>
</body>
</html>