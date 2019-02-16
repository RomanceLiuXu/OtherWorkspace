<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@  taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<%
	String path = request.getContextPath();
	//协议://+IP:+端口号+/+工程名+/
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<html>

<head>
<meta charset="utf-8" />
<title>同城匹配</title>

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
	float: left;
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
<link rel="stylesheet" type="text/css"
	href="<%=basePath%>css/threeParty_bf3b4b1.css" />
<link rel="stylesheet" type="text/css" href="<%=basePath%>css/zzsc.css" />
<link rel="stylesheet" href="<%=basePath%>css/txt.wav.css" />
<link rel="stylesheet" type="text/css"
	href="<%=basePath%>css/swiper.css" />
<link rel="stylesheet" type="text/css" href="<%=basePath%>css/css1.css" />
<link rel="stylesheet" type="text/css" href="<%=basePath%>css/css2.css" />
<link rel="stylesheet" type="text/css" href="<%=basePath%>css/css3.css" />
</head>

<body>
	<div class="skin-header"></div>
     <c:forEach items="${us }" var = "uu">
     <div>${uu.uid }</div>
     </c:forEach>
	<section class="mod-brief-info bgff radius-3 bord"
		style="background: url(<%=basePath%>img/a.jpeg); background-size: cover; heigh: auto;">
		<div class="txtwav vibe"
			style="width: 1200px; height: 100px; font-size: 20px; color: red; line-height: 100px;">
			恋爱与你只差一个点击：</div>
		<section id="jcDayLovePub" class="pub-user">
			<div class="user-list">
				<ul class="clearfix" id="qingYuanRecommend">
	           <c:forEach items="${list }"  var="user">
									<li id="${user.uid }" class="showFlag fadeFromLeft">
									<div class="user-item front clearfix">
										<div class="photo">
											<a><img src="${user.paddress }"></a>
										</div>
										<div class="user-info">
											<h3>
												<a class="name">${user.name }</a> <a class="flag-zx"></a><a class="flag-mobile"> </a><a class="flag-iden"></a><a class="flag-credit credit-js">满分</a>
											</h3>
											<p class="base">${user.age },${user.address },</p>
											<p class="heart-word">正在寻找：。。。。。。</p>
											<p class="user-point">推荐理由：TA刚注册珍爱，先到先得哦</p>
										</div>
									</div>
								</li>
								</c:forEach>
				</ul>

			</div>
		</section>
	</section>
	<div class="hot-city"center; padding: 20px;>
		<div class="city-wrap frameW">
			<div class="city-list clearfix">
				城市征婚： <a target="_blank" href="http://city.zhenai.com/beijing">北京</a>
				<a target="_blank" href="http://city.zhenai.com/shanghai">上海</a> <a
					target="_blank" href="http://city.zhenai.com/guangzhou">广州</a> <a
					target="_blank" href="http://city.zhenai.com/shenzhen">深圳</a> <a
					target="_blank" href="http://city.zhenai.com/nanjing">南京</a> <a
					target="_blank" href="http://city.zhenai.com/chongqing">重庆</a> <a
					target="_blank" href="http://city.zhenai.com/wuhan">武汉</a> <a
					target="_blank" href="http://city.zhenai.com/chengdu">成都</a> <a
					target="_blank" href="http://city.zhenai.com/hangzhou">杭州</a> <a
					target="_blank" href="http://city.zhenai.com/changsha">长沙</a> <a
					target="_blank" href="http://city.zhenai.com/xian">西安</a> <a
					target="_blank" href="http://city.zhenai.com/dongguan">东莞</a> <a
					target="_blank" href="http://city.zhenai.com/foshan">佛山</a> <a
					target="_blank" href="http://city.zhenai.com/suzhou">苏州</a> <a
					target="_blank" href="http://city.zhenai.com/tianjin">天津</a> <a
					target="_blank" href="http://city.zhenai.com/kunming">昆明</a> <a
					target="_blank" href="http://city.zhenai.com/shenyang">沈阳</a> <a
					target="_blank" href="http://city.zhenai.com/jinan">济南</a> <a
					target="_blank" href="http://city.zhenai.com/changchun">长春</a> <a
					target="_blank" href="http://city.zhenai.com/taiyuan">太原</a> <a
					target="_blank" href="http://city.zhenai.com/hefei">合肥</a> <a
					target="_blank" href="http://city.zhenai.com/guiyang">贵阳</a> <a
					target="_blank" href="http://city.zhenai.com/fuzhou">福州</a> <a
					target="_blank" href="http://city.zhenai.com">[更多城市]</a>
			</div>
		</div>
	</div>
	<footer class="footer showFlag fadeFromBottom">
		<div class="frameW clearfix">
			<div class="about">
				<div class="quick">
					<a target="_blank" href="http://about.zhenai.com/">关于我们</a>| <a
						target="_blank" href="http://contact.zhenai.com/">联系我们</a>| <a
						target="_blank" href="http://zhenai.zhiye.com/">加入我们</a>| <a
						target="_blank" href="http://about.zhenai.com/huoban"
						rel="nofollow">合作伙伴</a>| <a target="_blank"
						href="http://profile.zhenai.com/personal/getguestbookbegin.jsps"
						rel="nofollow">意见反馈</a>| <a
						href="http://www.zhenai.com/sitemap.html" target="_blank">网站地图</a>
					| <a href="http://www.zhenai.com/ahelpcenter/index.jsp"
						target="_blank">帮助中心</a>| <a href="http://album.zhenai.com"
						target="_blank">珍爱会员</a>| <a href="http://city.zhenai.com/"
						target="_blank">珍爱相亲</a>| <a
						href="http://register.zhenai.com/register/serverrulenew.jsp"
						target="_blank">珍爱网服务协议</a>| <a
						href="http://register.zhenai.com/register/intimacy.jsp"
						target="_blank">个人信息保护政策</a>
				</div>
				<div class="brand grayL">
					<span>品牌：12年专业婚恋服务</span>&nbsp;&nbsp;<span>专业：庞大的资深红娘队伍</span>&nbsp;&nbsp;<span>真实：诚信会员验证体系</span>
				</div>
				<div class="contact grayL">
					<span>客服热线：4001-520-520（周一至周日：9:00-21:00）</span><span>客服信箱：kefu@zhenai.com</span>
				</div>
				<div class="contact grayL">
					<span><a style="color: #9f9f9f;"
						href="http://profile.zhenai.com/v2/sys/reportEntry.do"
						target="_blank" rel="nofollow">违法和不良信息举报</a></span>&nbsp;&nbsp;<span>违法和不良信息举报专线：4008829288</span>&nbsp;&nbsp;<span>举报信箱：<a
						style="color: #9f9f9f;" href="mailto:jubao@zhenai.com"
						class="underlines" rel="nofollow">jubao@zhenai.com</a></span>
				</div>
			</div>
			<div class="copyright grayL">
				<p>Copyright © 2005-2018 版权所有：深圳市珍爱网信息技术有限公司</p>
				<p>
					增值电信业务经营许可证：粤B2-20040382 <a target="_blank"
						href="http://www.miitbeian.gov.cn">粤ICP备09157619号-1</a>
					乙测资字4410775 <a target="_blank"
						href="http://www.beian.gov.cn/portal/registerSystemInfo?recordcode=44030502000534"
						class="gongwang"><img
						src="http://images.zastatic.com/zhenai3/zhenai2015/img/myhome/gongan.png"
						alt=""></a> 粤公网安备 4403050200 0534号
				</p>
				<div class="out-link" id="foot_link">
					<a title="网文证"
						href="http://sq.ccm.gov.cn:80/ccnt/sczr/service/business/emark/toDetail/7C7C3F8EFF5648A2950931B65DF13B87"
						class="link10" target="_blank" rel="nofollow"> <img
						src="http://i2.zastatic.com/zhenai3/zhenai2015/img/myhome/wen_bc81e4f.png"
						alt="">
					</a> <a target="_blank" title="深圳网监备案"
						href="http://szcert.ebs.org.cn/6398bd09-b195-4fd9-a010-e1fea403a766"
						class="link5" rel="nofollow"></a> <a title="深圳举报中心"
						href="http://szwljb.gov.cn/" class="link6" target="_blank"
						rel="nofollow"></a> <a title="违法和不良信息举报中心"
						href="http://www.12377.cn/" class="link3" target="_blank"
						rel="nofollow"></a> <a title="诚信示范网站"
						href="https://search.szfw.org/cert/l/CX20150630010588010670"
						class="link4" target="_blank" rel="nofollow"></a> <a
						title="AAA级信用企业"
						href="http://www.itrust.org.cn/Home/Index/itrust_certifi?wm=1761973720"
						class="link7" target="_blank" rel="nofollow"></a>
				</div>
			</div>
		</div>
	</footer>
</body>
<script src="<%=basePath%>js/jquery-2.2.4.min.js" type="text/javascript"></script>
<script type="text/javascript" src="<%=basePath%>js/txt.wav.min.js"></script>
<script type="text/javascript">
	// 获取id
	//var id = location.href.split("?")[1].split("=")[1];
	// 获取ul标签
	var ul = document.querySelector("ul");
	//请求接口
	for (var i = 0; i < ul.getElementsByTagName("li").length; i++) {
		ul.children[i].onclick = function(res) {
			console.log(res);
			var uuid = res.path[4].id;
			location.href = "<%=basePath%>home_personal?uid="+uuid; 
		}
	}
</script>

</html>