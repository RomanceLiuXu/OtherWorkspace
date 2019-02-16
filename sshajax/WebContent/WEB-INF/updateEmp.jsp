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
			<label>修改员工</label><br /> 姓名:<input type="text" name="uname" onblur="checkName()"/><span></span><br />
			<input name="id" value="${param.id }" hidden="hidden"/>
			性别: 男:<input type="radio" name="gender" value="m" /> 
			女:<input type="radio" name="gender" value="f" /> <br />
			年龄:<input type="number" name="age" /><br /> 
			<input type="button" value="修改"/>
		</fieldset>
	</form>
</body>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery-2.2.4.min.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery.serializeJson-min.js"></script>
<script type="text/javascript">

function checkName(){
	$.ajax({
		type:"post",
		url:"checkName.do",
		data:"uname="+$("input[name='uname']").val(),
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
					updateEmp();
				}); 
			}
		}
	});
	
}


function updateEmp(){
	var jsonObj = $("form").serialize();
	$.ajax({
		type:"post",
		url:"updateEmp.do",
		data:jsonObj,
		success:function(data){
			console.log(data);
			if(data){
				location.href="listAll.do";
			}else{
				alert("修改失败");
			}
		}
	});
}

</script>
</html>