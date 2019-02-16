<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@  taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    <%
	String path = request.getContextPath();
	//协议://+IP:+端口号+/+工程名+/
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
	application.setAttribute("uid", 48);
%>
<!DOCTYPE html>
<html>

	<head>
		<meta charset="UTF-8">
		<title></title>
		<style>
			body {
				width: 800px;
				height: auto;
				font-size: 18px;
				margin: auto;
				margin-top: 0px;
				background: whitesmoke;
			}
			.wrap {
				margin: auto;
				background: beige;
				margin-top: 0px;
			}
		</style>
	</head>

	<body>
		<div class="wrap">
			<p style="font-size: 28px; text-align: center;">******服务协议</p>
			<p style="font-size: 20px; text-indent: 36px;">欢迎使用 ***（以下简称“***”或“本网站”）。
				本服务协议（以下简称“协议”）
				是您与***的运营商*****信息技术有限公司（以下简称“****”或“我们）
				之间关于您成为***会员且使用****提供的在线婚介服务所订立的协议。 </p>
			<p style="font-size: 20px; text-indent: 36px;">本协议适用于珍爱网下所有的服务、资料及信息，而且也适用于我们和您之间通过电子邮件或电话、
				传真等任何方式进行的任何沟通。请在使用本网站的服务之前认真阅读下述条款，特别是本协议含有免除或者限制我们责任的条款（该等条款通常含有“不负任何
				责任”、“无义务”等词汇），和其它限制会员权利的条款（该等条款通常含有“不得”等词汇）。除非您接受本《协议》所有条款，否则您无权注册、登录或使用
				本协议所涉相关服务。您的注册、登录、使用等行为将视为对本《协议》的接受，并同意接受本《协议》各项条款的约束。为免歧义，本协议中的“注册”、登录或
				“使用”是指您注册成为本网站会员并使用本网站提供的任何服务，或者您未注册成为本网站会员，但通过阅读、浏览、复制或以其他方式使用本网站上提供的任何
				信息以及以任
				何方式使用本网站提供之各类服务。未免歧义，除非本协议中另有说明或根据本协议上下文理解另有含义，“会员”指免费会员和付费会员。</p>
			<p style="font-size: 20px; text-indent: 36px;"> 您对本协议的接受即受全部条款的约束，包括接受珍爱网公司对任一服务条款随时所做的任何修改。本
				《协议》可由珍爱网公司随时更新，更新后的协议条款一旦公布即代替原来的协议条款，恕不再另行通知，会员可以查阅最新版协议
				条款。在珍爱网公司修改《协议》条款后，如果会员不接受修改后的条款，请立即停止使用珍爱网提供的服务，会员继续使用珍爱网提供的服务将被视为已接受了修
				改后的协议。</p>
			<p style="font-size: 20px; text-indent: 36px;">鉴于：我国《合同法》第39条规定：采用格式条款订立合同的，提供格式条款的一方应当遵循公平原则
				确定当事人之间的权利和义务，并采取合理的方式提请对方注意免除或者限制其责任的条款，按照对方的要求，对该条款予以说明。</p>
				<p style="font-size: 20px; text-indent: 36px;"> 鉴于珍爱网已依法明确了上述条款、履行了格式条款制订方的义务，您进行下一步，将被视为且应
					当被视为您已经完全注意并同意了本协议所有条款尤其是提醒会员注意的条款的合法
					性及有效性，会员不应当以珍爱网未对格式条款以合理方式提醒会员注意，或未根据会员要求尽到说明义务为理由而声称或要求法院或其它任何第三方确认
					相关条款非法或无效。</p>
			<p style="font-size: 20px; text-indent: 36px;"> 我已阅读并充分理解了以上协议中各条款，特别是涉及免除或者限制珍爱网责任的免责条款，
				对会员的权利限制的条款、约定争议解决方式、司法管辖、法律适用的条款，并且同意以上协议的全部内容。</p>
			
			
			  
		</div>
	</body>

</html>