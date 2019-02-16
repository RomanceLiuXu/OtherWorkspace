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
		<meta charset="utf-8">
		<meta name="viewport" content="maximum-scale=1.0,minimum-scale=1.0,user-scalable=0,width=device-width,initial-scale=1.0" />
		<meta name="format-detection" content="telephone=no">
		<title>签到</title>
		<link rel="stylesheet" href="css/public.css" />
		<link rel="stylesheet" href="css/signin.css" />
	</head>

	<body>
		<div class="top flex flex-align-end flex-pack-center flex-warp">
			<div class="out-1 flex flex-align-center flex-pack-center" id="signIn">
				<div class="out-2 flex flex-align-center flex-pack-center">
					<div class="signBtn">
						<strong id="sign-txt">打卡</strong>
						<span>今日打卡<em id="sign-count">0</em>次</span>
					</div>
				</div>
			</div>
		</div>
		<div class="tips">今日已打卡，继续加油</div>
		<small style="float: right;color: forestgreen;">打卡时间7:00-9:00&nbsp;&nbsp;&nbsp;18:00-20:00</small>
		<div class="Calendar">
			<div id="toyear" class="flex flex-pack-center">
				<div id="idCalendarPre">&lt;</div>
				<div class="year-month">
					<span id="idCalendarYear">2018</span>年<span id="idCalendarMonth">6</span>月
				</div>
				<div id="idCalendarNext">&gt;</div>
			</div>
			<table border="1px" cellpadding="0" cellspacing="0">
				<thead>
					<tr class="tou">
						<td>日</td>
						<td>一</td>
						<td>二</td>
						<td>三</td>
						<td>四</td>
						<td>五</td>
						<td>六</td>
					</tr>
				</thead>
				<tbody id="idCalendar">
				</tbody>
			</table>
			<div id=""  style="width: 100%; height: 5px; background: #007AFF; margin-top: 20px;" ></div>
			<table border="2px" cellpadding="15px" style="border-collapse: collapse;font-size: 20px;">
				<div style="text-align: center;"><button style="color: green;" class="siglerecords">个人考勤</button>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<button style="color: red;" class="allrecords">全部人员考勤</button></div>
				<tr>
				<th>工号</th>
				<th>姓名</th>
				<th>部门</th>
				<th>打卡时间</th>
				</tr>
				<tbody>
				<c:forEach items="${records }" var="record">
					<tr>
						<td>${record.jobnum }</td>
						<td>${record.employee.uname }</td>
						<td>${record.employee.department.dname }</td>
						<td style="color: blue;">${record.createTime }</td>
					</tr>
				</c:forEach>	
				</tbody>
				</table>
		</div>
		<script src="js/jquery-2.2.4.min.js" type="text/javascript" charset="utf-8"></script>
		<script type="text/javascript" src="js/rili.js"></script>
		<script language="JavaScript">
			var isSign = false;
			var myday = new Array(); //已签到的数组
//			myday[0] = "1528646400"
//			myday[1] = "1528387200"
//			myday[2] = "1525708800"
            $(document).ready(function () {
            	<c:if test="${emp.role.rid<=1 }">
            	  $("button[class=allrecords]").css("display","none");
   			</c:if>
           	checkSignIn();
           });
			
			
            $("button[class=allrecords]").click(function () {
               	location.href="attendAction_findAllAttend";
               });
                $("button[class=siglerecords]").click(function () {
               	location.href="attendAction_findSignleAttend";
               });
                
                
           function checkSignIn() {
           	$.ajax({
           		type:"post",
           		url:"attendAction",
           		async:true,
           		success:function (data) {
           			if(data==0){
           				$("#sign-count").text(data);
           				$("div[class=tips]").text("今日还未打卡，请点击打卡");
           				onSignIN();
           			}else if(data==1){
           				cale.SignIn();
           				$("#sign-count").text(data);
           				$("div[class=tips]").text("今日已打卡"+data+"次");
           				onSignIN();	
           			}else if(data >=2){
           				cale.SignIn();
           				$("#sign-count").text(data);
           				$("div[class=tips]").text("今日已打卡"+data+"次，不可再重复打卡");
           			}
           		}
           	});
           }
           
           function onSignIN() {
				var d1 = new Date();
				d1.setFullYear(d1.getFullYear(), d1.getMonth(), d1.getDate());
				d1.setHours(9, 0, 0);
				console.log(d1);

				var d2 = new Date();
				d2.setFullYear(d2.getFullYear(), d2.getMonth(), d2.getDate());
				d2.setHours(12, 0, 0);
				console.log(d2);

				var d3 = new Date();
				d3.setFullYear(d3.getFullYear(), d3.getMonth(), d3.getDate());
				d3.setHours(14, 0, 0);
				console.log(d3);

				var d4 = new Date();
				d3.setFullYear(d4.getFullYear(), d4.getMonth(), d4.getDate());
				d4.setHours(24, 0, 0);
				console.log(d4);
				$("#signIn").click(function() {
					var date = new Date();
					if((date >= d1 && date <= d2) || (date >= d3 && date <= d4)) {
						/* alert("时间正确"); */
						location.href = "attendAction_addAttend";
					}
					else{
						alert("请在规定的时间内打卡");
					}
				});
			};
    
			var cale = new Calendar("idCalendar", {
				qdDay: myday,
				onToday: function(o) {
					o.className = "onToday";
				},
				onSignIn: function (){
// 					$$("sign-txt").innerHTML = '已签到';
				},
				onFinish: function() {
// 					$$("sign-count").innerHTML = myday.length //已签到次数
					$$("idCalendarYear").innerHTML = this.Year;
					$$("idCalendarMonth").innerHTML = this.Month; //表头年份

				}
			});
			$$("idCalendarPre").onclick = function() {
				cale.PreMonth();
			}
			$$("idCalendarNext").onclick = function() {
				cale.NextMonth();
			}
			//添加今天签到
			/* $$("signIn").onclick = function() {
			$.ajax({
            	type:"post",
            	url:"attendAction",
            	async:true,
            	success:function (data) {
            	 var res = cale.SignIn();
            	 $("#sign-count").text(data);
            	}
            }); */
				
//				if(isSign == false) {
//					var res = cale.SignIn();
//					if(res == '1') {
//						$$("sign-txt").innerHTML = '已签到';
//						$$("sign-count").innerHTML = parseInt($$("sign-count").innerHTML) + 1;
//						isSign = true;
//					} else if (res == '2'){
//						$$("sign-txt").innerHTML = '已签到';
//						alert('今天已经签到了')
//						
//					}
//				} else {
//					alert('今天已经签到了')
//				}

			/* } */
		</script>

	</body>

</html>