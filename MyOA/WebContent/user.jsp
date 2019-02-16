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
		<title>用户管理</title>

		<link rel="stylesheet" href="css/amazeui.min.css">
		<link rel="stylesheet" href="css/admin.css">
		<link rel="stylesheet" href="css/app.css">
		<!-- <link rel="stylesheet" type="text/css" href="css/test.css">
		<link rel="stylesheet" href="css/base.css" />
		<link rel="stylesheet" href="css/info-mgt.css" />
		<link rel="stylesheet" href="css/WdatePicker.css" /> -->
	</head>

	<body>

		<div class="am-cf admin-main" >
			<!-- content start -->
			
			<div class="admin-content">
				<div class="admin-content-body">
					
					<div class="container" style="padding: 50px 10px 0px 10px">
						<div class="am-g">
							<div class="am-u-sm-12 am-u-md-6">
								<div class="am-btn-toolbar">
									<div class="am-btn-group am-btn-group-xs">
<%-- 									<c:if test="${emp.jobNumber.jobnum>1 }"> --%>
										<button type="button" class="am-btn am-btn-default btnAdd" id="btnadd">
											<span class="icon-plus"></span> 新增
										</button>
                                  
									<!-- 	<button type="button" class="am-btn am-btn-default" id="btnremove" onclick="delAll()">
											<span class="icon-trash"></span> 删除
										</button> -->
<%-- 										 </c:if> --%>
									</div>
								</div>
							</div>
							<div class="am-u-sm-12 am-u-md-3">

								<select id="selDepart" data-am-selected="{btnSize: 'sm'}" name="dname">
									<option value="0">
										请选择部门
									</option>
                        <c:forEach items="${departments }" var="p">
									<option>
										${p.dname }
									</option>
                         </c:forEach>

								</select>
								<div class="am-selected am-dropdown " id="am-selected-dhh2q" data-am-dropdown="" style="display: none;"> <button type="button" class="am-selected-btn am-btn am-dropdown-toggle am-btn-sm am-btn-default">    <span class="am-selected-status am-fl">请选择部门</span>    <i class="am-selected-icon am-icon-caret-down"></i>  </button>
									<div class="am-selected-content am-dropdown-content">
										<h2 class="am-selected-header"><span class="am-icon-chevron-left">返回</span></h2>
										<ul class="am-selected-list">
											<li class="am-checked" data-index="0" data-group="0" data-value="0"> <span class="am-selected-text">请选择部门</span> <i class="am-icon-check"></i></li>
											<li class="" data-index="1" data-group="0" data-value="14"> <span class="am-selected-text">研发部</span> <i class="am-icon-check"></i></li>
										</ul>
										<div class="am-selected-hint"></div>
									</div>
								</div>
								<div class="am-selected am-dropdown " id="am-selected-z6ofo" data-am-dropdown="" >
									<button style="display: none;" type="button" class="am-selected-btn am-btn am-dropdown-toggle am-btn-sm am-btn-default">
										<span class="am-selected-status am-fl">请选择部门</span>
										<i class="am-selected-icon am-icon-caret-down"></i>
									</button>
									<div class="am-selected-content am-dropdown-content">
										<h2 class="am-selected-header">
											<span class="am-icon-chevron-left">返回</span>
										</h2>
										<ul class="am-selected-list">
											<li class="am-checked" data-index="0" data-group="0" data-value="option1">
												<span class="am-selected-text">请选择部门</span>
												<i class="am-icon-check"></i>
											</li>

											<li class="" data-index="1" data-group="0" data-value="option2">
												<span class="am-selected-text">研发部</span>
												<i class="am-icon-check"></i>
											</li>

											<li class="" data-index="1" data-group="0" data-value="option2">
												<span class="am-selected-text">市场部</span>
												<i class="am-icon-check"></i>
											</li>

											<li class="" data-index="1" data-group="0" data-value="option2">
												<span class="am-selected-text">渠道一部</span>
												<i class="am-icon-check"></i>
											</li>

											<li class="" data-index="1" data-group="0" data-value="option2">
												<span class="am-selected-text">教学部</span>
												<i class="am-icon-check"></i>
											</li>

											<li class="" data-index="1" data-group="0" data-value="option2">
												<span class="am-selected-text">教务部</span>
												<i class="am-icon-check"></i>
											</li>

											<li class="" data-index="1" data-group="0" data-value="option2">
												<span class="am-selected-text">渠道二部</span>
												<i class="am-icon-check"></i>
											</li>

											<li class="" data-index="1" data-group="0" data-value="option2">
												<span class="am-selected-text">渠道三部</span>
												<i class="am-icon-check"></i>
											</li>

										</ul>
										<div class="am-selected-hint"></div>
									</div>
								</div>
							</div>

							<div class="am-u-sm-12 am-u-md-3">
								<div class="am-input-group am-input-group-sm">
									<input class="am-form-field" placeholder="请输入员工姓名" id="uname" name="uname" type="text">
									<span class="am-input-group-btn">
										<button class="am-btn am-btn-default" type="button" id="btnsearch">
											搜索
										</button> </span>
								</div>
							</div>
						</div>
						<div class="am-g" style="margin-top: -30px;">
							<div class="am-u-sm-12">
								<form class="am-form" action="user/delAll.action">
									<table class="am-table am-table-striped am-table-hover table-main">
										<thead>
											<tr>
