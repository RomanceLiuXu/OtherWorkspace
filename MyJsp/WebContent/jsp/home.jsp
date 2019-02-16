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
<title>首页</title>
<link rel="stylesheet" type="text/css" href="<%=basePath%>css/css1.css" />
<link rel="stylesheet" type="text/css" href="<%=basePath%>css/css2.css" />
<link rel="stylesheet" type="text/css" href="<%=basePath%>css/css3.css" />
</head>

<body>
	<a name="aa"></a>
	<!--头部-->
	<header id="jcZAHeader" class="header rootHeader"
		style="background: rgb(242, 242, 242);">
		<section class="frameW top-bar clearfix">
			<a class="logo" href="" title="珍爱网"><i></i></a>
			<p class="ad-word">相亲无难事，珍爱有红娘</p>
			<div class="tools">
				<ul class="clearfix">
					<li class="mobile"><a href="http://mo.zhenai.com"
						target="_blank" title="珍爱网app下载">手机版</a>
						<div class="mobile-qrcode" style="display: none;">
							扫一扫下载客户端<i></i>
						</div></li>
					<li class="collect"><a href="javascript:;">收藏本站</a></li>
					<li class="cust"><a href="javascript:;">在线客服</a></li>
					<li><a href="http://www.zhenai.com/anquan/" target="_blank">安全中心</a>
					</li>
					<li><a href="javascript:;" class="help-center" target="_blank"
						rel="nofollow">帮助中心</a></li>
					<li class="tel">红娘热线：4001-520520</li>
				</ul>
			</div>
		</section>
		<section class="nav-bar"
			style="position: relative; top: auto; width: auto; opacity: 1;">
			<div class="frameW clearfix">
				<menu class="menu">
					<ul id="a">
						<li id="jcMenuBeauty" class="bg-scroll"
							style="display: list-item; left: 0px;"></li>
						<li><a id="home" rel="nofollow">首页</a></li>
						<li><a id="search" rel="nofollow">同城匹配</a></li>
						<li><a id="search2" target="_blank"> 异城匹配 </a></li>
						<li><a
							href="http://profile.zhenai.com/zhenaiMail/zhenaiMail.jsps"
							rel="nofollow">珍心会员</a></li>
						<li><a href="http://story.zhenai.com/" target="_blank">成功故事</a>
						</li>
						<li><a id="person" rel="nofollow">个人中心</a></li>

						<li><a
							href="http://profile.zhenai.com/activity/activityIndex.jsps?ddid=kt"
							target="_blank" rel="nofollow">活动</a></li>

						<li id="gamecenter"><a id="exit" target="_blank"
							rel="nofollow">退出</a></li>

					</ul>
				</menu>
				<div class="header-info user-info">
					<span class="topic"><em class="user-icon"></em></span>
					<ul>
						<li><a
							href="http://profile.zhenai.com/v2/userdata/showInfo.do"
							rel="nofollow">编辑资料</a></li>
						<li><a
							href="http://profile.zhenai.com/v2/verify/verifyIndex.do"
							rel="nofollow">诚信认证</a></li>
						<li><a
							href="http://profile.zhenai.com/v2/photo/photoIndex.do"
							rel="nofollow">个人相册</a></li>
						<li><a
							href="http://profile.zhenai.com/v2/userdata/pwdIndex.do"
							rel="nofollow">系统设置</a></li>
						<li class="quit"><a
							href="http://profile.zhenai.com/v2/login/logout.do"
							rel="nofollow">退出</a></li>
					</ul>
				</div>
				<div class="header-info message-info" id="jcMessageInfo">
					<span class="topic"><em class="message-icon"><span
							class="num-tips">5</span></em> </span>
					<ul>
						<li><a href="http://profile.zhenai.com/v2/mail/list.do"
							rel="nofollow">邮件<span class="num-tips">5</span></a></li>
						<li><a href="http://profile.zhenai.com/v2/msg/msgIndex.do"
							rel="nofollow">消息</a></li>
						<li><a
							href="http://profile.zhenai.com/v2/follow/index.do?type=1"
							rel="nofollow">关注</a></li>
						<li><a href="http://profile.zhenai.com/v2/visit/index.do"
							rel="nofollow">谁看过我</a></li>
						<li><a href="http://profile.zhenai.com/v2/notice/index.do"
							rel="nofollow">系统通知</a></li>
						<li><a
							href="http://profile.zhenai.com/v2/intercourse/intercourseIndex.do"
							rel="nofollow">交往对象</a></li>

					</ul>
				</div>

			</div>
		</section>
	</header>
	<!--内容区域-->
	<article class="myhome-wrap frameW clearfix">
		<!--轮播-->
		<div id="j-banner-slide" class="g-slide">
			<ul class="ck-slide-wrapper">

				<li>
					<section class="myhome-banner">

						<a href="http://profile.zhenai.com/v2/zhenXin/zhenXinIndex.do"
							target="_blank"> <img
							src="https://photo.zastatic.com/images/cms/banner/20180428/110920150471179158.jpg"
							alt="">
						</a>

					</section>
				</li>
				<li>
					<section class="myhome-banner">
						<a href="/v2/verify/zmIndex.do?type=2&amp;source=12"
							target="_blank"><img
							src="http://i2.zastatic.com/zhenai3/zhenai2015/img/credit/creditBanner_170e5e8.png"
							alt=""></a>
					</section>
				</li>

			</ul>
			<div class="ck-slidebox" style="margin-left: -18px;">
				<ul class="dot-wrap">
					<li class=""><em></em></li>
					<li class="current"><em></em></li>
				</ul>
			</div>
		</div>
		<!-- 热门用户-->
		<section class="zx-member-hot">

			<a class="hot-link" id="zx-link-id" title="热门用户"></a>

			<ul class="clearfix" id="zhenXinRecommend">
				<li style="opacity: 1;"><a
					href="http://album.zhenai.com/u/1462346967?from=newzx"
					target="_blank"><img
						src="http://photo14.zastatic.com/images/photo/365587/1462346967/2738493016080938.png?scrop=1&amp;crop=1&amp;w=100&amp;h=100&amp;cpos=north?scrop=1&amp;crop=1&amp;w=100&amp;h=100&amp;cpos=north"><span
						class="info">会...<br>北京 22岁
					</span></a></li>
				<li style="opacity: 1;"><a
					href="http://album.zhenai.com/u/1408983834?from=newzx"
					target="_blank"><img
						src="http://photo11.zastatic.com/images/photo/352246/1408983834/2736883567612821.png?scrop=1&amp;crop=1&amp;w=100&amp;h=100&amp;cpos=north?scrop=1&amp;crop=1&amp;w=100&amp;h=100&amp;cpos=north"><span
						class="info">潴潴潴潴<br>北京 24岁
					</span></a></li>
				<li style="opacity: 1;"><a
					href="http://album.zhenai.com/u/1405287544?from=newzx"
					target="_blank"><img
						src="http://photo15.zastatic.com/images/photo/351322/1405287544/2734832594397673.jpg?scrop=1&amp;crop=1&amp;w=100&amp;h=100&amp;cpos=north?scrop=1&amp;crop=1&amp;w=100&amp;h=100&amp;cpos=north"><span
						class="info">媄七<br>北京 20岁
					</span></a></li>
				<li style="opacity: 1;"><a
					href="http://album.zhenai.com/u/1845298161?from=newzx"
					target="_blank"><img
						src="http://photo14.zastatic.com/images/photo/461325/1845298161/2734785866295050.jpg?scrop=1&amp;crop=1&amp;w=100&amp;h=100&amp;cpos=north?scrop=1&amp;crop=1&amp;w=100&amp;h=100&amp;cpos=north"><span
						class="info">会...<br>北京 24岁
					</span></a></li>
				<li style="opacity: 1;"><a
					href="http://album.zhenai.com/u/1798308335?from=newzx"
					target="_blank"><img
						src="http://photo16.zastatic.com/images/photo/449578/1798308335/2728804501221772.jpg?scrop=1&amp;crop=1&amp;w=100&amp;h=100&amp;cpos=north?scrop=1&amp;crop=1&amp;w=100&amp;h=100&amp;cpos=north"><span
						class="info">小虾<br>北京 24岁
					</span></a></li>
				<li style="opacity: 1;"><a
					href="http://album.zhenai.com/u/1552252730?from=newzx"
					target="_blank"><img
						src="http://photo13.zastatic.com/images/photo/388064/1552252730/2713455515942662.png?scrop=1&amp;crop=1&amp;w=100&amp;h=100&amp;cpos=north?scrop=1&amp;crop=1&amp;w=100&amp;h=100&amp;cpos=north"><span
						class="info">草莓胞妹<br>北京 23岁
					</span></a></li>
				<li style="opacity: 1;"><a
					href="http://album.zhenai.com/u/1848462559?from=newzx"
					target="_blank"><img
						src="http://photo12.zastatic.com/images/photo/462116/1848462559/2711867908570645.png?scrop=1&amp;crop=1&amp;w=100&amp;h=100&amp;cpos=north?scrop=1&amp;crop=1&amp;w=100&amp;h=100&amp;cpos=north"><span
						class="info">艾米<br>北京 25岁
					</span></a></li>
				<li style="opacity: 1;"><a
					href="http://album.zhenai.com/u/1749453273?from=newzx"
					target="_blank"><img
						src="http://photo14.zastatic.com/images/photo/437364/1749453273/2708125095710701.png?scrop=1&amp;crop=1&amp;w=100&amp;h=100&amp;cpos=north?scrop=1&amp;crop=1&amp;w=100&amp;h=100&amp;cpos=north"><span
						class="info">挖了颗菜<br>北京 21岁
					</span></a></li>
				<li style="opacity: 1;"><a
					href="http://album.zhenai.com/u/1073241919?from=newzx"
					target="_blank"><img
						src="http://photo12.zastatic.com/images/photo/268311/1073241919/2706653752983679.jpg?scrop=1&amp;crop=1&amp;w=100&amp;h=100&amp;cpos=north?scrop=1&amp;crop=1&amp;w=100&amp;h=100&amp;cpos=north"><span
						class="info">s...<br>北京 22岁
					</span></a></li>
				<li style="opacity: 1;"><a
					href="http://album.zhenai.com/u/1648591421?from=newzx"
					target="_blank"><img
						src="http://photo16.zastatic.com/images/photo/412148/1648591421/2707114975360546.jpg?scrop=1&amp;crop=1&amp;w=100&amp;h=100&amp;cpos=north?scrop=1&amp;crop=1&amp;w=100&amp;h=100&amp;cpos=north"><span
						class="info">会...<br>北京 26岁
					</span></a></li>
				<li style="opacity: 1;"><a
					href="http://album.zhenai.com/u/1621851031?from=newzx"
					target="_blank"><img
						src="http://photo12.zastatic.com/images/photo/405463/1621851031/2701426111183473.png?scrop=1&amp;crop=1&amp;w=100&amp;h=100&amp;cpos=north?scrop=1&amp;crop=1&amp;w=100&amp;h=100&amp;cpos=north"><span
						class="info">会...<br>北京 26岁
					</span></a></li>
				<li style="opacity: 1;"><a
					href="http://album.zhenai.com/u/1739911341?from=newzx"
					target="_blank"><img
						src="http://photo14.zastatic.com/images/photo/434978/1739911341/2699013079136113.jpg?scrop=1&amp;crop=1&amp;w=100&amp;h=100&amp;cpos=north?scrop=1&amp;crop=1&amp;w=100&amp;h=100&amp;cpos=north"><span
						class="info">会...<br>北京 25岁
					</span></a></li>
			</ul>
			<a target="_blank" class="zx-member-more" title="查看更多"
				href="http://search.zhenai.com/search/getfastmdata.jsps?hotIndex=1&amp;isDefault=1"></a>
		</section>

		<!--内容部分左边：-->
		<div class="frame-left">

			<!--通知内容-->
			<section id="jcInteraction" class="interaction">
				<ul class="clearfix">
					<li class="news" style="width: 280px;">
						<div class="news-inner">
							<span id="jcNewsBg" class="icon none"></span>
							<p>
								<strong>0</strong>新信息
							</p>

						</div>
					</li>
					<li class="mail" style="width: 320px;">
						<div class="mail-inner">
							<span id="jcMailBg" class="icon"></span>
							<p>
								<strong>5</strong>新邮件
							</p>

						</div>
					</li>
					<li class="notice" style="width: 280px;">
						<div class="notice-inner">
							<span class="icon none"></span>
							<p>
								<strong>0</strong>通知
							</p>
						</div>
					</li>
				</ul>
			</section>
			<!--内容2：-->
			<div class="day-love day-love2">
				<section id="jcPositionBar" class="top-bar">
					<div class="change-pos">
						<div class="change-inner">
							<span>要找：</span> <span class="label">地区</span> <input type="text"
								value="-1" class="input-ui district-input province_input"
								id="formProvince_tmp" title="不限"> <input type="text"
								value="-1" class="input-ui district-input" id="formCity_tmp"
								title="不限"> <input type="hidden" id="formProvince"
								name="workcityprovince" value="-1"> <input type="hidden"
								id="formCity" name="workcitycity" value="-1"> <span
								class="label">年龄</span>
							<dl class="selector-ui age-selector" id="startAge"
								style="width: 55px">
								<dt>不限</dt>
								<dd style="display: none;">
									<input type="hidden" id="qy_age1" name="age1" value="-1">
								</dd>
							</dl>
							<span>-</span>
							<dl class="selector-ui" id="endAge" style="width: 55px">
								<dt>不限</dt>
								<dd style="display: none;">
									<input type="hidden" id="qy_age2" name="age2" value="-1">
								</dd>
							</dl>
							<span class="label">身高</span>
							<dl class="selector-ui" id="startHei" style="width: 55px">
								<dt>不限</dt>
								<dd style="display: none;">
									<input type="hidden" id="qy_height1" name="height1" value="-1">
								</dd>
							</dl>
							<span>-</span>
							<dl class="selector-ui" id="endHei" style="width: 55px">
								<dt>不限</dt>
								<dd style="display: none;">
									<input type="hidden" id="qy_height2" name="height2" value="-1">
								</dd>
							</dl>
							<span class="label">收入</span>
							<dl class="selector-ui" id="startSala" style="width: 60px">
								<dt>不限</dt>
								<dd style="display: none;">
									<input type="hidden" id="qy_salary1" name="salary1" value="-1">
								</dd>
							</dl>
							<span>-</span>
							<dl class="selector-ui" id="endSala" style="width: 55px">
								<dt>不限</dt>
								<dd style="display: none;">
									<input type="hidden" id="qy_salary2" name="salary2" value="-1">
								</dd>
							</dl>
							<a class="save" href="javascript:;">保存</a> <a class="cancle"
								href="javascript:;">取消</a>
						</div>
					</div>
					<div class="now-pos clearfix">
						<a class="edit" href="javascript:;" title="修改择偶条件">修改择偶条件</a><strong>每日情缘</strong><span>北京&nbsp;&nbsp;18-26岁&nbsp;&nbsp;130-210cm&nbsp;&nbsp;未婚&nbsp;&nbsp;的女士</span>
					</div>
				</section>
				<section id="jcDayLovePub" class="pub-user">
					<div class="user-list">
						<ul class="clearfix" id="qingYuanRecommend">
							<c:forEach items="${con }" var="userp">
								<li id="${userp.uid }" class="showFlag fadeFromLeft"><div
										class="user-item front clearfix">
										<div class="photo">
											<a><img src="<%=basePath%>${userp.picture.paddress }"></a>
										</div>
										<div class="user-info">
											<h3>
												<a class="name">${userp.name }</a><a class="flag-zx"></a> <a
													class="flag-mobile"></a><a class="flag-iden"></a> <a
													class="flag-credit credit-js">满分</a>
											</h3>
											<p class="base">${userp.age },${userp.address },</p>
											<p class="heart-word">正在寻找：。。。。。。</p>
											<p class="user-point">推荐理由：你的条件优秀，很容易打动对方哦</p>
										</div>
									</div></li>
							</c:forEach>
						</ul>
					</div>
				</section>
				<!--符合添加查找框	-->
				<section id="jcSearchBar" class="search-bar showFlag fadeFromBottom">
					<p>想查看更多符合你条件的用户？尝试一下搜索吧</p>
					<form id="search_home_form"
						action="http://search.zhenai.com/search/getfastmdata.jsps"
						target="_black" method="get">
						<div class="inner">
							<span><strong>搜索意中人</strong></span> <input type="text" value="-1"
								class="input-ui district-input province_input"
								id="formProvince_tmp2" title="北京" readonly="readonly"> <input
								type="text" value="-1" class="input-ui district-input"
								id="formCity_tmp2" title="不限" readonly="readonly"> <input
								type="hidden" id="formProvince2" name="workcityprovince"
								value="10102000"> <input type="hidden" id="formCity2"
								name="workcitycity" value="-1"> <input type="hidden"
								name="sex" value="1"> <input type="hidden" name="photo"
								value="1">
							<dl class="selector-ui age-selector" id="startAge2"
								style="width: 60px">
								<dt>18</dt>
								<dd style="display: none; height: 200px; overflow-y: auto;">
									<input type="hidden" id="s_age1" name="agebegin" value="18">
									<a data-value="18" href="javascript:;">18</a> <a
										data-value="19" href="javascript:;">19</a> <a data-value="20"
										href="javascript:;">20</a> <a data-value="21"
										href="javascript:;">21</a> <a data-value="22"
										href="javascript:;">22</a> <a data-value="23"
										href="javascript:;">23</a> <a data-value="24"
										href="javascript:;">24</a> <a data-value="25"
										href="javascript:;">25</a> <a data-value="26"
										href="javascript:;">26</a> <a data-value="27"
										href="javascript:;">27</a> <a data-value="28"
										href="javascript:;">28</a> <a data-value="29"
										href="javascript:;">29</a> <a data-value="30"
										href="javascript:;">30</a> <a data-value="31"
										href="javascript:;">31</a> <a data-value="32"
										href="javascript:;">32</a> <a data-value="33"
										href="javascript:;">33</a> <a data-value="34"
										href="javascript:;">34</a> <a data-value="35"
										href="javascript:;">35</a> <a data-value="36"
										href="javascript:;">36</a> <a data-value="37"
										href="javascript:;">37</a> <a data-value="38"
										href="javascript:;">38</a> <a data-value="39"
										href="javascript:;">39</a> <a data-value="40"
										href="javascript:;">40</a> <a data-value="41"
										href="javascript:;">41</a> <a data-value="42"
										href="javascript:;">42</a> <a data-value="43"
										href="javascript:;">43</a> <a data-value="44"
										href="javascript:;">44</a> <a data-value="45"
										href="javascript:;">45</a> <a data-value="46"
										href="javascript:;">46</a> <a data-value="47"
										href="javascript:;">47</a> <a data-value="48"
										href="javascript:;">48</a> <a data-value="49"
										href="javascript:;">49</a> <a data-value="50"
										href="javascript:;">50</a> <a data-value="51"
										href="javascript:;">51</a> <a data-value="52"
										href="javascript:;">52</a> <a data-value="53"
										href="javascript:;">53</a> <a data-value="54"
										href="javascript:;">54</a> <a data-value="55"
										href="javascript:;">55</a> <a data-value="56"
										href="javascript:;">56</a> <a data-value="57"
										href="javascript:;">57</a> <a data-value="58"
										href="javascript:;">58</a> <a data-value="59"
										href="javascript:;">59</a> <a data-value="60"
										href="javascript:;">60</a> <a data-value="61"
										href="javascript:;">61</a> <a data-value="62"
										href="javascript:;">62</a> <a data-value="63"
										href="javascript:;">63</a> <a data-value="64"
										href="javascript:;">64</a> <a data-value="65"
										href="javascript:;">65</a> <a data-value="66"
										href="javascript:;">66</a> <a data-value="67"
										href="javascript:;">67</a> <a data-value="68"
										href="javascript:;">68</a> <a data-value="69"
										href="javascript:;">69</a> <a data-value="70"
										href="javascript:;">70</a> <a data-value="71"
										href="javascript:;">71</a> <a data-value="72"
										href="javascript:;">72</a> <a data-value="73"
										href="javascript:;">73</a> <a data-value="74"
										href="javascript:;">74</a> <a data-value="75"
										href="javascript:;">75</a> <a data-value="76"
										href="javascript:;">76</a> <a data-value="77"
										href="javascript:;">77</a> <a data-value="78"
										href="javascript:;">78</a> <a data-value="79"
										href="javascript:;">79</a> <a data-value="80"
										href="javascript:;">80</a> <a data-value="81"
										href="javascript:;">81</a> <a data-value="82"
										href="javascript:;">82</a> <a data-value="83"
										href="javascript:;">83</a> <a data-value="84"
										href="javascript:;">84</a> <a data-value="85"
										href="javascript:;">85</a> <a data-value="86"
										href="javascript:;">86</a> <a data-value="87"
										href="javascript:;">87</a> <a data-value="88"
										href="javascript:;">88</a> <a data-value="89"
										href="javascript:;">89</a> <a data-value="90"
										href="javascript:;">90</a> <a data-value="91"
										href="javascript:;">91</a> <a data-value="92"
										href="javascript:;">92</a> <a data-value="93"
										href="javascript:;">93</a> <a data-value="94"
										href="javascript:;">94</a> <a data-value="95"
										href="javascript:;">95</a> <a data-value="96"
										href="javascript:;">96</a> <a data-value="97"
										href="javascript:;">97</a> <a data-value="98"
										href="javascript:;">98</a> <a data-value="99"
										href="javascript:;">99</a>
								</dd>
							</dl>
							<span>-</span>
							<dl class="selector-ui" id="endAge2" style="width: 60px">
								<dt>26</dt>
								<dd style="display: none; height: 200px; overflow-y: auto;">
									<input type="hidden" id="s_age2" name="ageend" value="26">
									<a data-value="18" href="javascript:;">18</a> <a
										data-value="19" href="javascript:;">19</a> <a data-value="20"
										href="javascript:;">20</a> <a data-value="21"
										href="javascript:;">21</a> <a data-value="22"
										href="javascript:;">22</a> <a data-value="23"
										href="javascript:;">23</a> <a data-value="24"
										href="javascript:;">24</a> <a data-value="25"
										href="javascript:;">25</a> <a data-value="26"
										href="javascript:;">26</a> <a data-value="27"
										href="javascript:;">27</a> <a data-value="28"
										href="javascript:;">28</a> <a data-value="29"
										href="javascript:;">29</a> <a data-value="30"
										href="javascript:;">30</a> <a data-value="31"
										href="javascript:;">31</a> <a data-value="32"
										href="javascript:;">32</a> <a data-value="33"
										href="javascript:;">33</a> <a data-value="34"
										href="javascript:;">34</a> <a data-value="35"
										href="javascript:;">35</a> <a data-value="36"
										href="javascript:;">36</a> <a data-value="37"
										href="javascript:;">37</a> <a data-value="38"
										href="javascript:;">38</a> <a data-value="39"
										href="javascript:;">39</a> <a data-value="40"
										href="javascript:;">40</a> <a data-value="41"
										href="javascript:;">41</a> <a data-value="42"
										href="javascript:;">42</a> <a data-value="43"
										href="javascript:;">43</a> <a data-value="44"
										href="javascript:;">44</a> <a data-value="45"
										href="javascript:;">45</a> <a data-value="46"
										href="javascript:;">46</a> <a data-value="47"
										href="javascript:;">47</a> <a data-value="48"
										href="javascript:;">48</a> <a data-value="49"
										href="javascript:;">49</a> <a data-value="50"
										href="javascript:;">50</a> <a data-value="51"
										href="javascript:;">51</a> <a data-value="52"
										href="javascript:;">52</a> <a data-value="53"
										href="javascript:;">53</a> <a data-value="54"
										href="javascript:;">54</a> <a data-value="55"
										href="javascript:;">55</a> <a data-value="56"
										href="javascript:;">56</a> <a data-value="57"
										href="javascript:;">57</a> <a data-value="58"
										href="javascript:;">58</a> <a data-value="59"
										href="javascript:;">59</a> <a data-value="60"
										href="javascript:;">60</a> <a data-value="61"
										href="javascript:;">61</a> <a data-value="62"
										href="javascript:;">62</a> <a data-value="63"
										href="javascript:;">63</a> <a data-value="64"
										href="javascript:;">64</a> <a data-value="65"
										href="javascript:;">65</a> <a data-value="66"
										href="javascript:;">66</a> <a data-value="67"
										href="javascript:;">67</a> <a data-value="68"
										href="javascript:;">68</a> <a data-value="69"
										href="javascript:;">69</a> <a data-value="70"
										href="javascript:;">70</a> <a data-value="71"
										href="javascript:;">71</a> <a data-value="72"
										href="javascript:;">72</a> <a data-value="73"
										href="javascript:;">73</a> <a data-value="74"
										href="javascript:;">74</a> <a data-value="75"
										href="javascript:;">75</a> <a data-value="76"
										href="javascript:;">76</a> <a data-value="77"
										href="javascript:;">77</a> <a data-value="78"
										href="javascript:;">78</a> <a data-value="79"
										href="javascript:;">79</a> <a data-value="80"
										href="javascript:;">80</a> <a data-value="81"
										href="javascript:;">81</a> <a data-value="82"
										href="javascript:;">82</a> <a data-value="83"
										href="javascript:;">83</a> <a data-value="84"
										href="javascript:;">84</a> <a data-value="85"
										href="javascript:;">85</a> <a data-value="86"
										href="javascript:;">86</a> <a data-value="87"
										href="javascript:;">87</a> <a data-value="88"
										href="javascript:;">88</a> <a data-value="89"
										href="javascript:;">89</a> <a data-value="90"
										href="javascript:;">90</a> <a data-value="91"
										href="javascript:;">91</a> <a data-value="92"
										href="javascript:;">92</a> <a data-value="93"
										href="javascript:;">93</a> <a data-value="94"
										href="javascript:;">94</a> <a data-value="95"
										href="javascript:;">95</a> <a data-value="96"
										href="javascript:;">96</a> <a data-value="97"
										href="javascript:;">97</a> <a data-value="98"
										href="javascript:;">98</a> <a data-value="99"
										href="javascript:;">99</a>
								</dd>
							</dl>
							<span>岁</span>
							<dl class="selector-ui" id="startHei2" style="width: 72px;">
								<dt>130</dt>
								<dd style="display: none; height: 200px; overflow-y: auto;">
									<input type="hidden" id="s_height1" name="h1" value="130">
									<a data-value="130" href="javascript:;">130</a> <a
										data-value="131" href="javascript:;">131</a> <a
										data-value="132" href="javascript:;">132</a> <a
										data-value="133" href="javascript:;">133</a> <a
										data-value="134" href="javascript:;">134</a> <a
										data-value="135" href="javascript:;">135</a> <a
										data-value="136" href="javascript:;">136</a> <a
										data-value="137" href="javascript:;">137</a> <a
										data-value="138" href="javascript:;">138</a> <a
										data-value="139" href="javascript:;">139</a> <a
										data-value="140" href="javascript:;">140</a> <a
										data-value="141" href="javascript:;">141</a> <a
										data-value="142" href="javascript:;">142</a> <a
										data-value="143" href="javascript:;">143</a> <a
										data-value="144" href="javascript:;">144</a> <a
										data-value="145" href="javascript:;">145</a> <a
										data-value="146" href="javascript:;">146</a> <a
										data-value="147" href="javascript:;">147</a> <a
										data-value="148" href="javascript:;">148</a> <a
										data-value="149" href="javascript:;">149</a> <a
										data-value="150" href="javascript:;">150</a> <a
										data-value="151" href="javascript:;">151</a> <a
										data-value="152" href="javascript:;">152</a> <a
										data-value="153" href="javascript:;">153</a> <a
										data-value="154" href="javascript:;">154</a> <a
										data-value="155" href="javascript:;">155</a> <a
										data-value="156" href="javascript:;">156</a> <a
										data-value="157" href="javascript:;">157</a> <a
										data-value="158" href="javascript:;">158</a> <a
										data-value="159" href="javascript:;">159</a> <a
										data-value="160" href="javascript:;">160</a> <a
										data-value="161" href="javascript:;">161</a> <a
										data-value="162" href="javascript:;">162</a> <a
										data-value="163" href="javascript:;">163</a> <a
										data-value="164" href="javascript:;">164</a> <a
										data-value="165" href="javascript:;">165</a> <a
										data-value="166" href="javascript:;">166</a> <a
										data-value="167" href="javascript:;">167</a> <a
										data-value="168" href="javascript:;">168</a> <a
										data-value="169" href="javascript:;">169</a> <a
										data-value="170" href="javascript:;">170</a> <a
										data-value="171" href="javascript:;">171</a> <a
										data-value="172" href="javascript:;">172</a> <a
										data-value="173" href="javascript:;">173</a> <a
										data-value="174" href="javascript:;">174</a> <a
										data-value="175" href="javascript:;">175</a> <a
										data-value="176" href="javascript:;">176</a> <a
										data-value="177" href="javascript:;">177</a> <a
										data-value="178" href="javascript:;">178</a> <a
										data-value="179" href="javascript:;">179</a> <a
										data-value="180" href="javascript:;">180</a> <a
										data-value="181" href="javascript:;">181</a> <a
										data-value="182" href="javascript:;">182</a> <a
										data-value="183" href="javascript:;">183</a> <a
										data-value="184" href="javascript:;">184</a> <a
										data-value="185" href="javascript:;">185</a> <a
										data-value="186" href="javascript:;">186</a> <a
										data-value="187" href="javascript:;">187</a> <a
										data-value="188" href="javascript:;">188</a> <a
										data-value="189" href="javascript:;">189</a> <a
										data-value="190" href="javascript:;">190</a> <a
										data-value="191" href="javascript:;">191</a> <a
										data-value="192" href="javascript:;">192</a> <a
										data-value="193" href="javascript:;">193</a> <a
										data-value="194" href="javascript:;">194</a> <a
										data-value="195" href="javascript:;">195</a> <a
										data-value="196" href="javascript:;">196</a> <a
										data-value="197" href="javascript:;">197</a> <a
										data-value="198" href="javascript:;">198</a> <a
										data-value="199" href="javascript:;">199</a> <a
										data-value="200" href="javascript:;">200</a> <a
										data-value="201" href="javascript:;">201</a> <a
										data-value="202" href="javascript:;">202</a> <a
										data-value="203" href="javascript:;">203</a> <a
										data-value="204" href="javascript:;">204</a> <a
										data-value="205" href="javascript:;">205</a> <a
										data-value="206" href="javascript:;">206</a> <a
										data-value="207" href="javascript:;">207</a> <a
										data-value="208" href="javascript:;">208</a> <a
										data-value="209" href="javascript:;">209</a> <a
										data-value="210" href="javascript:;">210</a>
								</dd>
							</dl>
							<span>-</span>
							<dl class="selector-ui" id="endHei2" style="width: 72px;">
								<dt>210</dt>
								<dd style="display: none; height: 200px; overflow-y: auto;">
									<input type="hidden" id="s_height2" name="h2" value="210">
									<a data-value="130" href="javascript:;">130</a> <a
										data-value="131" href="javascript:;">131</a> <a
										data-value="132" href="javascript:;">132</a> <a
										data-value="133" href="javascript:;">133</a> <a
										data-value="134" href="javascript:;">134</a> <a
										data-value="135" href="javascript:;">135</a> <a
										data-value="136" href="javascript:;">136</a> <a
										data-value="137" href="javascript:;">137</a> <a
										data-value="138" href="javascript:;">138</a> <a
										data-value="139" href="javascript:;">139</a> <a
										data-value="140" href="javascript:;">140</a> <a
										data-value="141" href="javascript:;">141</a> <a
										data-value="142" href="javascript:;">142</a> <a
										data-value="143" href="javascript:;">143</a> <a
										data-value="144" href="javascript:;">144</a> <a
										data-value="145" href="javascript:;">145</a> <a
										data-value="146" href="javascript:;">146</a> <a
										data-value="147" href="javascript:;">147</a> <a
										data-value="148" href="javascript:;">148</a> <a
										data-value="149" href="javascript:;">149</a> <a
										data-value="150" href="javascript:;">150</a> <a
										data-value="151" href="javascript:;">151</a> <a
										data-value="152" href="javascript:;">152</a> <a
										data-value="153" href="javascript:;">153</a> <a
										data-value="154" href="javascript:;">154</a> <a
										data-value="155" href="javascript:;">155</a> <a
										data-value="156" href="javascript:;">156</a> <a
										data-value="157" href="javascript:;">157</a> <a
										data-value="158" href="javascript:;">158</a> <a
										data-value="159" href="javascript:;">159</a> <a
										data-value="160" href="javascript:;">160</a> <a
										data-value="161" href="javascript:;">161</a> <a
										data-value="162" href="javascript:;">162</a> <a
										data-value="163" href="javascript:;">163</a> <a
										data-value="164" href="javascript:;">164</a> <a
										data-value="165" href="javascript:;">165</a> <a
										data-value="166" href="javascript:;">166</a> <a
										data-value="167" href="javascript:;">167</a> <a
										data-value="168" href="javascript:;">168</a> <a
										data-value="169" href="javascript:;">169</a> <a
										data-value="170" href="javascript:;">170</a> <a
										data-value="171" href="javascript:;">171</a> <a
										data-value="172" href="javascript:;">172</a> <a
										data-value="173" href="javascript:;">173</a> <a
										data-value="174" href="javascript:;">174</a> <a
										data-value="175" href="javascript:;">175</a> <a
										data-value="176" href="javascript:;">176</a> <a
										data-value="177" href="javascript:;">177</a> <a
										data-value="178" href="javascript:;">178</a> <a
										data-value="179" href="javascript:;">179</a> <a
										data-value="180" href="javascript:;">180</a> <a
										data-value="181" href="javascript:;">181</a> <a
										data-value="182" href="javascript:;">182</a> <a
										data-value="183" href="javascript:;">183</a> <a
										data-value="184" href="javascript:;">184</a> <a
										data-value="185" href="javascript:;">185</a> <a
										data-value="186" href="javascript:;">186</a> <a
										data-value="187" href="javascript:;">187</a> <a
										data-value="188" href="javascript:;">188</a> <a
										data-value="189" href="javascript:;">189</a> <a
										data-value="190" href="javascript:;">190</a> <a
										data-value="191" href="javascript:;">191</a> <a
										data-value="192" href="javascript:;">192</a> <a
										data-value="193" href="javascript:;">193</a> <a
										data-value="194" href="javascript:;">194</a> <a
										data-value="195" href="javascript:;">195</a> <a
										data-value="196" href="javascript:;">196</a> <a
										data-value="197" href="javascript:;">197</a> <a
										data-value="198" href="javascript:;">198</a> <a
										data-value="199" href="javascript:;">199</a> <a
										data-value="200" href="javascript:;">200</a> <a
										data-value="201" href="javascript:;">201</a> <a
										data-value="202" href="javascript:;">202</a> <a
										data-value="203" href="javascript:;">203</a> <a
										data-value="204" href="javascript:;">204</a> <a
										data-value="205" href="javascript:;">205</a> <a
										data-value="206" href="javascript:;">206</a> <a
										data-value="207" href="javascript:;">207</a> <a
										data-value="208" href="javascript:;">208</a> <a
										data-value="209" href="javascript:;">209</a> <a
										data-value="210" href="javascript:;">210</a>
								</dd>
							</dl>
							<span>厘米</span>
							<dl class="selector-ui" id="marital2" style="width: 60px">
								<dt>未婚</dt>
								<dd style="display: none;">
									<input type="hidden" name="Marriage" value="1"> <a
										data-value="-1" href="javascript:;">不限</a> <a data-value="1"
										href="javascript:;">未婚</a> <a data-value="3"
										href="javascript:;">离异</a> <a data-value="4"
										href="javascript:;">丧偶</a>
								</dd>
							</dl>
							<a class="btn-search" href="javascript:;">搜索</a>
						</div>
					</form>
				</section>

			</div>

		</div>

		<!-- 内容部分右边-->
		<div class="frame-right">
			<div class="mod-block-3 exp-preson-info showFlag fadeFromBottom"
				id="jcMyInfoPanel">
				<a target="_blank"
					href="http://profile.zhenai.com/v2/profile/index?skinEntity=1"
					onclick="ajaxStat(1653,0,0,0);" class="want-skin" title="我要装扮"></a>
				<div class="exp-p-info">

					<div class="user-100">
						<a target="_blank"><img
							src="<%=basePath%>${list2[0].picture.paddress }"></a>
					</div>
					<dl>
						<dt>
							<a class="myname" href="" target="_blank">${list2[0].name }</a> <a
								class="flag-zx-n"
								href="http://profile.zhenai.com/v2/zhenXin/zhenXinIndex.do"
								target="_blank" title="珍心会员"></a>

						</dt>
						<dd class="ico_panel">
							<p class="grayL pid">********</p>

							<a class="flag-mobile"
								href="http://profile.zhenai.com/profile/validateContactPre.jsps"
								target="_blank" title="已验证手机号" rel="nofollow"></a> <a
								class="flag-iden-n"
								href="/v2/verify/zmIndex.do?type=2&amp;source=9"
								onclick="ajaxStat(1963,9,0,0)" target="_blank" title="未通过完整身份认证"
								rel="nofollow"></a> <a class="flag-credit-n credit-js"
								href="/v2/verify/zmIndex.do?type=2&amp;source=10"
								target="_blank" title="未通过芝麻信用认证" data-mid="110531979"
								data-score="0" data-source="14">芝麻分</a>

						</dd>
						<dd>
							<div class="prefect-data">
								<div class="myinfo-step">
									<div class="circle-percent" style="cursor: pointer;"
										percent="40%">
										<div style="visibility: hidden;"></div>
										<div style="transform: rotate(144deg);"></div>
									</div>
									<em>40%</em>
								</div>
								<a target="_blank" id="updatepsw">修改密码</a> <a target="_blank"
									href="http://album.zhenai.com/u/110531979">预览</a>
							</div>
						</dd>
					</dl>
				</div>
				<ul class="exp-info-list jaAddHover">
					<li class="">
						<dt>
							<a target="_blank"
								href="http://profile.zhenai.com/personal/uploadphoto.jsps"
								class="info-num">0</a>
						</dt>
						<dt>
							<span>照片</span><a target="_blank"
								href="http://profile.zhenai.com/personal/uploadphoto.jsps">上传</a>
						</dt>
					</li>
					<li class="info-mid">
						<dt>
							<a target="_blank"
								href="http://profile.zhenai.com/v2/verify/verifyIndex.do"
								class="info-num">2</a>
						</dt>
						<dt>
							<span>诚信值</span><a target="_blank"
								href="http://profile.zhenai.com/v2/verify/verifyIndex.do">提升</a>
						</dt>
					</li>
					<li class="">
						<dt>
							<a target="_blank"
								href="http://profile.zhenai.com/v2/personal/coin/zhenaiAccountInfo.do"
								class="info-num">0.0</a>
						</dt>
						<dt>
							<span>珍爱币</span><a target="_blank"
								href="http://profile.zhenai.com/v2/personal/coin/zhenaiAccountInfo.do">充值</a>
						</dt>
					</li>
				</ul>
			</div>

			<!-- 谁看过我 -->
			<div class="mod-block-1 view-me showFlag fadeFromBottom"
				id="jcViewMePanel">
				<h2 class="title clearfix">
					<span>谁看过我</span> <a href="/v2/visit/index.do?type=0"
						target="_blank">更多<b class="simsun">&gt;&gt;</b></a>
				</h2>

				<div class="no-photo">
					没头像，没人爱，快去 <a
						href="http://profile.zhenai.com/personal/uploadphoto.jsps"
						target="_blank">上传头像</a>吧~
				</div>

			</div>

			<!-- start 新手引导 -->

			<!-- end 新手引导 -->

			<!-- 珍爱品牌宣传广告 -->
			<div class="mod-banner-brand showFlag fadeFromBottom"
				id="jcBrandBanner">
				<a
					href="http://profile.zhenai.com/activity/showDiaoYan.jsps?info.qType=230"
					target="_blank" id="ad_home" onclick="ajaxStat(1975,69,0,0);"><img
					src="http://photo.zastatic.com//photo/activity/1492395725123.jpg"></a>
			</div>

			<!-- 珍爱服务 -->
			<div class="mod-block-1 showFlag fadeFromBottom" id="jcServicePanel">
				<h2 class="title">
					<span>珍爱服务</span> <a
						href="http://profile.zhenai.com/v2/personal/coin/zhenaiAccountInfo.do"
						target="_blank">更多<b class="simsun">&gt;&gt;</b></a>
				</h2>
				<div class="mod-vip-1">
					<a href="http://profile.zhenai.com/v2/zhenXin/zhenXinIndex.do"
						target="_blank"><img
						src="http://i2.zastatic.com/zhenai3/zhenai2015/img/myhome/zxVIP_07d2039.gif"
						alt=""></a>
					<dl>
						<dt>
							<a href="http://profile.zhenai.com/v2/zhenXin/zhenXinIndex.do"
								target="_blank">珍心会员</a>
						</dt>
						<dd>自助服务，免费看信、发信，14项特权助您快速找到心上人！</dd>
					</dl>
				</div>

				<!-- 珍爱通入口  --- begin -->

				<!-- 珍爱通入口  --- end -->

				<!-- 恋爱导师  --- star -->

				<!-- 恋爱导师  --- end -->

				<!-- 星级会员入口  --- star -->

				<div class="mod-vip-1">
					<a
						href="http://profile.zhenai.com/v2/star/starIndex.do?tipType=410"
						target="_blank"> <img
						src="http://i2.zastatic.com/zhenai3/zhenai2015/img/myhome/zaStar_fc3b297.gif"
						alt="">
					</a>
					<dl>
						<dt>
							<a
								href="http://profile.zhenai.com/v2/star/starIndex.do?tipType=410"
								target="_blank">星级特权</a>
						</dt>
						<dd>搜索提前,查看登录时间,尊贵标识，免费认证，助您寻爱!</dd>
					</dl>
				</div>

				<!-- 星级会员入口  --- end -->

				<a
					href="http://profile.zhenai.com/v2/personal/coin/zhenaiAccountInfo.do"
					target="_blank" class="btn-b exp-accout">我的账户</a> <a
					href="http://t.zhenai.com/offline/index.do" target="_blank"><img
					src="http://i2.zastatic.com/zhenai3/zhenai2015/img/offline/ad_m1_de744ed.jpg"
					alt="珍爱人工红娘" class="exp-banner"></a>

			</div>

			<!-- 游戏入口bgein -->

			<div class="mod-block-1 showFlag fadeFromBottom" id="jcGameBar"
				memberid="110531979"></div>

			<!-- 游戏入口end -->

			<!-- 珍爱应用 -->
			<div class="mod-block-1 showFlag fadeFromBottom" id="jcAppPanel">
				<h2 class="title">
					<span>珍爱应用</span>
				</h2>
				<ul class="mod-list-1 exp-app-list">

					<li><a
						href="http://profile.zhenai.com/interactive/dandelionIndex.jsps"
						target="_blank"><img
							src="http://images.zastatic.com/zhenai3/zhenai2015/img/myhome/app-2.jpg"
							alt="爱情蒲公英"></a>
						<dl>
							<dd>
								<a
									href="http://profile.zhenai.com/interactive/dandelionIndex.jsps"
									target="_blank">爱情蒲公英</a>
							</dd>
							<dd>
								<span>4113511</span>人
							</dd>
						</dl></li>

					<li><a
						href="http://profile.zhenai.com/personal/glittering/jumpIndex.jsps"
						target="_blank"><img
							src="http://images.zastatic.com/zhenai3/zhenai2015/img/myhome/app-3.jpg"
							alt="来表态"></a>
						<dl>
							<dd>
								<a
									href="http://profile.zhenai.com/personal/glittering/jumpIndex.jsps"
									target="_blank">来表态</a>
							</dd>
							<dd>
								<span>2628190</span>人
							</dd>
						</dl></li>

					<li><a
						href="http://t.zhenai.com/activity/constellationIndex.do"
						target="_blank"><img
							src="http://images.zastatic.com/zhenai3/zhenai2015/img/myhome/app-4.jpg"
							alt="星座情缘"></a>
						<dl>
							<dd>
								<a href="http://t.zhenai.com/activity/constellationIndex.do"
									target="_blank">星座情缘</a>
							</dd>
							<dd>
								<span>2974838</span>人
							</dd>
						</dl></li>

					<li><a
						href="http://profile.zhenai.com/idcard/birthdayFateIndex.jsps"
						target="_blank"><img
							src="http://images.zastatic.com/zhenai3/zhenai2015/img/myhome/app-5.jpg"
							alt="同生缘"></a>
						<dl>
							<dd>
								<a
									href="http://profile.zhenai.com/idcard/birthdayFateIndex.jsps"
									target="_blank">同生缘</a>
							</dd>
							<dd>
								<span>3159779</span>人
							</dd>
						</dl></li>

					<li><a
						href="http://profile.zhenai.com/v2/personal/map/index.do?from=2"
						target="_blank"><img
							src="http://images.zastatic.com/zhenai3/zhenai2015/img/myhome/app-7.png"
							alt="地图搜索"></a>
						<dl>
							<dd>
								<a
									href="http://profile.zhenai.com/v2/personal/map/index.do?from=2"
									target="_blank">地图搜索</a>
							</dd>
							<dd>
								<span>2666094</span>人
							</dd>
						</dl></li>

				</ul>
			</div>

			<!-- 精彩活动 -->

			<div class="mod-banner-brand showFlag fadeFromBottom" id="jcActPanel"
				name="randomPic">
				<a href="http://dd.zhenai.com/pc/index.html" target="_blank"
					onclick="ajaxStat(1975,70,0,0);"> <img alt="珍爱关怀"
					src="http://images.zastatic.com/zhenai3/zhenai2015/img/myhome/dd-2.jpg">
				</a>
			</div>

			<!-- 珍爱相关 -->
			<div class="mod-block-1 exp-about-za showFlag fadeFromBottom"
				id="jcTelPanel">
				<h2 class="title">
					<span>珍爱相关</span>
				</h2>
				<p class="about-info">珍爱红娘如果联系您，会使用如下号码：</p>
				<div id="jaTelArea" class="tel-list">
					<p>北京：&nbsp;&nbsp;010-52050520</p>
					<p>深圳：0755-26613636</p>
					<p>0755-86101520</p>
					<p>0755-26625512</p>
					<p>0755-86102922</p>
					<p>0755-26619522</p>
					<p>0755-26619523</p>
					<p>0755-26616525</p>
					<p>0755-26616529</p>
					<p>0755-26619521</p>
					<p>0755-26619520</p>
					<p>0755-26637520</p>
					<p>0755-26637521</p>
					<p>0755-26637523</p>
					<p>0755-61800520</p>
					<p>0755-61801520</p>
					<p>0755-61802520</p>
					<p>0755-61803520</p>
					<p>0755-66863520</p>
					<p>0755-86102099</p>
					<p>0755-84351606</p>
					<p>0755-84351607</p>
					<p>厦门：0592-5896333</p>
					<p>0592-3920520</p>
					<p>0592-5190520</p>
					<p>0592-5195520</p>
					<p>0592-5196520</p>
					<p>0592-5932520</p>
					<p>0592-5937520</p>
					<p>0592-3690520</p>
					<p>0592-3695520</p>
					<p>0592-3978520</p>
					<p>0592-3971520</p>
					<p>0592-3919520</p>
					<a href="javascript:;" class="about-arrow" title="展开查看更多"></a>
				</div>
			</div>
			<!-- 网络举报 -->
			<div class="mod-banner-brand showFlag fadeFromBottom" id="jcjbAPP">
				<a href="http://www.12377.cn/node_548446.htm" target="_blank"> <img
					alt="网络举报APP下载"
					src="http://i2.zastatic.com/zhenai3/zhenai2015/img/myhome/jbapp_e822d37.jpg">
				</a>
			</div>
		</div>
	</article>
	<!--底部-->
	<div class="hot-city">
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
	<!--最底部-->
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
	<!--回到顶端-->
	<section class="za-tool-bar">
		<ul>
			<li class="survey"><a href="javascript:;" title="在线咨询"></a></li>
			<li class="mobile"><a href="javascript:;" title="手机珍爱"></a></li>
			<li class="feedback_new"><a href="javascript:;" title="意见反馈"></a>
			</li>
			<li class="gotop"><a href="#aa" title="返回顶部"></a></li>
		</ul>
		<div class="ZaTips grayA right"
			style="display: none; opacity: 0; left: -170px;">
			<div class="content">
				<div class="mobile-qrcode">扫一扫下载客户端</div>
			</div>
			<span class="arrow"><i class="outer"></i><i class="inner"></i></span>
		</div>
	</section>

