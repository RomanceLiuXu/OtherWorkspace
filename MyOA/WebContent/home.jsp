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
<link rel="stylesheet" href="css/home.css" />
<title>移动办公自动化系统</title>
<style type="text/css">
	.css1{
		color: red;
		font-size: 20px;
	}
	.css2{
		color: blue;
		font-size: 20px;
	
	}
	.css3{
		color: green;
		font-size: 20px;	
	}
	.css4{
		color: darkorange;
		font-size: 15px;
	}
</style>
</head>

<body>
<div class="article toolbar">
	<div class="title ue-clear">
    	<h2>常用工具</h2>
        <a href="javascript:;" class="more">更多</a>
    </div>
    <div class="content">
    	<ul class="toollist ue-clear">
    		<li>
            	<a href="javascript:;" class="img"><img src="images/icon01.png" /></a>
                <p><a href="javascript:;">通知公告</a></p>
            </li>
            <li>
            	<a href="javascript:;" class="img"><img src="images/icon02.png" /></a>
                <p><a href="javascript:;">知识库</a></p>
            </li>
            <li>
            	<a href="javascript:;" class="img"><img src="images/icon03.png" /></a>
                <p><a href="javascript:;">密码修改</a></p>
            </li>
            <li>
            	<a href="javascript:;" class="img"><img src="images/icon04.png" /></a>
                <p><a href="javascript:;">日程安排</a></p>
            </li>
            <li>
            	<a href="javascript:;" class="img"><img src="images/icon05.png" /></a>
                <p><a href="javascript:;">添加文章</a></p>
            </li>
            <li>
            	<a href="javascript:;" class="img"><img src="images/icon06.png" /></a>
                <p><a href="javascript:;">网络硬盘</a></p>
            </li>
            <li>
            	<a href="javascript:;" class="img"><img src="images/icon07.png" /></a>
                <p><a href="javascript:;">参数信息</a></p>
            </li>
            <li>
            	<a href="javascript:;" class="img"><img src="images/icon08.png" /></a>
                <p><a href="javascript:;">回收站</a></p>
            </li>
            <li>
            	<a href="javascript:;" class="img"><img src="images/icon09.png" /></a>
                <p><a href="javascript:;">系统配置</a></p>
            </li>
            <li class="add-btn">
            	<img src="images/add.png" />
            </li>
    	</ul>
        
    </div>
</div>
<div class="article half notice">
	<div class="wrap-l">
        <div class="title ue-clear">
            <h2>通知公告</h2>
            <a href="javascript:;" class="more">更多</a>
        </div>
        <div class="content">
        	<ul class="notice-list">
            	<li class="ue-clear">
                	<a href="javascript:;" class="notice-title">中国移动关于设立作风建设监督举报电话的公告</a>
                    <div class="notice-time">09-05</div>
                </li>
                <li class="ue-clear">
                	<a href="javascript:;" class="notice-title">关于公示全市中国移动办公生产双主体责任名单的通知</a>
                    <div class="notice-time">09-05</div>
                </li>
                <li class="ue-clear">
                	<a href="javascript:;" class="notice-title">南京市中国移动支付系统安全管理责任人名单</a>
                    <div class="notice-time">09-05</div>
                </li>
                <li class="ue-clear">
                	<a href="javascript:;" class="notice-title">2014年全市通信行业安全生产工作要点</a>
                    <div class="notice-time">09-05</div>
                </li>
                <li class="ue-clear">
                	<a href="javascript:;" class="notice-title">中国移动南京公司关于表彰各位员工的规定</a>
                    <div class="notice-time">09-05</div>
                </li>
            </ul>
        </div>
    </div>
</div>
<div class="article half matter">
	<div class="wrap-r">
        <div class="title ue-clear">
            <h2 class="title-list">
                <ul class="ue-clear">
                    <li class="current"><a href="javascript:;">打卡信息</a></li>
                   <!--  <li><a href="javascript:;">已办事项</a></li> -->
                </ul>
            </h2>
            <a href="javascript:;" class="more">更多</a>
        </div>
        <div class="content">
        	<div class="matter-content current ue-clear">
            	<div class="today">
                	<p class="year">2018年9月</p>
                    <p class="date">3</p>
                </div>
                <ul class="matter-list">
                	<li id="msg" style="margin-top: 20px;">
                  	<!-- <span class="matter-time">05-08</span>  -->
                    <!--  <a href="javascript:;" class="matter-title">下午2点中国移动召开2014年工作会议</a> -->
                      
                 </li> 
