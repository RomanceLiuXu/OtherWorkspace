<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html >
<html>

<head>
<meta charset="UTF-8">
<title></title>

<link rel="stylesheet" href="css/amazeui.min.css">
<link rel="stylesheet" href="css/admin.css">
<link rel="stylesheet" href="css/app.css">
<style>
.admin-main {
	padding-top: 0px;
}
</style>
</head>

<body>

	<div class="am-cf admin-main">
		<!-- content start -->
		<div class="admin-content">
			<div class="admin-content-body">
				<div class="am-g">
					<form class="am-form am-form-horizontal" action="updateEmpAction"
						method="post" style="padding-top: 30px;">
						<input value="504" name="roleId" type="hidden">
						<!--工号，工号在此显示，但工号不可改，输入框不可操作-->
						<div class="am-form-group">
							<label for="user-name" class="am-u-sm-3 am-form-label">
								工号 </label>
							<div class="am-u-sm-9">
								<input id="roleName" value="${emp.jobnum }" name="emp.jobnum"
									type="text" readonly="readonly"> <small id="helpRole" style="color: limegreen;">工号不可修改</small>
							</div>
						</div>
						<!--姓名-->
						<div class="am-form-group">
							<label for="user-name" class="am-u-sm-3 am-form-label">
								姓名 </label>
							<div class="am-u-sm-9">
								<input id="roleName" required="required" placeholder="请输入姓名"
									value="${emp.uname }" name="emp.uname" type="text"> <small
									id="helpRole">输入姓名。</small>
							</div>
						</div>
						<!--邮箱信息-->
						<div class="am-form-group">
							<label for="user-name" class="am-u-sm-3 am-form-label">
								邮箱 </label>
							<div class="am-u-sm-9">
								<input id="roleName" required="" placeholder="请输入邮箱"
									value="${emp.email }" name="emp.email" type="text"> <small
									id="helpRole">输入邮箱。</small><br />
								<small class="email"></small>
							</div>
						</div>
						<!--员工地址-->
						<div class="am-form-group">
							<label for="user-name" class="am-u-sm-3 am-form-label">
								地址 </label>
							<div class="am-u-sm-9">
								<input id="roleName" required="" placeholder="请输入地址"
									value="${emp.address }" name="emp.address" type="text">
								<small id="helpRole">输入地址</small>
							</div>
						</div>

						<!--性别选择-->
						<div class="am-form-group">
							<label for="user-name" class="am-u-sm-3 am-form-label">
								性别 </label>
							<div class="am-u-sm-9" style="line-height: 30px;">
								<input type="radio" id="man" name="emp.sex" value="男"
									checked="checked" /> <label for="man"> 男 </label>
								&nbsp;&nbsp;&nbsp;&nbsp; <input type="radio" id="woman"
									name="emp.sex" value="女" /> <label for="woman"> 女 </label> <br />
								<small>性别...</small>
							</div>
						</div>

						<div class="am-form-group">
							<label for="user-name" class="am-u-sm-3 am-form-label">
								部门 </label>
							<div class="am-u-sm-9">
								<input id="roleName" value="${emp.department.dname }"
									name="dname" type="text" readonly="readonly"> <small
									id="helpRole" style="color: limegreen;">部门不可修改</small>
							</div>
						</div>
						<%-- <div class="am-form-group">
								<label for="user-email" class="am-u-sm-3 am-form-label">
										部门
									</label>
								<div class="am-u-sm-9">
									<select name="dname" required="required" disabled="disabled">
										<option value="" >
											请选择部门
										</option>
										<option>
											${emp.department.dname }
										</option>

									</select>
									<small>部门</small>
								</div>
							</div> --%>
						<!--手机验证-->
						<div class="am-form-group">
							<label for="user-name" class="am-u-sm-3 am-form-label">
								手机 </label>
							<div class="am-u-sm-9">
								<input id="roleName" required="" placeholder="请输入手机号"
									value="${emp.phone }" name="emp.phone" type="text"> <input
									id="sendButton" type="button" value="获取验证码" /> <small
									id="helpRole" class="msg">已发送验证码给：</small><br /> <small
									class="phone"></small>
							</div>
						</div>
						<div class="am-form-group">
							<label for="user-name" class="am-u-sm-3 am-form-label">
								验证码 </label>
							<div class="am-u-sm-9">
								<input id="roleName" required="required" placeholder="请输入验证码"
									value="" name="phoneValidate" type="text">
							</div>
						</div>
						<!--提交-->
						<div class="am-form-group">
							<div class="am-u-sm-9 am-u-sm-push-3">
								<input id="addRole" class="am-btn am-btn-success" value="提交"
									type="submit">
							</div>
						</div>
					</form>
				</div>
			</div>
		</div>
	</div>
</body>
<script src="js/jquery-2.2.4.min.js" type="text/javascript"
	charset="utf-8"></script>
<script type="text/javascript">
	//发送验证码按钮
	var $sendButton = $("#sendButton");
	//获取手机验证码
	//给发送验证码按钮设置点击事件
	$sendButton.click(function() {
		//获取用户输入的手机号码
		var $phone = $("input[name='emp.phone']");
		var phone = $phone.val();
		//定义验证手机的正则表达式
		var reg = /^1(?:3\d|4[4-9]|5[0-35-9]|6[67]|7[013-8]|8\d|9\d)\d{8}$/;
		if (!reg.test(phone)) {
			//手机不满足规则，设置提示显示，不发送请求
			$("small[class='phone']").text("手机格式错误");
			$("small[class='phone']").css('color', 'red');
		} else {
			//手机格式正确，发送请求获取验证码
			$(".msg").text("已发送验证码给：" + phone);
			//调用ajax发送请求的方法
			getCode(phone);
			//点击之后按钮设置为不可点击状态
			$sendButton.get(0).disabled = true;
			/* 设置定时器倒计时 */
			//设置总的倒计时长
			var t = 60;
			//点击之后立即开始倒计时，按钮内容立即发生变化
			$sendButton.val(t + "s后可重新发送");
			//设置定时器
			var interval = setInterval(function() {
				t--;
				$sendButton.val(t + "s后可重新发送");
				if (t == 0) {
					//倒计时结束，则清除定时器
					clearInterval(interval);
					//倒计时结束，需要将按钮状态变为可点击状态并且按钮内容也应变回去
					$sendButton.get(0).disabled = false;
					$sendButton.val("获取验证码");
				}
			}, 1000);
		}
	});
	
	/* ajax请求，请求发送短信验证码 */
	function getCode(phone) {
		console.log("ajax中传入的手机号码：" + phone);
		$.ajax({
			type : "post",
			url : "http://localhost:8080/MyOA/phoneCheckAction",
			asasync : true,
			data : {
				phone : phone
			},
			success : function(res) {

			}
		});
	}

	/* 邮箱格式验证 */
	$("input[name='emp.email']").blur(function() {
		//邮箱格式的正则表达式
		var reg = /^[a-zA-Z0-9_.-]+@[a-zA-Z0-9-]+(\.[a-zA-Z0-9-]+)*\.[a-zA-Z0-9]{2,6}$/;
		var uEmail = $("input[name='emp.email']").val();
		if (!reg.test(uEmail)) {
			//邮箱格式错误
			$("small[class='email']").text("邮箱格式错误");
			$("small[class='email']").css('color', 'red');
				return false;
		   }
				return true;
	});

	/* $("input[id='addRole']").click(function(){
		var randomCode = "${randomCode}";
		var phoneValidate = $("input[name='phoneValidate']");
		return false;
	}); */
</script>

</html>