<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset=UTF-8>
<title>标题</title>
<style type="text/css">
</style>
</head>
<body>
	<form action="addEmp.do" method="post">
		<fieldset>
			<label>添加员工</label><br /> 姓名:<input type="text" name="uname" onblur="checkName()"/><span></span><br />
			性别: 男:<input type="radio" name="gender" value="m" /> 
			女:<input type="radio" name="gender" value="f" /> <br />
			年龄:<input type="number" name="age" /><br /> 
			生日:<input type="date" name="birth" /><br />
			<input type="button" value="添加"/>
		</fieldset>
	</form>
</body>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery-2.2.4.min.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery.serializeJson-min.js"></script>
<script type="text/javascript">

function checkName(){
	var uname = $("input[name='uname']").val();
	if(uname==""){
		$("span").html("<small>用户名不能为空</small>");
		$("span").css("color","red");
		return;
	}
	$.ajax({
		type:"post",
		url:"checkName.do",
		data:"uname="+uname,
		success:function(res){
			if(res){
				/* 用户名重复 */
				$("span").html("<small>用户名重复</small>");
				$("span").css("color","red");
			}else{
				$("span").html("<small>用户名可用</small>");
				$("span").css("color","green");
				/* $("input[type='button']").on("click",function(){
					addEmp();
				}); */
				/* 可执行添加操作 */
				 $("input[type='button']").click(function(){
					addEmp();
				}); 
			}
		}
	});
	
}


function addEmp(){
	var jsonObj = $("form").serializeJson();
	var jsonStr = JSON.stringify(jsonObj);
	$.ajax({
		type:"post",
		url:"addEmp.do",
		data:jsonStr,
		contentType:"application/json",
		success:function(data){
			console.log(data);
			if(data){
				location.href="listAll.do";
			}else{
				alert("添加失败");
			}
		}
	});
}

</script>
</html>