<!-- 												<th class="table-check"> -->
<!-- 													<input id="chkAll" type="checkbox"> -->
<!-- 												</th> -->
												<th class="table-id">
													ID
												</th>
												<th>
													工号
												</th>
												<th class="table-title">
													姓名
												</th>
												<th>
													性别
												</th>
												<th>
													部门名称
												</th>
												<th>
													手机
												</th>
												<th>
													邮箱
												</th>
												<th>
													地址
												</th>
<%-- 												<c:if test="${emp.jobNumber.jobnum>1 }"> --%>
												<th class="table-set">
													操作
												</th>
<%-- 												</c:if> --%>
											</tr>
										</thead>
										<tbody id="tUser">
										<c:forEach items="${employees}" var="employee">
											<tr>
<!-- 												<td><input name="ids" value="1" type="checkbox"></td> -->
												<td>${employee.uid }</td>
												<td>${employee.jobnum }</td>
												<td>
													<a href="#">${employee.uname }</a>
												</td>
												<td><span class="am-badge am-badge-secondary">${employee.sex }</span></td>
												<td>${employee.department.dname }</td>
												<td>${employee.phone}</td>
												<td>${employee.email}</td>
												<td>${employee.address}</td>
<%-- 												<c:if test="${emp.jobNumber.jobnum>1 }"> --%>
												<td>
													<div class="am-btn-toolbar">
														<div class="am-btn-group am-btn-group-xs"><button name="add" type="button" value="${employee.uid }" class="am-btn am-btn-default am-btn-xs am-text-secondary btnEdit"><span class="am-icon-pencil-square-o"></span>调换部门</button><button name="updateRole" type="button" value="${employee.uid }" class="am-btn am-btn-default am-btn-xs am-text-secondary btnEdit"><span class="am-icon-pencil-square-o"></span>权限操作</button><button type="button" name="delete" value="${employee.uid }" class="am-btn am-btn-default am-btn-xs am-text-danger am-hide-sm-only"><span class="am-icon-trash-o"></span> 删除</button></div>
													</div>
												</td>
