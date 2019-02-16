<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
									<input class="am-form-field" id="departName" placeholder="请输入部门名称" type="text">
									<span class="am-input-group-btn">
										<button class="am-btn am-btn-default" type="button" id="btnsearch">
											搜索
										</button> </span>
								</div>
							</div>
						</div>

						<div class="am-g" style="margin-top: -30px;">
							<div class="am-u-sm-12">
								<form class="am-form">
									<table class="am-table am-table-striped am-table-hover table-main">
										<thead>
											<tr>
												<th class="table-check">
													<input id="chkAll" type="checkbox">
												</th>
												<!-- <th class="table-id">
													ID
												</th> -->
												<th class="table-title">
													部门名称
												</th>
												<th class="table-set">
													操作
												</th>
											</tr>
										</thead>
										<tbody id="tUser">
										<c:forEach items="${departments }" var="dept">
											<tr>
												<td><input name="chks" value="27" type="checkbox"></td>
												<!-- <td>27</td> -->
												
												<td>${dept.dname }</td>
												<td>
													<div class="am-btn-toolbar">
														<div class="am-btn-group am-btn-group-xs"><button type="button" class="am-btn am-btn-default am-btn-xs am-text-danger amt-hide-sm-only"  name="deleteDept" value="${dept.dname }"><span class="am-icon-trash-o"></span> 删除</button></div>
													</div>
												</td>
											</tr>
											</c:forEach>
											
											<!-- <tr>
												<td><input name="chks" value="26" type="checkbox"></td>
												<td>26</td>
												<td>产品部</td>
												<td>
													<div class="am-btn-toolbar">
														<div class="am-btn-group am-btn-group-xs"><button type="button" id="depart_26" class="am-btn am-btn-default am-btn-xs am-text-secondary btnedit"><span class="am-icon-pencil-square-o"></span> 编辑</button><button type="button" class="am-btn am-btn-default am-btn-xs am-text-danger amt-hide-sm-only" onclick="deleteDepart(26,1)"><span class="am-icon-trash-o"></span> 删除</button></div>
													</div>
												</td>
											</tr>
											<tr>
												<td><input name="chks" value="25" type="checkbox"></td>
												<td>25</td>
												<td>销售部</td>
												<td>
													<div class="am-btn-toolbar">
														<div class="am-btn-group am-btn-group-xs"><button type="button" id="depart_25" class="am-btn am-btn-default am-btn-xs am-text-secondary btnedit"><span class="am-icon-pencil-square-o"></span> 编辑</button><button type="button" class="am-btn am-btn-default am-btn-xs am-text-danger amt-hide-sm-only" onclick="deleteDepart(25,1)"><span class="am-icon-trash-o"></span> 删除</button></div>
													</div>
												</td>
											</tr>
											<tr>
												<td><input name="chks" value="24" type="checkbox"></td>
												<td>24</td>
												<td>测试部</td>
												<td>
													<div class="am-btn-toolbar">
														<div class="am-btn-group am-btn-group-xs"><button type="button" id="depart_24" class="am-btn am-btn-default am-btn-xs am-text-secondary btnedit"><span class="am-icon-pencil-square-o"></span> 编辑</button><button type="button" class="am-btn am-btn-default am-btn-xs am-text-danger amt-hide-sm-only" onclick="deleteDepart(24,1)"><span class="am-icon-trash-o"></span> 删除</button></div>
													</div>
												</td>
											</tr>
											<tr>
												<td><input name="chks" value="23" type="checkbox"></td>
												<td>23</td>
												<td>市场部</td>
												<td>
													<div class="am-btn-toolbar">
														<div class="am-btn-group am-btn-group-xs"><button type="button" id="depart_23" class="am-btn am-btn-default am-btn-xs am-text-secondary btnedit"><span class="am-icon-pencil-square-o"></span> 编辑</button><button type="button" class="am-btn am-btn-default am-btn-xs am-text-danger amt-hide-sm-only" onclick="deleteDepart(23,1)"><span class="am-icon-trash-o"></span> 删除</button></div>
													</div>
												</td>
											</tr>
											<tr>
												<td><input name="chks" value="22" type="checkbox"></td>
												<td>22</td>
												<td>市场部</td>
												<td>
													<div class="am-btn-toolbar">
														<div class="am-btn-group am-btn-group-xs"><button type="button" id="depart_22" class="am-btn am-btn-default am-btn-xs am-text-secondary btnedit"><span class="am-icon-pencil-square-o"></span> 编辑</button><button type="button" class="am-btn am-btn-default am-btn-xs am-text-danger amt-hide-sm-only" onclick="deleteDepart(22,1)"><span class="am-icon-trash-o"></span> 删除</button></div>
													</div>
												</td>
											</tr>
											<tr>
												<td><input name="chks" value="14" type="checkbox"></td>
												<td>14</td>
												<td>研发部</td>
												<td>
													<div class="am-btn-toolbar">
														<div class="am-btn-group am-btn-group-xs"><button type="button" id="depart_14" class="am-btn am-btn-default am-btn-xs am-text-secondary btnedit"><span class="am-icon-pencil-square-o"></span> 编辑</button><button type="button" class="am-btn am-btn-default am-btn-xs am-text-danger amt-hide-sm-only" onclick="deleteDepart(14,1)"><span class="am-icon-trash-o"></span> 删除</button></div>
													</div>
												</td>
											</tr> -->
										</tbody>
									</table>
								</form>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>

		<script src="js/jquery-2.2.4.min.js" type="text/javascript" charset="utf-8"></script>
		<script src="js/plugs.js" type="text/javascript" charset="utf-8"></script>
		<script type="text/javascript">
		
		/* 只有权限大于等于3的人有权限增删部门 */
		$(document).ready(function () {
			<c:if test="${emp.role.rid<3 }">
			$("button[name=add]").attr("disabled","disabled");
			$("button[name='deleteDept']").attr("disabled","disabled");
		/* 	console.log(1111); */
			</c:if>
		});
		
		
		/* 新增的点击事件 */
		$(".btnAdd").click(function() {
			location.href = "addDept.jsp";
		});
		
		/* 删除的点击事件 */
		$("button[name='deleteDept']").click(function(){
			//获取部门名称
			var deptName= $(this).val();
			console.log("获取到的部门名称为;"+deptName);
			//判断部门中是否有员工
			$.ajax({
				type: "post",
				url: "deleteDeptAction",
				async: true,
				data: {
					dname: deptName
				},
				success: function(res) {
					if(res == "no") {
						//删除失败
						$.jq_Panel({
							title: "❌删除异常",
							iframeWidth: 500,
							iframeHeight: 300,
							url: "default.jsp"
						});
					}else if(res=="yes"){
						alert( "✅删除成功");
						window.location.replace("deptAction_findDepartment");
						//删除成功
						/* $.jq_Panel({
							title: "✅删除成功",
							iframeWidth: 500,
							iframeHeight: 300,
							url: "success.jsp"
						}); */
					}
				}
			});
		})
		</script>
	</body>

</html>