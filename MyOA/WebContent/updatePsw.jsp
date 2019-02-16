<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title></title>
	    <link rel="stylesheet" href="css/amazeui.min.css">
		<!--<link rel="stylesheet" href="css/admin.css">-->
		<!--<link rel="stylesheet" href="css/app.css">-->
		<style>
			.admin-main{
				padding-top: 0px;
			}
			.am-form-group{
				margin-bottom: 1.7rem;
				
			}
		</style>
	</head>
	<body>
		<div class="am-cf admin-main" >
		<!-- content start -->
		<div class="admin-content">
			<div class="admin-content-body" >
				<div class="am-g" >
					<form class="am-form am-form-horizontal" style="margin-left: -300px;margin-top: 80px;"
						 method="post"
						style="padding-top:30px;" data-am-validator action="updatePswAction" onsubmit="return pswCheck()">
						<div class="am-form-group">
							<label for="user-name" class="am-u-sm-3 am-form-label">
							工号 </label>
							<div class="am-u-sm-9">
								<input type="text" id="doc-vld-pwd-1" readonly="readonly" value="${emp.jobnum }"> 
							</div>
						</div>
						<div class="am-form-group">
							<label for="user-name" class="am-u-sm-3 am-form-label">
							新密码 </label>
							<div class="am-u-sm-9">
								<input type="password" id="doc-vld-pwd-1" required placeholder="请输入新密码" 
									name="emp.password"> <small>请输入新密码</small>
							</div>
						</div>
						<div class="am-form-group">
							<label for="user-name" class="am-u-sm-3 am-form-label">
								重复密码</label>
							<div class="am-u-sm-9">
								<input type="password" id="doc-vld-pwd-2" required placeholder="请输入重复密码" 
									name="password2" required> <small>再次输入新密码</small><br />
									<small class="class1"></small>
							</div>
						</div>
						<div class="am-form-group">
							<div class="am-u-sm-9 am-u-sm-push-3">
								<input type="submit" class="am-btn am-btn-success" value="修改密码" />
							</div>
						</div>
					</form>
				</div>
			</div>
		</div>
	</div>
	</body>
	<script src="js/jquery-2.2.4.min.js" type="text/javascript" charset="utf-8"></script>
	<script type="text/javascript">
	//提交前判断两次密码是否一致
		function pswCheck(){
			var password1 = $("input[name='emp.password']").val();
			var password2 = $("input[name='password2']").val();
			if(password1==password2){
				//两次密码一致
				return true;
			}else{
				//不一致，设置提示信息
				$("small[class='class1']").text("两次密码不一致");
				$("small[class='class1']").css('color','red');
				return false;
			}
		}
		
	</script>
</html>

