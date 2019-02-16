<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	//协议://+IP:+端口号+/+工程名+/
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title></title>
	</head>
	<body>
		<form action="http://localhost:8080/Match/emailCheck" method="post">
		邮箱：<input type="text" name="mail" id="mail"/><input type="button" value="发送验证码" name="mailcode"/><br />
		邮箱验证码：<input type="text" name="vcode" id="vcode"/><br />
		<input type="submit" value="提交"/>
		</form>
	</body>
	<script src="<%=basePath %>js/jquery-2.2.4.min.js" type="text/javascript" charset="utf-8"></script>
	<script type="text/javascript">
	var mail = document.getElementById("mail");
	var $but = $("input[name='mailcode']");
	$but.click(function() {
			if(validate(mail.value)) {
				//验证通过后获取当前对象
			    var obj = $(this);
			    //禁用按钮，使之不能点击
				obj.attr("disabled","disabled");
				//进行请求邮箱验证码
				$.ajax({
					type: "post",
					url: "http://localhost:8080/Match/email",
					data:{
					mail:mail.value	
					},
					async: true,
					success: function(res) {
						console.log(res);
					}
				});
				//设置倒计时时间59-0
				var time = 59;
				//serInterval()按照指定周期（毫秒计算）来调用函数或计算表达式，返回一个ID值
				var timer = setInterval(function(){
					var temp = time--;
					obj.attr("value","("+temp+"s)后重新获取验证码");
					if(temp <= 0){
						obj.removeAttr("disabled");
						obj.attr("value","获取验证码");
						//取消setInterval()的设置的时间
						clearInterval(timer);
						return;
					}
				},1000);//设置1000毫秒=1秒
			}
	})

	function validate(str) {
		//验证邮箱的正则表达式
		var exp = /^\w+([-+.]\w+)*@\w+([-.]\w+)*\.\w+([-.]\w+)*$/;
		if(exp.test(str)) {
			return true;
		} else {
			alert("邮箱格式错误");
			return false;
		}

	}
		
	</script>
</html>
