<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset=UTF-8>
<title>标题</title>
<style type="text/css">
* {
	font-size: 30px;
}

body {
	background-image: url("/SSHAjax/image/aa.jpg");
	background-size: cover;
	position: relative;
}

table tr td {
	text-align: center;
}

.row0 {
	background-color: red;
}

.row1 {
	background-color: green;
}
#add{
float: right;
font-size: 30px;
text-decoration: none;
color: black;
}
#add:hover{
color: yellow;
text-decoration: underline;
}
#div1{
position: absolute;
left: 0;
right: 0;
bottom: 0;
top: 0;
margin:  auto;

}
</style>
<link rel="stylesheet" type="text/css" href="css/layui.css"/>
</head>
<body>
<a href="toAddEmp.do" id="add">添加</a>
	<table border="2px" cellpadding="10px" align="center"
		style="border-collapse: collapse">
		<caption>员工列表</caption>
		<thead>
			<tr>
				<td>id</td>
				<td>uname</td>
				<td>gender</td>
				<td>age</td>
				<td>do</td>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${emps }" var="emp" varStatus="s">
				<tr class="row${s.index%2 }">
					<td>${emp.id }</td>
					<td>${emp.uname }</td>
					<td>${emp.gender }</td>
					<td>${emp.age }</td>
					<td><button type="button" class="layui-btn layui-btn-normal" value="${emp.id }" name="update">修改</button>&nbsp;&nbsp;&nbsp;<button type="button" value="${emp.id }" class="layui-btn layui-btn-danger" name="delete">删除</button></td>
				</tr>
			</c:forEach> 
		</tbody>
	</table>
	<div id="div1" style="display: none;">
	<form action="addEmp.do" method="post">
			<label>修改员工</label><br /> 姓名:<input type="text" name="uname" onblur="checkName()"/><small></small><br />
			<input name="id"  hidden="hidden"/>
			性别: 男:<input type="radio" name="gender" value="m" /> 
			女:<input type="radio" name="gender" value="f" /> <br />
			年龄:<input type="number" name="age" /><br /> 
			<input type="button" value="修改" class="layui-btn layui-btn-normal"/>
	</form>
	</div>
</body>
   
<script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery-2.2.4.min.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery.serializeJson-min.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/layer.js"></script>

<script type="text/javascript">



/* $(function(){

	$("button[name='update']").click(function() {

        str = $(this).text()=="修改"?"确定":"修改";  

        $(this).text(str);   // 按钮被点击后，在“编辑”和“确定”之间切换

        $(this).parent().siblings("td").each(function() {  // 获取当前行的其他单元格

            obj_text = $(this).find("input:text");    // 判断单元格下是否有文本框

            if(!obj_text.length)   // 如果没有文本框，则添加文本框使之可以编辑

                $(this).html("<input type='text' value='"+$(this).text()+"'>");

            else   // 如果已经存在文本框，则将其显示为文本框修改的值

                $(this).html(obj_text.val()); 

        });

    });
});
 */

    $("button[name='delete']").click(function(){
    	   if(confirm("确定删除吗?")){
    		   $.ajax({
    	    	   type:"post",
    	    	   url:"deleteEmp.do",
    	    	   data:"id="+$(this).val(),
    	    	   success:function(res){
    	    		   if(res){
    	    			   alert("删除成功");
    	    			   location.href="listAll.do";
    	    		   }
    	    	   }
    	      });
    	   }
    });
    	   
     $("button[name='update']").click(function(){
    	 $("input[name='id']").val($(this).val());
    	//在这里面输入任何合法的js语句
    	 layer.open({
    	   type: 1, //Page层类型
    	   area: ['800px', '600px'],
    	   title: '修改用户',
    	   shade: 0.6 ,//遮罩透明度
    	   closeBtn: 1,//显示关闭按钮 
    	  /*  maxmin: true, //允许全屏最小化  */
    	   shadeClose:true,
    	   anim: 1 ,//0-6的动画形式，-1不开启
    	   skin:'layui-layer-molv',
    	   content: $("#div1")
    	 }); 

    	 /*  location.href="toUpdate.do?id="+$(this).val(); */
    	   
    }); 
   
     function checkName(){
    	 var uname = $("input[name='uname']").val();
    		if(uname==""){
    			$("small").text("用户名不能为空");
    			$("small").css("color","red");
    			return;
    		}
    		$.ajax({
    			type:"post",
    			url:"checkName.do",
    			data:"uname="+uname,
    			success:function(res){
    				if(res){
    					/* 用户名重复 */
    					$("small").text("用户名重复");
    					$("small").css("color","red");
    				}else{
    					$("small").html("用户名可用");
    					$("small").css("color","green");
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
    
    	

/* $(document).ready(function(){
	$.ajax({
		type:"post",
		url:"listAll.do",
		success:function(data){
			for(var i=0;i<data.length;i++){
			   var jsonObj = data[i];
           	   var $tr=$("<tr><td>"+jsonObj.id+"</td><td>"+jsonObj.uname+"</td><td>"+jsonObj.gender+"</td><td>"+jsonObj.age+"</td></tr>");
               $("tbody").append($tr);
			}
		}
	}); 
});*/


</script>
</html>