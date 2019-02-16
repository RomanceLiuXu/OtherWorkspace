<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!-- uri:路径  prefix:指的是标签头-->
<%@  taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
	String path = request.getContextPath();
	//协议://+IP:+端口号+/+工程名+/
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html>
<html>
<head>
<base href="<%=basePath %>">
<meta charset="utf-8" />
<title></title>
<link rel="stylesheet" type="text/css" href="css/login.css" />
<link rel="stylesheet" type="text/css" href="css/public.css" />
</head>

<body style="min-width: 1024px;">
	<!--头部-->
	<div class="login_header">
		<div class="minWidth" style="width: 1024px;">
			<div class="login_log" style="margin-left: 40px;">
				</a>
			</div>
		</div>
	</div>
	</div>
	<!--头部-->
	<!--中间部分-->
	<div class="login_main" style="height: 600px;">
		<div class="minWidth" style="width: 1024px;">
			<!--用户名登录-->
			<div class="login_box">
				<div class="qrcode"></div>
				<h3>账户登录</h3>
				<%-- <form action="<%=basePath %>jsp/login.jsp" method="post"> --%>
				<form>
					<div class="phone box">
						<span></span> <input type="text" style="display: none;"> <input
							placeholder="请输入用户名" type="text" id="tel">
					</div>
					<div class="password box">
						<span></span> <input type="password" style="display: none;">
						<input placeholder="请输入密码" type="password" id="psd">
					</div>
					<div class="verification">
						<div class="verification_left">
							<span></span> <input type="text" placeholder="验证码" id="codes">
						</div>
						<div class="verification_right">
							<a href="javascript:void(0);" onclick="myImg();"><img id="checkImage" src="<%=basePath %>validateCode.do"></a>
						</div>
					</div>
					<div class="remembercont">
						<input type="checkbox" id="rem" class="remember" name="remeber" />
						<label for="rem" style="font-size: 12px; color: #848585;">记住我</label>
						<p class="forget">
							<a href="<%=basePath %>jsp/checkpsw.jsp">忘记密码？</a>
						</p>
					</div>
					<div class="btn_box">
						<a href="javascript:void(0);" class="login_btn" id="loginSubmit">登录
							<!-- <input type="submit" class="login_btn" id="loginSubmit" value="登录"/> -->
						</a> <a href="<%=basePath %>jsp/Reginster.jsp" class="register_btn">注 册</a>
					</div>
				</form>
			</div>
			<!--用户名登录结束-->
		</div>
	</div>
	<!--中间部分-->

	<!--底部-->
	<div class="footer">
		<span>指缘相亲©2017-2018</span>|<span><a target="_blank"
			href="http://www.miitbeian.gov.cn/">京ICP备16013954号</a></span>
	</div>
</body>
<script src="<%=basePath %>js/jquery-2.2.4.min.js" type="text/javascript"
	charset="utf-8"></script>
<script type="text/javascript">
	//登录
	function myImg(){
		var t = new Date().getTime();
		document.getElementById("checkImage").src="<%=basePath %>validateCode.do?t="+t;
	}	
	var enter = document.getElementById("loginSubmit");
	var code = document.getElementById("tel");
	var psw = document.getElementById("psd");
	var rem = document.getElementById("rem");
	var vcode = document.getElementById("checkImage");
	rem.value = "noton";
	rem.onclick = function () {
		if (rem.checked) {
			rem.value = "on";
		}
	}
	if (getValue("code") != null && getValue("psw") != null) {
		code.value = getValue("code");
		psw.value = getValue("psw");
	} else {
		code.value = "";
		psw.value = "";
	}
	enter.onclick = function() {
		var codeinput = code.value;
		var pswinput = psw.value;
		var vinput = vcode.value;
		if (codeinput == "" || pswinput == "") {
			alert("账号或密码或验证码不能为空!")
		} else {
			
					$.ajax({
						type : "get",
						url : "<%=basePath %>login",
						async : true,
						data : {
							name : codeinput,
							psw : pswinput,
							vcode:viput
						},
						success : function(res) {
							console.log(res);
							if (res != null && res != "") {
// 								var result = eval("(" + res + ")");
								var uid = res.uid;
								var sex = res.sex;
								if (rem.value == "on" || rem.checked) {
									var date = new Date();
									date.setDate(date.getDate() + 7);
									document.cookie = "uid=" + uid
											+ ";expires=" + date;
									document.cookie = "code=" + codeinput
											+ ";expires=" + date;
									document.cookie = "sex=" + sex
											+ ";expires=" + date;
									document.cookie = "psw=" + pswinput
											+ ";expires=" + date;
								} else {
									var date = new Date(0);
									/* document.cookie = "uid=;max-age=-1";
									document.cookie = "sex=;max-age=-1";
									document.cookie = "psw=;max-age=-1"; */
									document.cookie = "uid=" + uid
											+ ";expires=" + date;
									document.cookie = "code=" + codeinput
											+ ";expires=" + date;
									document.cookie = "sex=" + sex
											+ ";expires=" + date;
									document.cookie = "psw=" + pswinput
											+ ";expires=" + date;

								}
								
								location.href = "<%=basePath %>home_initHome"
										;
							} else {
								alert("账号或密码错误");
								location.href = "<%=basePath %>jsp/login.jsp";
							}

						}

					});

		}
	}

	function getValue(key) {
		var value = null;
		var str = document.cookie;
		var arr1 = str.split(";");
		for (var i = 0; i < arr1.length; i++) {
			var arr2 = arr1[i].split("=");
			var k = arr2[0].trim();
			if (k == key) {
				value = arr2[1];
				break;
			}

		}
		return value;
	}
</script>

</html>