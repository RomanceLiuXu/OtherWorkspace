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
	</head>

	<body>
		<div align="center" style="font-size: 25px;">
			
			<table border="4px" bordercolor="cornflowerblue" width="60%" cellpadding="15px" style="border-collapse: collapse;text-align: center;font-size: 15px;">
				<option align="center">员工通讯录</option>
				<!-- 点击部门按钮后跳转到通过部门名称查找所有员工的接口findDeptAction -->
			<form action="findMessageAction" method="post"> 
					<input type="text" value="" name="dname" hidden="hidden"/>
					<c:forEach items="${departments }" var="dept">
					<input type="submit" name="dept" value="${dept.dname }" style="background-color: dodgerblue;font-size: 20px;border-radius: 10px;"/>
				    </c:forEach>
				</form>
				<form action="findEmpsByNameAction" method="post"> 
				<input type="text" name="emp.uname" placeholder="请输入姓名"/><input type="submit" value="查找"/>
				</form>
			    <thead>
					<tr>
						<th>工号</th>
						<th>姓名</th>
						<th>手机</th>
						<th>邮箱</th>
					</tr>
				</thead>
				<tbody>
				<c:forEach items="${employees }" var="employee">
					<tr>
						<td>${employee.jobnum }</td>
						<td>${employee.uname }</td>
						<td>${employee.phone }</td>
						<td>${employee.email }</td>
					</tr>
				</c:forEach>
				</tbody>
			</table>
		
		 &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;  &nbsp; &nbsp; &nbsp; &nbsp;  &nbsp; &nbsp; &nbsp; &nbsp;  &nbsp; &nbsp; &nbsp; 
		<div align="center" style="font-size: 20px; width: 300px; display: inline-block;">
		<c:if test="${pageIndex>1 }">
		<a href="findMessageAction?dname=${dname }&pageIndex=${pageIndex-1 }">上一页</a>
		</c:if>
		<b>第${pageIndex }页,共${allPage }页</b>
		<c:if test="${pageIndex<allPage }">
		<a href="findMessageAction?dname=${dname }&pageIndex=${pageIndex+1 }">下一页</a>
		</c:if>
		</div>
		 &nbsp; &nbsp; &nbsp; &nbsp;  &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;
		<div style="display: inline-block;">
			<a href=http://localhost:8080/MyOA/phone.xls><button style="background-color:dodgerblue;font-size: 15px;border-radius: 5px;">导出到本地</button></a>
		</div>
		</div>
	</body>
	<script src="js/jquery-2.2.4.min.js" type="text/javascript"></script>
	<script type="text/javascript">
	//获取所有部门的标签节点
			var inputs = $("input[name='dept']");
	//设置点击事件
			inputs.click(function() {
				//给当前点击的部门按钮设置样式
				$(this).css('background-color','cornflowerblue');
				console.log($(this).val());
				//将当前点击的按钮的部门名称设置给隐藏的input以便后台获取
				$("input[name='dname']").val($(this).val());
				console.log("我是前端，传的部门名称为："+$("input[name='dname']").val());
				return true;
			});
		</script>
</html>