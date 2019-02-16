<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

	<head>
		<meta charset="UTF-8">
		<title>计算器</title>
	</head>

	<body>
		<div style="font-size: 20px;">算术计算器</div>
		<br>
		<form action="http://localhost:8080/java03_03w/counter" method="post">
			第一个数:
			<input type="text" name="num1" /> <br /> 第二个数:
			<input type="text" name="num2" /> <br />
			<input type="submit" name="operation" value="加" />
			<input type="submit" name="operation" value="减" />
			<input type="submit" name="operation" value="乘" />
			<input type="submit" name="operation" value="除" />
		</form>
	</body>
	<script type="text/javascript">
		var ins = document.getElementsByTagName("input");
		//点击事件
		for(var i = 2; i < ins.length; i++) {
			ins[i].onclick = function() {
// 				console.log(this.value);
				return IsNull();
			}
		}
		//非空的判断
		function IsNull() {
			if(ins[0].value == null || ins[0].value == "" || ins[1].value == null || ins[1].value == "") {
				alert("输入不能为空");
				return false;
			} else if(!IsNum(ins[0].value) || !IsNum(ins[1].value)) {
				alert("只能输入数字");
				return false;
			}
			return true;
		}
		//判断是否为数字的方法
		function IsNum(num) {
			var reNum = /^\d*$/;
			return(reNum.test(num));

		}
	</script>

</html>