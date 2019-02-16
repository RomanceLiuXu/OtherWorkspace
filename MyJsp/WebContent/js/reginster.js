//1:地址选择二级联动
var arr1 = [ "西安", "咸阳", "渭南", "延安", "汉中", "商洛", "安康", "榆林", "延安", "宝鸡", "铜川" ];
var arr2 = [ "太原", "大同", "运城", "大同市", "阳泉市", "朔州市", "长治", "吕梁", "晋中", "临汾" ];
var arr3 = [ "广州市", "深圳市", "珠海", "汕头市", "佛山市", "韶关市", "湛江市", "江门市", "惠州市",
		"东莞市" ];
var province = document.querySelector(".mid1_5");
var city = document.querySelector(".mid1_6");
// 设置下拉框的change事件
province.onchange = function() {
	var n = city.children.length;
	for (var i = 1; i < n + 1; i++) {
		// 清空城市标签中的数据
		// city.remove(city.children[i]);
		city.innerHTML = "";
		city.innerHTML = "<option>城市</option>";
	}
	// 根据不同的选项填充城市数据
	if (province.value == "陕西") {
		method1(arr1);
	} else if (province.value == "山西") {
		method1(arr2);
	} else if (province.value == "广东") {
		method1(arr3);
	}
}

// 填充城市的方法
function method1(arr) {
	// 遍历数组
	for (var i = 0; i < arr.length; i++) {
		// 创建节点并向select中添加数据
		var op = document.createElement("option");
		op.innerText = arr[i];
		city.appendChild(op);
	}
}

// 2:获取用户注册信息并判断,如果符合要求,则利用ajxa请求传送给后台
var body = document.getElementsByTagName("body")[0];
var usename = document.getElementById("usename");
var usepsw1 = document.getElementById("usepsw1");
var usepsw2 = document.getElementById("usepsw2");
var usepswsave = document.getElementById("usepswsave");
var useage = document.getElementById("useage");
var input = document.querySelector(".sex");
var present = document.getElementById("present");
var procoloread = document.querySelector(".procoloread");
var sexsend;
var provincesendandcitysend;

// 总方法向servlet发送数据
present.onclick = function() {
	if (!method2(usename, '用户名错误')) {
		return;
	}
	if (!method2(usepsw1, "密码输入错误")) {
		return;
	}
	// 判断两次输入的密码是否一致
	if (usepsw1.value != usepsw2.value) {
		// 如果不满足则弹出alert
		alert("前后两次密码不一致");
		return;
	}
	if (!method2(usepswsave, "密保数字输入错误")) {
		return;
	}

	// 判断密报数字是否为空
	if (usepswsave.value < 0 || usepswsave.value > 9999) {
		alert("请输入正确的密保数字,方便您以后找回密码");// 密保数字有问题还需解决
		return;
	}

	if (!method2(useage, "年龄错误")) {
		return;
	}
	if (useage.value < 0 || useage.value > 120) {
		alert("请您输入正确的年龄");
		return;
	}

	if (input.checked == true) {
		sexsend = input.value;
	} else {
		sexsend = "女";
	}
	if (province.value != "省份" && city.value != "城市") {
		provincesendandcitysend = province.value + city.value;
	} else {
		alert("请选择城市");
		return;
	}

	if (procoloread.checked != true) {
		alert("请先阅读协议");
		return;
	}
	method3();
}
function method3() {
	$.ajax({
		type : "post",
		url : "../register",
		data : {
			// uid:"",
			// 暂时不传ID了
			name : usename.value,
			age : useage.value,
			sex : sexsend,
			address : provincesendandcitysend,
			psw : usepsw1.value,
			snswer : usepswsave.value
		},
		async : true,
		success : function(res) {
			// 此处返回一个boolean类型的值,如果为true,则显示注册成功,如果错误,则显示注册失败(用户名已经存在)
			// 此处返回一个boolean类型的值,如果为true,则显示注册成功,如果错误,则显示注册失败
			// (用户名已经存在)
			if (res!="-1") {
				location.href = "jsp/photoup.jsp?uid=" + res;
			} else {
				body.innerText = "注册失败--用户名已存在";
			}

		}
	});

}

// 输入框判断
// intput--输入框对象
// str--提示的内容
function method2(input, str) {
	if (input.value == null || input.value == "") {
		// 如果不满足要求则弹出alert
		alert(str);
		return false;
	}
	return true;
}
