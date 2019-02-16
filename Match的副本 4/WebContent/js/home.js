//加载窗口:
window.onload = function() {

	// 获取u l标签:
	var ul = document.querySelector("#qingYuanRecommend");
	// 接受前端传来的信息:
	var str = location.href;
	// 性别:
	var sex1 = str.split("?")[1].split("&")[1].split("=")[1];
	// 标识id:
	var id1 = str.split("?")[1].split("&")[0].split("=")[1];
	if (id1 != null) {
		var date = new Date();
		date.setDate(date.getDay() + 1 + 7);
		document.cookie = "pass=ok;expires=" + date;
	}
	var sex2 = decodeURI(sex1);
	var se;
	if (sex2 == "男") {
		se = "女";
	} else {
		se = "男";
	}

	console.log(se);
	// 请求数据:
	$.ajax({
		type : "get",
		url : "home",
		async : true,
		data : {
			sex : se
		},
		success : function(res) {
			console.log(res);
			var re = JSON.parse(res);
			console.log(re);
			// 获取对象中数据:
			// 遍历:
			var arr = re.con;
			console.log(arr.length)
			$.each(arr, function(i, itm) {
				// 获取数据:
				var name = itm.name;
				var uid = itm.uid;
				var age = itm.age;
				var address = itm.address;
				// 获取图片的地址:
				var pic = itm.picture.paddress;
				// 创建标签:
				var li = document.createElement("li");
				li.setAttribute("id", uid);
				li.setAttribute("class", "showFlag fadeFromLeft");
				var div1 = document.createElement("div");
				div1.setAttribute("class", "user-item front clearfix");
				// div1.setAttribute("id", uid);
				var div2 = document.createElement("div");
				div2.setAttribute("class", "photo");
				// div2.setAttribute("id", uid);
				var a = document.createElement("a");
				// a.setAttribute("id", uid);
				var img = document.createElement("img");
				// img.setAttribute("id", uid);
				img.setAttribute("src", pic);
				var div3 = document.createElement("div");
				// div3.setAttribute("id", uid);
				div3.setAttribute("class", "user-info");
				var h3 = document.createElement("h3");
				var a1 = document.createElement("a");
				a1.setAttribute("class", "name");
				// a1.setAttribute("id", uid);

				var a3 = document.createElement("a");
				a3.setAttribute("class", "flag-zx");
				// a3.setAttribute("id", uid);
				var a4 = document.createElement("a");
				a4.setAttribute("class", "flag-mobile");
				// a4.setAttribute("id", uid);
				var a5 = document.createElement("a");
				a5.setAttribute("class", "flag-iden");
				// a5.setAttribute("id", uid);
				var a6 = document.createElement("a");
				a6.setAttribute("class", "flag-credit credit-js");
				// a6.setAttribute("id", uid);
				a6.innerText = "满分";
				a1.innerText = name;
				h3.appendChild(a1);
				h3.appendChild(a3);
				h3.appendChild(a4);
				h3.appendChild(a5);
				h3.appendChild(a6);

				var p1 = document.createElement("p");
				p1.setAttribute("class", "base");
				// p1.setAttribute("id", uid);
				p1.innerText = age + ", " + address + ",";
				var p2 = document.createElement("p");
				p2.setAttribute("class", "heart-word");
				// p2.setAttribute("id", uid);
				p2.innerText = "正在寻找：。。。。。。";
				var p3 = document.createElement("p");
				p3.setAttribute("class", "user-point");
				// p3.setAttribute("id", uid);

				// 写一个数组:
				var arrv = [ "推荐理由：TA刚注册珍爱，先到先得哦", "推荐理由：身材不错哦",
						"推荐理由：你们教育情况差不多，沟通无障碍哦", "推荐理由：你的条件优秀，很容易打动对方哦",
						"推荐理由：考虑一下撒？你绝对可以给对方幸福的？", "推荐理由：车子已有，你愿意做对方的司机吗？",
						"推荐理由：考虑一下撒？你绝对可以给对方幸福的？" ];
				// 随机添加推荐理由：
				var ran = Math.random() * 7 + 0;
				var ran1 = Math.floor(ran);
				console.log(ran1);
				p3.innerText = arrv[ran1];

				// 添加标签:

				ul.appendChild(li);
				li.appendChild(div1);
				div1.appendChild(div2);
				div1.appendChild(div3);
				div2.appendChild(a);
				a.appendChild(img);

				div3.appendChild(h3);
				div3.appendChild(p1);
				div3.appendChild(p2);// b1
				div3.appendChild(p3);// b2

			});

			$.ajax({
				type : "get",
				url : "home1",
				async : true,
				data : {
					uid : id1
				},
				success : function(res) {

					var arr1 = JSON.parse(res);
					console.log(arr1.userp);
					// 或对象中的数据:
					var userp = arr1.userp;
					var name = userp[0].name;
					var age = userp[0].age;
					var uid = userp[0].uid;
					var paddress = userp[0].picture.paddress;
					var pname = userp[0].picture.pname;
					var myid = document.querySelector(".grayL");
					console.log(myid);
					myid.innerText = "******";
					var myname = document.querySelector(".myname");
					myname.innerText = name;
					var mydiv = document.querySelector(".user-100");
					var mya = document.createElement("a");
					mya.setAttribute("target", "_blank");
					// var mya = document.createElement("img");
					var myimg = document.createElement("img");
					myimg.setAttribute("src", paddress);
					mydiv.appendChild(mya);
					mya.appendChild(myimg);

				},
			});

			// 首页展示图片的点击事件
			for (var i = 0; i < ul.getElementsByTagName("li").length; i++) {
				ul.children[i].onclick = function(res, e) {
					var even = e || event;
					even.stopPropagation();
					var uuid = res.path[4].id;
					location.href = "person.html?id=" + uuid;
				}
			}

			// 同城匹配的点击事件
			var div2 = document.querySelector("#search");
			div2.onclick = function() {

				console.log(id1);
				location.href = "person1.html?id=" + id1;
			}

			// 异城匹配的点击事件
			var div2 = document.querySelector("#search2");
			div2.onclick = function() {

				console.log(id1);
				location.href = "person2.html?id=" + id1;
			}

			// 修改密码的点击事件
			var updatepsw = document.querySelector("#updatepsw");
			updatepsw.onclick = function() {
				location.href = "updatepsw.html?id=" + id1;
			}

			// 首页的点击事件
			var div1 = document.getElementById("home");
			div1.onclick = function() {
				location.href = "home.html?id=" + id1 + "&sex=" + sex1;
			}

			// 退出的点击事件
			var div4 = document.getElementById("exit");
			div4.onclick = function() {
				location.href = "login.html";
			}

			// 个人中心的点击事件
			var div3 = document.getElementById("person");
			div3.onclick = function() {
				location.href = "person.html?id =" + id1;
			}

		},

	});

}

// 获取标签:
var ul = document.querySelector(".ck-slide-wrapper");
// 获取子类标签数组:
var li = ul.children;
console.log(li[0]);
console.log(li[1]);
// 定义一个标识:
var b = true;
// 判断是否隐藏:
// 一个定时器的方法:
setInterval(function() {
	// 判断:
	if (b) {
		// 给子类标签设置样式:
		li[0].style.display = "block"; // 显示
		li[1].style.display = "none"; // 隐藏
		// 改变b值:
		b = false;
	} else {
		// 给子类标签设置样式:
		li[1].style.display = "block";
		li[0].style.display = "none";
		b = true;
	}

}, 1000); // 定时器设置的时间，单位为毫秒
