<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String basepath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ "/" + request.getContextPath() + "/";
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>标题</title>
</head>
<body style="min-width: 700px">
	<div style="width: 750px;">
		<!-- 展示聊天内容的界面 -->
		<div id="content"
			style="border: 1px solid black; width: 600px; height: 470px; float: left;"></div>
		<!-- 展示用户列表的界面 -->
		<div id="userlist"
			style="border: 1px solid black; width: 120px; height: 470px; float: left;"></div>
		<!-- 输入聊天内容的界面 -->
		<input id="msg" type="text"
			style="border: 1px solid black; width: 720px; height: 50px;" />
		<!-- 发送消息和退出的按钮 -->
		<br />
		<div style="width: 600px; height: 50px;">
			<input id="send" type="button" onclick="send()" value="发送" /> <input
				id="out" type="button" onclick="out()" value="退出" />
		</div>
	</div>
</body>
<script type="text/javascript" src="<%=basepath%>js/jquery.min.js"></script>
<script type="text/javascript">
	//跳转到登录界面的方法
	function out() {
		location.href = "login.jsp";
	}
	//定义一个变量存放通讯用户
	var test;
	//定义url请求路径
	var url = "ws://localhost:8080/websocketnew/chatSocket?username=${sessionScope.username}";
	window.onload = function() {
		if ('WebSocket' in window) {
			test = new WebSocket(url);
		} else if ('MozWebSocket' in window) {
			test = new MozWebSocket(url);//火狐支持
		} else {
			alert("你的浏览器不支持WebSocket");
			return;
		}
		//监听服务器发送过来的所有信息
		test.onmessage = function(event) {
			console.log(event.data);
			var result = eval("(" + event.data + ")");
			console.log(result);
			//用户上线提醒
			if (result.alert != undefined) {
				$("#content").append("<font color=red>" + result.alert + "</font>"+ "<br/>");
			}
			//如果用户列表不为空就显示
			if (result.names != undefined) {
				//刷新用户列表之前清空一下列表，免得会重复，因为后台只是单纯的添加
				$("#userlist").html("");
				var arr = result.names;
				for (var i = 0; i < arr.length; i++) {
					$("#userlist").append("<font color=red>" + arr[i] + "</font>" + "<br/>");
				}
			}
			//显示聊天内容(谁在什么时候说什么)
			if (result.fromWho != undefined) {
				document.getElementById("content").innerHTML += result.fromWho
						+ " " + result.date + " 说：<br/>" + result.sendMsg
						+ "<br/>";
			}
		}
	}

	//向服务器发送消息的方法
	function send() {
		var value = $("#msg").val();
		if (value == null || value == "") {
			alert("输入不能为空");
			return false;
		}
		//将发送的内容转换json字符串发送出去
		var msg = JSON.stringify(value);
		test.send(msg);
		$("#msg").val("");
	}
</script>
</html>