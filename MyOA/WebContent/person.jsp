<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en">

	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<title>
			学生信息管理平台
		</title>
		<link rel="stylesheet" type="text/css" href="css/person.css" />
		<!--<link href="../Script/jBox/Skins/Blue/jbox.css" rel="stylesheet" type="text/css" />
		<link href="../Style/ks.css" rel="stylesheet" type="text/css" />-->
		<!-- <script src="../Script/jBox/jquery-1.4.2.min.js" type="text/javascript"></script>
		<script src="../Script/jBox/jquery.jBox-2.3.min.js" type="text/javascript"></script>
		<script src="../Script/jBox/i18n/jquery.jBox-zh-CN.js" type="text/javascript"></script>
		<script src="../Script/Common.js" type="text/javascript"></script>
		<script src="../Script/Data.js" type="text/javascript"></script> -->
	</head>
	<body>

		<div class="banner">
		<div class="bgh">
            <div class="page">
            </div>
        </div>
		</div>
		<div class="page">
			<div class="box mtop">
				<div class="leftbox">
				</div>
				<div class="rightbox">

					<h2 class="mbx">我的信息 &gt; 个人资料 &nbsp;&nbsp;&nbsp;</h2>
					<div class="morebt">

						<ul id="ulStudMsgHeadTab">
							<li>
								<a class="tab2" onclick="" href="#">个人资料</a>
							</li>
						</ul>

					</div>
					<div class="cztable">
						<table width="85%" cellpadding="100px" cellspacing="0">
							<tr>
								<td align="right" width="110px">姓名：&nbsp;</td>
								<td width="250px">&nbsp;${emp.uname }</td>
								<td align="right" width="110">工号：&nbsp;</td>
								<td width="200px">&nbsp;${emp.jobnum }</td>
								<td rowspan="9">
									<div align="center">
										<img id="pic_face" height="160" width="120" src="images/photo.jpg" style="padding:2px 2px 5px; border:1px #ddd solid;" />
									</div>&nbsp;
									<div align="center">
									<form action="" method="post" enctype="multipart/form-data">
									    <input type="file" name="myFile"/>
										<input type="submit" value="上传头像" />
									</form>
									</div>
								</td>
							</tr>
							<tr>
								<td align="right">入职时间：&nbsp;</td>
								<td colspan="4" align="left">&nbsp;${emp.hiredate }</td>
							</tr>
							<tr>
								<td align="right">性别：&nbsp;</td>
								<td>&nbsp;${emp.sex }</td>
								<td align="right">权限：&nbsp;</td>
								<td>&nbsp;${emp.role.rname }</td>
							</tr>
							<tr>
								<td align="right">员工地址：&nbsp;</td>
								<td colspan="4" align="left">&nbsp;${emp.address }</td>
							</tr>
							<tr>
								<td align="right">暂定：&nbsp;</td>
								<td>&nbsp;</td>
								<td align="right">暂定：&nbsp;</td>
								<td>&nbsp;</td>
							</tr>
							<tr>
								<td align="right">部门名称：&nbsp;</td>
								<td colspan="4" align="left">&nbsp;${emp.department.dname }</td>
							</tr>
							<tr>
								<td colspan="4" align="left">联系方式（如联系方式有变动请及时修改，以便能及时联系到你。谢谢！）</td>
							</tr>
							<tr>
								<td align="right">邮箱：&nbsp;</td>
								<td>&nbsp;${emp.email }</td>
								<td align="right">手机：&nbsp;</td>
								<td>&nbsp;${emp.phone }</td>
							</tr>
							
						</table>
						<div style="display: inline-block;margin-left: 35%;margin-top: 20px;">
							<a href="updateEmp.jsp"><input type="button" value="编辑资料" style="width: 80px;height: 30px;font-size: 15px;background-color: cornflowerblue;"/></a>
						</div>
						<div style="display: inline-block; margin-left: 10px;margin-top: 20px">
							<a href="updatePsw.jsp"><input type="button" value="修改密码" style="width: 80px;height: 30px;font-size: 15px;background-color: cornflowerblue;"/></a>
						</div>
					</div>

				</div>
			</div>
			<div class="footer">
				<p>
					&copy;copyright 2012 广博教育 csgb.net 版权所有 站长统计</p>
			</div>
		</div>
	</body>

</html>