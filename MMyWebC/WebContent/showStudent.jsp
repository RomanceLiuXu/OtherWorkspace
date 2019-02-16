<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<!-- start: Meta -->
<meta charset="utf-8">
<title>所有学员</title>

<!-- end: Meta -->

<!-- start: Mobile Specific -->
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- end: Mobile Specific -->

<!-- start: CSS -->
<link id="bootstrap-style" href="css/bootstrap.min.css" rel="stylesheet">
<link href="css/bootstrap-responsive.min.css" rel="stylesheet">
<link id="base-style" href="css/style.css" rel="stylesheet">
<link id="base-style-responsive" href="css/style-responsive.css"
	rel="stylesheet">
<link
	href='http://fonts.googleapis.com/css?family=Open+Sans:300italic,400italic,600italic,700italic,800italic,400,300,600,700,800&subset=latin,cyrillic-ext,latin-ext'
	rel='stylesheet' type='text/css'>
<!-- end: CSS -->

</head>

<body>
	<!-- start: Header -->
	<div class="navbar">
		<div class="navbar-inner">
			<div class="container-fluid">
				<a class="btn btn-navbar" data-toggle="collapse"
					data-target=".top-nav.nav-collapse,.sidebar-nav.nav-collapse">
					<span class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
				</a> <a class="brand" href="#"><span>蓝鸥学员管理系统</span></a>
				<!-- start: Header Menu -->
				<div class="nav-no-collapse header-nav">
					<ul class="nav pull-right">
						<!-- start: User Dropdown -->
						<li class="dropdown"><a class="btn dropdown-toggle"
							data-toggle="dropdown" href="#"> <i
								class="halflings-icon white user"></i>${user.name}<span
								class="caret"></span>
						</a>
							<ul class="dropdown-menu">
								<li class="dropdown-menu-title"><span>账户设置</span></li>
								<li><a href="LogOutAction"><i
										class="halflings-icon off"></i> 退出登录</a></li>
							</ul></li>
						<!-- end: User Dropdown -->
					</ul>
				</div>
			</div>
		</div>
	</div>
	<!-- start: Header -->

	<div class="container-fluid-full">
		<div class="row-fluid">
			<!-- start: Content -->
			<div id="content" class="span10">
				<div class="row-fluid sortable">
					<div class="box span12">
						<div class="box-header" data-original-title>
							<h2>
								<i class="halflings-icon white user"></i><span class="break"></span>所有学员
							</h2>
							<div style="margin-top: -8px" align="right">
							  <form action="showStudent.jsp">
								<input type="text" class="form-control" name="key">
								<input type="submit" value="搜索" style="margin-top: -8px">
								<input type="button" onclick="window.location.replace('addStudent.jsp')" value="添加" style="margin-top: -8px">
							  </form>
							</div>
						</div>
						<div class="box-content">
							<table
								class="table table-striped table-bordered bootstrap-datatable ">
								<thead>
									<tr>
										<th>姓名</th>
										<th>性别</th>
										<th>数学</th>
										<th>英语</th>
										<th>语文</th>
										<th>操作</th>
									</tr>
								</thead>
								<tbody>	
								<!-- 在stus中遍历，每次遍历得到的结果名为student -->
								<c:forEach var="student" items="${students}">
								<tr>
											<td>${student.name }</td>
											<td class="center">${student.sex }</td>
											<td class="center">${student.math }</td>
											<td class="center">${student.english }</td>
											
											
											<td class="center">${student.chinese }</td>
										
											
											<td class="center">
											 <a class="btn btn-info" href="signup.jsp?id=#"> <i class="halflings-icon white edit"></i></a> 
											 <a class="btn btn-danger" onclick="return confirm('确认删除吗?')" href="deleteServlet?id=#" > <i class="halflings-icon white trash"></i></a>
											 </td>
										</tr>
								</c:forEach>
								</tbody>
							</table>
							<div align="center">
							<c:if test="${index>1 }">
								
								<a href="showStudent?index=${index-1 }&key=${key}">上一页</a> 
								</c:if>
								<b>第${index}页,共${allPage }页</b>
								<c:if test="${index<allPage }">
								
								<a href="showStudent?index=${index+1 }&key=${key}">下一页</a>
								</c:if>
							</div>

						</div>
					</div>
					<!--/span-->

				</div>
				<!--/row-->
			</div>
		</div>
	</div>
	<!--/fluid-row-->
	<div id="main"  style="width: 100%;height:400px; background-color: white;"></div>
	
	<div class="clearfix"></div>


    
	<footer>
	<p>
		<span style="text-align: left; float: left">&copy; 2017 <a
			href="#">开发小组:甲骨文 成员: 杨xx 王xx 刘xx</a></span>
	</p>

	</footer>

	<!-- start: JavaScript-->

	<script src="js/jquery-1.9.1.min.js"></script>
	<script src="js/bootstrap.min.js"></script>
	<script src="js/echarts.min.js"></script>
</body>
</html>