<!--                     <li class="ue-clear"> -->
<!--                     	<span class="matter-time">05-08</span> -->
<!--                         <a href="javascript:;" class="matter-title">上交本年度市局工作报告提纲</a> -->
<!--                     </li> -->
<!--                     <li class="ue-clear"> -->
<!--                     	<span class="matter-time">05-08</span> -->
<!--                         <a href="javascript:;" class="matter-title">领取南京政府办公室公务员津贴</a> -->
<!--                     </li> -->
<!--                     <li class="ue-clear"> -->
<!--                     	<span class="matter-time">05-08</span> -->
<!--                         <a href="javascript:;" class="matter-title">南京2014年全国移动技术投标大会报名事宜</a> -->
<!--                     </li> -->
<!--                     <li class="ue-clear"> -->
<!--                     	<span class="matter-time">05-08</span> -->
<!--                         <a href="javascript:;" class="matter-title">参加市政府举办的互动活动并宣传单位</a> -->
<!--                     </li> -->
                </ul>
            </div>
           <!--  <div class="matter-content ue-clear">
            	<div class="today">
                	<p class="year">2018年9月</p>
                    <p class="date">3</p>
                </div>
                <ul class="matter-list">
                </ul>
            </div> -->
        </div>
    </div>
</div>
<div class="article half duty">
	<div class="wrap-l">
        <div class="title ue-clear">
            <h2>管理员信息</h2>
            <a href="javascript:;" class="more">更多</a>
        </div>
        <div class="content">
        	<table>
            	<thead>
                	<tr style="font-size:15px">
                    	<th class="date">工号</th>
                        <th class="week">姓名</th>
                        <th class="leader">部门</th>
                        <th class="contact">邮箱</th>
                        <th class="remark">联系方式</th>
                    </tr>
                </thead>
                <tbody>
                <c:forEach items="${admins }" var="admin">
                	<tr style="font-size:15px">
                    	<td class="date">${admin.jobnum }</td>
                        <td class="week">${admin.uname }</td>
                        <td class="leader">${admin.department.dname }</td>
                        <td class="contact">${admin.email }</td>
                        <td class="remark">${admin.phone }</td>
                    </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
</div>
<div class="article half email">
	<div class="wrap-r">
        <div class="title ue-clear">
            <h2>流程相关</h2>
            <a href="javascript:;" class="more">更多</a>
        </div>
        <div class="content">
        	<table>
			<thead>
				<tr style="font-size:15px">
					<th>工号</th>
					<th>姓名</th>
					<th>部门</th>
					<th>流程</th>
					<th>流程描述</th>
					<th>发起时间</th>
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
							<td class="css4">${p.employee.jobnum }</td>
							<td class="css4">${p.employee.uname }</td>
							<td class="css4">${p.employee.department.dname }</td>
							<td class="css4">${p.proName }</td>
							<td class="css4">${p.proDes }</td>
							<td class="css4">${p.proDate }</td>
						</tr>	
					</form>
				</c:forEach>
			</tbody>
		</table>
        </div>
    </div>
</div>
</body>
<script type="text/javascript" src="js/jquery.js"></script>
<script type="text/javascript" src="js/common.js"></script>
<script type="text/javascript">
$(document).ready(function(){
var date = new Date();
var ym = date.getFullYear()+"年"+(date.getMonth()+1)+"月";
$("p[class=year]").text(ym);
$("p[class=date]").text(date.getDate());
checkSignIn();
});

function checkSignIn() {
   	$.ajax({
   		type:"post",
   		url:"attendAction",
   		async:true,
   		success:function (data) {
   			if(data==0){
   				 $("#msg").addClass("css1");
   				$("#msg").text("今日还未打卡，快去签到哦");
   			}else if(data==1){
   				$("#msg").addClass("css2");
   				$("#msg").text("今日已打卡一次，还差一次");
   			}else if(data >=2){
   				$("#msg").addClass("css3");
   				$("#msg").text("今日已打卡两次，完美的一天，继续保持");
   			}
   		}
   	});
   }




$(".title-list ul").on("click","li",function(){
	var aIndex = $(this).index();
	$(this).addClass("current").siblings().removeClass("current");
	$(".matter-content").removeClass("current").eq(aIndex).addClass("current");
});

$(".duty").find("tbody").find("tr:even").css("backgroundColor","#eff6fa");
</script>
</html>