<%-- 												</c:if> --%>
											</tr>
											</c:forEach>
										</tbody>
									</table>
							<!-- 弹窗内容开始 -->
		<!-- <div id="background" class="back">
			<div id="div1" class="content">
				<div id="close">
					<span id="close-button">×</span>
					<h2>修改部门</h2>
				</div>
				<div id="div2">
					<h3>弹窗标题</h3>
					<div class="query" style="margin-top: 10px;">
						<div class="query-conditions ue-clear">
							<div class="conditions name ue-clear">
								<label>部门名称：</label>
								<div class="select-wrap">
									<div class="select-title ue-clear">
										<span style="color: red;">请选择要更换的部门</span><i class="icon"></i>
									</div>
									<ul class="select-list">
										<li>研发部</li>
										<li>销售部</li>
										<li>市场部</li>
									</ul>
								</div>
							</div>
						</div>
					</div>
				</div>
				<h3 id="foot">底部内容</h3>
			</div>
		</div>		 -->
									
									
                            <div align="center">
							<c:if test="${pageIndex>1 }">
								
								<a href="employeeListsAction?pageIndex=${pageIndex-1 }">上一页</a> 
								</c:if>
								<b>第${pageIndex}页,共${allPage }页</b>
								<c:if test="${pageIndex<allPage }">
								
								<a href="employeeListsAction?pageIndex=${pageIndex+1 }">下一页</a>
								
							</div>
							</c:if>
								</form>
							</div>
						</div>
					</div>

				</div>
				<!-- content end -->
			</div>
		</div>

		<!--[if lt IE 9]>
<script src="http://libs.baidu.com/jquery/1.11.3/jquery.min.js"></script>
<script src="http://cdn.staticfile.org/modernizr/2.8.3/modernizr.js"></script>
<script src="assets/js/amazeui.ie8polyfill.min.js"></script>
<![endif]-->

		<!--[if (gte IE 9)|!(IE)]><!-->
		<script src="js/jquery-1.11.3.min.js"></script>
		<!--<![endif]-->
		<!-- 弹窗内容结束 -->
		<!-- <script src="js/test.js"></script> -->
		<script src="js/jquery-2.2.4.min.js" type="text/javascript" charset="utf-8"></script>
		<script src="js/common.js" type="text/javascript" charset="utf-8"></script>
		<script type="text/javascript" src="myplugs/js/plugs.js"></script>
		<script>
		
		//更换部门
		$("button[name=add]").click(function(){
			console.log($(this).val());
			var uid = $(this).val();
			 location.href="deptAction_findUidD?uid="+uid;
		});
	    //更新权限
		$("button[name=updateRole]").click(function(){
			console.log($(this).val());
			var uid = $(this).val();
			 location.href="deptAction_findUid?uid="+uid;
		});
		//新增员工
		$("#btnadd").click(function(){
		 	location.href="addUser.jsp";
		});
		
		$("button[name='delete']").click(function(){
			console.log("删除时获取的uid:"+$(this).val());
			if(confirm("确认删除该员工?")){
			$.ajax({
				type: "post",
				url: "deleteEmpAction",
				async: true,
				data: {
					uid: $(this).val()
				},
				success:function(res){
					console.log(res);
					if(res == "success"){
						location.href="employeeListsAction";
					}
				}
				
			});
			}
		});
		
		$(document).ready(function(){
			<c:if test="${emp.role.rid<=1 }">
             $("#btnadd").attr("disabled","disabled");
             $("#btnremove").attr("disabled","disabled");
             $("button[name=add]").attr("disabled","disabled");
             $("button[name=delete]").attr("disabled","disabled");
             $("button[name=updateRole]").attr("disabled","disabled");
			</c:if>
		});
		
		
		$("#btnsearch").click(function () {
			if($("#uname").val()==""&&$("#selDepart").val()=='0'){
				alert("请输入正确的查询条件");
			}else{
				/* alert("查询条件正确"); */
			location.href="employeeListsAction?uname="+$("#uname").val()+"&&dname="+$("#selDepart").val();
			}
		});
		
			/* $(function() {
				 $("button[name=add]").click(function() {
					
					location.href="changeDept.jsp";
				});
					
				$("button[name=delete]").click(function() {
					
					if(confirm("确认删除该员工?")){
						
					location.href="addUser.jsp";
					} */
// 					$.jq_Panel({
// 						title: "编辑用户",
// 						url: "addUser.jsp",
// 						iframeWidth: 800,
// 						iframeHeight: 600,
// 					});
/* 
				});

			}); */
		</script>
	</body>

</html>