</body>
<script
	src="http://i3.zastatic.com/zhenai3/zhenai2015/js/lib/LAB.min_85a55fb.js"></script>
<script
	src="http://i3.zastatic.com/zhenai3/zhenai2015/js/lib/sea_6642d21.js"></script>
<script
	src="http://i3.zastatic.com/zhenai3/zhenai2015/sea-config_db5e470.js"></script>
<script
	src="http://i3.zastatic.com/zhenai3/zhenai2015/js/lib/jquery-1.8.3.min_e128811.js"></script>
<script
	src="http://i3.zastatic.com/zhenai3/zhenai2015/js/public/screenfix_608df31.js"></script>
<script src="<%=basePath%>js/jquery-2.2.4.min.js" type="text/javascript"
	charset="utf-8"></script>
<script type="text/javascript">
//标识id:
	// 个人中心的点击事件
	var div3 = document.getElementById("person");
	div3.onclick = function() {
		location.href="<%=basePath%>per?uid="+${list2[0].uid};
	}
	// 同城匹配的点击事件
	var div2 = document.querySelector("#search");
	div2.onclick = function() {
// 		$.ajax({
// 			type : "get",
<%-- 			url : "<%=basePath%>select", --%>
// 			async : true,
// 			data : {
// 				uid : '${list2[0].uid}',
// 				sex : '${list2[0].sex}',
// 				age : '${list2[0].age}',
// 				address : '${list2[0].address}'
// 			},
// 		});
     /*  document.cookie="uid=${list2[0].uid}",path="/";
      document.cookie="sex=${list2[0].sex}",path="/"; 
      document.cookie="age=${list2[0].age}",path="/";
      document.cookie="address=${list2[0].address}",path="/";  */
      

      window.location="<%=basePath%>select";
	};
 //异城匹配
	var div3 = document.querySelector("#search2");
	div3.onclick=function(){
		
		location.href="<%=basePath%>select2";
	}
	
	// 获取u l标签:
	var ul = document.querySelector("#qingYuanRecommend");
	
	// 首页展示图片的点击事件
	for (var i = 0; i < ul.getElementsByTagName("li").length; i++) {
		ul.children[i].onclick = function(res) {
			var uuid = res.path[4].id;
 			location.href = "<%=basePath%>per?uid=" + uuid; 
		}
	}
	
 </script>

</html>