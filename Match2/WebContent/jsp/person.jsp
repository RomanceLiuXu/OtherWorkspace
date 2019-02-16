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
<meta charset="utf-8" />
<title>个人中心</title>
<style type="text/css">
body {
	width: 1200px;
	background: #f2f2f2;
	margin: auto;
	font: 400 12px/21px "Microsoft Yahei", Arial, Tahoma, \5b8b\4f53;
	color: #5e5e5e;
}

.skin-header {
	width: 100%;
	height: 252px;
	background: url(<%=basePath%>img/skin-header.jpg) top no-repeat;
	background-size: 100%, 100%;
	padding: 0;
	margin-top: 50px;
}

.w1200, .frameW {
	width: 1190px;
	margin: 0 auto;
}

.class1 {
	background-color: whitesmoke;
	width: 94%;
	height: 500px;
	padding: 3%;
}

.class2 {
	width: 150px;
	height: 150px;
	margin-top: 65px;
	display: inline-block;
}
</style>

<link rel="stylesheet"
	href="http://i0.zastatic.com/zhenai3/zhenai2015/css/public_7e4b418.css" />
<link rel="stylesheet"
	href="http://i0.zastatic.com/zhenai3/zhenai2015/css/threePartyPop_161810e.css" />
<link rel="stylesheet"
	href="http://i0.zastatic.com/zhenai3/zhenai2015/css/ablums_408ed0e.css" />
<link rel="stylesheet"
	href="http://i0.zastatic.com/zhenai3/zhenai2015/css/zx_member/love_gen_layer_00bf5d7.css" />
<link rel="stylesheet"
	href="http://i0.zastatic.com/zhenai3/zhenai2015/css/threeParty_bf3b4b1.css" />
<link rel="stylesheet" type="text/css" href="<%=basePath%>css/zzsc.css" />
<link rel="stylesheet" href="<%=basePath%>css/txt.wav.css" />
<link rel="stylesheet" type="text/css"
	href="<%=basePath%>css/swiper.css" />
</head>

<body>
	<div class="skin-header"></div>
	<section class="mod-brief-info bgff radius-3 bord">
		<div class="photo-album fl ">
			<div class="u-ablums-player ">
				<div class="u-ablums-play " id="AblumsPlayID ">
					<div id="AblumsDisplayImgID " class="u-ablums-display-img "
						style="width: 300px; height: 300px; left: 50%; top: 50%; margin-left: -150px; margin-top: -150px;">
							<img class="img " alt="图片地址 " style="opacity: 1; width: 300px; height: 300px;" src="<%=basePath %>${userP.picture.paddress }">
					</div>
				</div>
				<div class="txtwav vibe"
					style="text-align: center; line-height: 50px; color: firebrick;">
					<span>推</span><span>荐</span><span>理</span><span>由</span><span>：</span><span>赶</span><span>紧</span><span>抢</span><span>先</span><span>手</span><span>，</span><span>T</span><span>A</span><span>才</span><span>刚</span><span>注</span><span>册</span><span>，</span><span>是</span><span>个</span><span>新</span><span>人</span>
				</div>
			</div>
		</div>
		<div class="brief-center p20 ">
			<table class="brief-table ">
					<tbody id="tb">
						<tr>
							<td>姓名：${userP.name }</td>
							<td>年龄：${userP.age }</td>
						</tr>
						<tr>
							<td>性别：${userP.sex }</td>
							<td>地址：${userP.address }</td>
						</tr>
					</tbody>
			</table>
		</div>
		<div class="brief-bottom ">
			<div class="brief-group p40 ">

				<a class="btnR2 mr10 sendMailBtn " href="javascript:; ">发邮件</a> <a
					class="btnP2 mr10 salutationBtn " href="javascript:; ">打招呼</a> <a
					class="btnP2 mr10 askBtn " href="javascript:; ">问问题</a> <a
					class="btnP2 mr10 contactBtn " href="javascript:; ">委托红娘</a>

			</div>

			<div class="icon-group ">

				<a id="attention " href="javascript:; "
					class="tp-icon tp-icon-watch ">关注</a> <a id="gift "
					href="javascript:; " class="tp-icon tp-icon-gift ">送礼物</a> <a
					id="chat " href="javascript:; " class="tp-icon tp-icon-chat ">在线聊天</a>
				<a id="intelligence " href="javascript:; "
					class="tp-icon tp-icon-news "> 情敌动态</a> <a id="complaint "
					href="javascript:; " class="tp-icon tp-icon-report ">举报/拉黑</a>

			</div>
			<div class="txtwav vibe"
				style="height: 100px; margin-top: 50px; font-size: 20px; line-height: 100px; text-align: center; color: darkorange;">
				<span>此</span><span>为</span><span>珍</span><span>爱</span><span>网</span><span>特</span><span>约</span><span>用</span><span>户</span><span>，</span><span>敬</span><span>请</span><span>持</span><span>续</span><span>关</span><span>注</span>
			</div>
		</div>
	</section>

</body>
<script type="text/javascript" src="<%=basePath%>js/txt.wav.min.js"></script>
<script type="text/javascript"
	src="<%=basePath%>js/jquery-2.2.4.min.js"></script>
<script type="text/javascript">
	// 		var tb = document.getElementById("tb");
	// 		var useid = location.href.split("?")[1].split("=")[1];

	/* 		//请求接口
	 $.ajax({
	 type: "get",
	 url: "per",
	 async: true,
	 data: {
	 uid: useid
	 },
	 success: function(res) {
	 //解析json串
	 var result = eval("(" + res + ")");
	 console.log(result);
	 //获取json串中的数据
	 var name = result.user.name;
	 var address = result.user.address;
	 var sex = result.user.sex;
	 var age = result.user.age;
	 var uid = result.user.uid;
	 var pname = result.picture.pname;
	 var paddress = result.picture.paddress;
	 //创建标签tr
	 var tr1 = document.createElement("tr");
	 var tr2 = document.createElement("tr");
	 // 创建标签td并添加内容
	 var tdname = document.createElement("td");
	 tdname.innerText = "姓名：" + name;
	 var tdage = document.createElement("td");
	 tdage.innerText = "年龄：" + age;
	 tr1.appendChild(tdname);
	 tr1.appendChild(tdage);
	 var tdsex = document.createElement("td");
	 tdsex.innerText = "性别：" + sex;
	 var tdadress = document.createElement("td");
	 tdadress.innerText = "地址：" + address;
	 tr2.appendChild(tdsex);
	 tr2.appendChild(tdadress);
	 tb.appendChild(tr1);
	 tb.appendChild(tr2);

	 var img = document.querySelector("img");
	 img.src = paddress; */

	// 			}
	// 		});
</script>

</html>