<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
						<form class="am-form am-form-horizontal" action="deptAction_updateEmpDept" method="post" style="padding-top: 30px;">
							<input value="504" name="roleId" type="hidden">
							<%-- <div class="am-form-group">
								<label for="user-name" class="am-u-sm-3 am-form-label">
								工号
								</label>
								<div class="am-u-sm-9">
									<input id="roleName" required="" placeholder="请输入工号(例:1801)" name="emp.jobnum" type="text">
									<small id="helpRole">${uid }</small>
								</div>
							</div>
							<div class="am-form-group">
								<label for="user-name" class="am-u-sm-3 am-form-label">
								姓名
								</label>
								<div class="am-u-sm-9">
									<input id="roleName" required="" placeholder="请输入姓名" value="" name="emp.uname" type="text">
									<small id="helpRole">输入姓名。</small>
								</div>
							</div> --%>
							<div class="am-form-group">
								<div class="am-u-sm-9">
								更换部门:
									<select required name="dname" style="margin-left: 20px;">
										<option value="">
											请选择部门
										</option>
                                <c:forEach items="${departments }" var="d">
										<option>
											${d.dname }
										</option>
                                </c:forEach>
									</select>
									<!-- <small>部门</small> -->
								</div>
							</div>
							<div class="am-form-group">
								<div class="am-u-sm-9 am-u-sm-push-3">
									<input id="addRole" class="am-btn am-btn-success" value="更换" type="submit">
								</div>
							</div>
						</form>
					</div>
				</div>
			</div>
		</div>
	</body>

</html>