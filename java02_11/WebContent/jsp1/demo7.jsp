<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset=UTF-8>
<title>作业5</title>
</head>
<body>
     <input type="text" name="num1">
		<select name="select">
			<option>+</option>
			<option>-</option>
			<option>*</option>
			<option>/</option>
		</select>
		<br/>
		<input type="text" name="num2">
		<br/>
		<input type="button" value="求和" id="bt">
		<div id="class1">

		</div>
</body>
<script type="text/javascript">
		var num1 = document.getElementsByName("num1")[0];
		var num2 = document.getElementsByName("num2")[0];
		var mid = document.getElementsByName("select")[0];
		var div = document.getElementById("class1");
		var bt = document.getElementById("bt");

		bt.onclick = function() {
			if(num1.value != "" && num2.value != "") {
				var n1 = parseInt(num1.value);
				var n2 = parseInt(num2.value);
				var result = method1(n1, n2);
				div.innerText = result;
			}
		}

		function method1(n1, n2) {
			var flag = mid.value;
			var sum;
			if(flag == "+") {
				//加法
				sum = n1 + n2;

			} else if(flag == "-") {
				sum = n1 - n2;
			} else if(flag == "*") {
				sum = n1 * n2;
			} else {
				if(n2 != 0) {
					sum = n1 / n2;
				} else {
					alert("除数不能为0");
				}
			}
			return sum;
		}
	</script>
</html>