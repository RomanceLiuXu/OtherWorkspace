<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@  taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
	String path = request.getContextPath();
	//协议://+IP:+端口号+/+工程名+/
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!doctype html>
<html>
<head>
<meta charset="utf-8">
<link rel="stylesheet" href="css/base.css" />
<link rel="stylesheet" href="css/info-mgt.css" />
<link rel="stylesheet" href="css/WdatePicker.css" />
<title>移动办公自动化系统</title>
<style type="text/css">
.sub1 {
	border: 0;
	color: #2A83CF;
}

.sub2 {
	border: 0;
	color: red;
}
</style>
</head>

<body>
	<div class="title">
		<h2>信息管理</h2>
	</div>
	<div class="query">
		<div class="query-conditions ue-clear">
			<div class="conditions name ue-clear">
				<label>流程名称：</label>
				<div class="select-wrap">
					<div class="select-title ue-clear">
						<span>请选择</span><i class="icon"></i>
					</div>
					<ul class="select-list">
						<li>权限升级审批</li>
						<li>部门更换审批</li>
						<li>辞职流程审批</li>
					</ul>
				</div>
			</div>
			<div class="conditions operate-time ue-clear">
				<label>操作时间：</label>
				<div class="select-wrap">
					<div class="select-title ue-clear">
						<span>大于或等于</span><i class="icon"></i>
					</div>
					<ul class="select-list">
						<li>呵呵</li>
						<li>哈哈</li>
						<li>嘻嘻</li>
					</ul>
				</div>
				<div class="input-box ue-clear">
					<input type="text" /> <span>小时</span>
				</div>
			</div>
			<div class="conditions time ue-clear">
				<label>时&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;间：</label>
				<div class="time-select">
					<input type="text" onfocus="WdatePicker({dateFmt:'yyyy-MM-dd'})"
						placeholder="开始时间" /> <i class="icon"></i>
				</div>
				<span class="line">-</span>
				<div class="time-select">
					<input type="text" onfocus="WdatePicker({dateFmt:'yyyy-MM-dd'})"
						placeholder="开始时间" /> <i class="icon"></i>
				</div>
			</div>
			<div class="conditions staff ue-clear">
				<label>描&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;述：</label> <input
					id="my" type="text" placeholder="简要描述流程" />
				<!--             <a href="javascript:;" class="staff-select">选择</a> -->
			</div>
		</div>
		<div class="query-btn ue-clear">
			<a href="javascript:;" class="confirm">添加流程</a> <a
				href="javascript:;" class="clear">清空条件</a>
		</div>
	</div>
	<div class="table-operate ue-clear">
		<a href="javascript:;" class="add">添加</a> <a href="javascript:;"
			class="del">删除</a> <a href="javascript:;" class="edit">编辑</a> <a
			href="javascript:;" class="count">统计</a> <a href="javascript:;"
			class="check">审核</a>
	</div>
	<div class="table-box">
		<table>
			<thead>

				<tr>
					<th class="num">工号</th>
					<th class="name">姓名</th>
					<th class="node">部门</th>
					<th class="process">流程</th>
					<th class="process">流程描述</th>
					<th class="time">发起时间</th>
					<th class="status">状态</th>
					<th class="operate">操作</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${processes }" var="p">
					<form action="processAction_submitOrCancel" method="post">
						<tr>
							<input name="process.id" value="${p.id }" hidden="hidden" />
							<input name="process.proLevel" value="${p.proLevel }"
								hidden="hidden" />
							<input name="process.proStatus" value="${p.proStatus }"
								hidden="hidden" />
							<td class="num">${p.employee.jobnum }</td>
							<td class="name">${p.employee.uname }</td>
							<td class="name">${p.employee.department.dname }</td>
							<td class="process">${p.proName }</td>
							<td class="node">${p.proDes }</td>
							<td class="time">${p.proDate }</td>
							<c:choose>
								<c:when test="${p.proStatus==0 }">
									<td class="status">未发起</td>
								</c:when>
								<c:when test="${p.proStatus==1 }">
									<td class="status">已发起</td>
								</c:when>
								<c:when test="${p.proStatus==2 }">
									<td class="status">已经过一级审批</td>
								</c:when>
								<c:when test="${p.proStatus==3 }">
									<td class="status">已完成</td>
								</c:when>
								<c:when test="${p.proStatus==4 }">
									<td class="status">被驳回</td>
								</c:when>
							</c:choose>

							<td><c:if test="${emp.role.rid==1 }">
									<c:if test="${p.proStatus==0 || p.proStatus==4 }">
										<input type="submit" name="flag" class="sub1" value="发起" />
										<span>&nbsp;&nbsp;&nbsp;</span>
									</c:if>
									<c:if
										test="${p.proStatus!=3 && p.proStatus!=0 && p.proStatus!=4}">
										<input type="submit" name="flag" class="sub2" value="取消" />
									</c:if>
								</c:if> <c:if test="${emp.role.rid>=2 }">
									<input type="submit" name="flag" class="sub1" value="提交" />
									<span>&nbsp;&nbsp;&nbsp;</span>
									<input type="submit" name="flag" class="sub2" value="驳回" />
								</c:if></td>
						</tr>
					</form>
				</c:forEach>
			</tbody>
		</table>
	</div>
                            <div align="center">
							<c:if test="${pageIndex>1 }">
								
								<a href="processAction_findProcess?pageIndex=${pageIndex-1 }" style="color: blue;">上一页</a> 
								</c:if>
								<b>第${pageIndex}页,共${allPage }页</b>
								<c:if test="${pageIndex<allPage }">
								
								<a href="processAction_findProcess?pageIndex=${pageIndex+1 }" style="color: blue;">下一页</a>
								</c:if>
							</div>
</body>
<script type="text/javascript" src="js/jquery.js"></script>
<script type="text/javascript" src="js/common.js"></script>
<script type="text/javascript" src="js/WdatePicker.js"></script>
<script type="text/javascript" src="js/jquery.pagination.js"></script>
<script type="text/javascript">
	var txt;
	$("a[class=confirm]").click(
			function() {
				var des = $("#my").val();
				if (txt == null) {
					alert("不能为空")
				} else {
					confirm("确认添加?")
					location.href = "processAction_addProcess?processName="+ txt + "&processDes=" + des;
				}

			});

	

	$(".select-title").on("click", function() {
		$(".select-list").hide();
		$(this).siblings($(".select-list")).show();
		return false;
	})
	$(".select-list").on(
			"click",
			"li",
			function() {
				 txt = $(this).text();
				$(this).parent($(".select-list")).siblings($(".select-title"))
						.find("span").text(txt);
			})

	/* $('.pagination').pagination(${allRecords}, {
		callback : function(page) {
			location.href="processAction_findProcess?pageIndex="+(page+1); 
		},
		display_msg : true,
		setPageNo : true
	}); */

	$("tbody").find("tr:odd").css("backgroundColor", "#eff6fa");

	showRemind('input[type=text], textarea', 'placeholder');
</script>
</html>
