<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset=UTF-8>
<title>标题</title>
<script type="text/javascript"
	src="<%=request.getContextPath()%>/js/jquery-2.2.4.min.js"></script>
<script type="text/javascript">
	//点击事件向springMvc发送请求，并获取返回回来的数据
	function getData() {
		$.ajax({
			type : "get",
			url : "ajax5.do",
			success : function(data) {//接收服务器返回的数据
				console.log(data, typeof data);
                for(var i=0;i<data.length;i++){
                	   //console.log(data[i]);
                	   var jsonObj = data[i];
                	   var $tr=$("<tr><td>"+jsonObj.id+"</td><td>"+jsonObj.username+"</td><td>"+jsonObj.password+"</td></tr>");
                	  /*  var $tdId=$("<td></td>");
                	   var $tdName=$("<td></td>");
                	   var $tdPsw=$("<td></td>");
                	   $tdId.text(jsonObj.id);
                	   $tdName.text(jsonObj.username);
                	   $tdPsw.text(jsonObj.password);
                	   $tr.append($tdId);
                	   $tr.append($tdName);
                	   $tr.append($tdPsw); */
                	   $("table").append($tr);
                }
				 //JSON对象转JSON字符串
				var jsonStr = JSON.stringify(data);
				console.log(jsonStr, typeof jsonStr);
				//JSON字符串转JSON对象
				var jsonObj = JSON.parse(jsonStr);
				//或者
				var jsonObj1 = eval("("+jsonStr+")");
				console.log(jsonObj); 
			}
		});
	}
</script>
</head>
<body>
	<button onclick="getData()">获取数据</button>
	<hr />
	<table border="1">
		<tr>
			<td>编号</td>
			<td>账号</td>
			<td>密码</td>
		</tr>
	</table>
</body>
</html>