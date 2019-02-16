<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>留言板</title>
		<style type="text/css">
			.div3 {
				width: 60px;
				height: 25px;
				background-color: blue;
				border-radius: 10px;
				color: white;
				text-align: center;
				line-height: 25px;
				margin-left: 440px;
			}
			
			.div4 {
				width: 500px;
				display: inline-block;
			}
		</style>
	</head>

	<body>
	<div style="float:left; color: red">${code }</div>
	<br>
		<div class="div1" style="color: green; margin: 5px 0px;">
			留言板
		</div>
		<div class="div2">
			<textarea style="width: 500px; height: 100px; background-color: beige;"></textarea>
			<div class="div3" style="margin-bottom: 20px;">发表</div>
		</div>
		<div class="div4"></div>
		<!--<div class="div5"></div>-->
	</body>
	<script type="text/javascript">
		//获取div2标签
		var div2 = document.querySelector(".div2");
		//获取输入框标签
		var t = document.querySelector("textarea");
		//获取div3标签（发表）
		var div3 = document.querySelector(".div3");

		//获取div4标签(显示)
		var div4 = document.querySelector(".div4");

		var n = 0;
		var ca = ["red", "bule", "yellow", "beige", "aqua", "brown", "cyan", "coral", "cadetblue", "cornflowerblue"];
		var pict = [];
		//设置点击事件
		div3.onclick = function() {
			//获取输入框的内容
			var s = t.value;
			if(s != "") {
				n++;
				//获取随机数
				var rod = Math.floor(Math.random() * 9);

				//console.log(s);
				//新建标签
				var mydiv = document.createElement("div");
				var mydiv2 = document.createElement("div");
				var mydiv3 = document.createElement("div");
				var lou = document.createElement("lou");
				//				var mydiv4 = document.createElement("div");

				//               mydiv4.setAttribute("style","width: 50px;height: 50px;background-image: url(img/头戴式耳机.png);display: inline-block;");
//				mydiv.appendChild(mydiv4);
				lou.innerText = "第" + n + "楼";
				//将lou标签加入到mydiv中
				mydiv.appendChild(lou);
				//设置mydiv样式
				mydiv.style.color = "black";
				mydiv.style.width = "100%";
				mydiv.style.backgroundColor = ca[rod];
				mydiv.style.wordBreak = "break-all";
				mydiv.style.display = "inline-block";
				mydiv2.innerText = s;
				//设置mydiv3样式
				mydiv3.setAttribute("style", "width: 60px; height: 25px;background-color: antiquewhite;border-radius: 10px;color: red;text-align: center;line-height: 25px;margin-left: 440px;");
				mydiv3.innerText = "删除";

				mydiv2.appendChild(mydiv3);
				mydiv.appendChild(mydiv2);
				div4.insertBefore(mydiv, div4.children[0]);

				//绑定点击事件
				mydiv3.onclick = function() {
					var is = confirm("是否删除?");
					if(is) {
						//获取父类的父类
						var p = mydiv3.parentElement.parentElement;
						div4.removeChild(p);
						var m = div4.children.length;
						console.log(m);
						for(var i = 0; i < m; i++) {
							div4.children[i].children[0].innerText = "第" + (m - i) + "楼";
						}
						n = m;
					}
				}
			} else {
				alert("输入的内容不能为空!");
			}
			t.value = "";
		}
	</script>

</html>