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
</head>

<body>

	<div class="am-cf admin-main">
		<!-- content start -->
		<div class="admin-content">
			<div class="admin-content-body">

				<div class="container" style="padding: 50px 10px 0px 10px">
					<div class="am-g">
						<div class="am-u-sm-12 am-u-md-6">
							<div class="am-btn-toolbar">
								<div class="am-btn-group am-btn-group-xs">

									<button type="button" name="add" class="am-btn am-btn-default btnAdd">
										<span class="icon-plus"></span> 新增
									</button>

								</div>
							</div>
						</div>
						<div class="am-u-sm-12 am-u-md-3">
							<div class="am-input-group am-input-group-sm">
								<input id="roleName" class="am-form-field" placeholder="请输入角色名称"
									type="text"> <span class="am-input-group-btn">
									<button class="am-btn am-btn-default" type="button"
										id="btnsearch">搜索</button>
								</span>
							</div>
						</div>
					</div>

					<div class="am-g" style="margin-top: 5px;">
						<div class="am-u-sm-12">
							<form class="am-form">
								<table
									class="am-table am-table-striped am-table-hover table-main">
									<thead>
										<tr>
											<th class="table-id"><input id="chkAll" type="checkbox">
											</th>

											<th>角色名称</th>
											<th class="table-title">角色描述</th>
										</tr>
									</thead>
									<tbody id="tUser">
										<c:forEach items="${roles }" var="role">
											<tr>
												<td><input name="chks" value="701" type="checkbox"></td>
												<td><a href="javascript:void(0)">${role.rname }</a></td>
												<c:choose>
													<c:when test="${role.rid>=3 }">
														<td>拥有所有权限</td>
													</c:when>
													<c:when test="${role.rid==2 }">
														<td>拥有部分权限</td>
													</c:when>
													<c:when test="${role.rid<=1 }">
														<td>拥有查看权限</td>
													</c:when>
												</c:choose>
											</tr>
										</c:forEach>
									</tbody>
								</table>

							</form>
						</div>
					</div>
				</div>

			</div>
			<!-- content end -->
		</div>
	</div>

	<!--[if (gte IE 9)|!(IE)]><!-->
	<script src="js/jquery-1.11.3.min.js"></script>
	<script src="js/jquery-2.2.4.min.js" type="text/javascript" charset="utf-8"></script>
	<!--<![endif]-->
	<script type="text/javascript" src="myplugs/js/plugs.js"></script>
	<script>
 		 $(document).ready(function(){ 
 				<c:if test="${emp.role.rid<3 }">
 				$("button[name=add]").attr("disabled","disabled");
 				</c:if>
 		});

			$(function() {
						$(".btnedit").click(function() {

							 location.href="editRole.jsp";
						});
						
						 $(".btnAdd").click(function(){
						 	
// 						 	$.jq_Panel({
// 								title: "添加角色",
//  								iframeWidth: ,
//  								iframeHeight: ,
// 								url: "editRole.jsp"
// 							});
							 location.href="editRole.jsp";
						});						
			});
		/*  function sharesysfun(id){
		 	location.href="shareRole.html";
		 } */
		</script>
</body>

</html>