<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset=UTF-8>
<title>标题</title>
</head>
<body>
	<!-- 上传文件
1.提交方式:post
2.编码方式:enctype="multipart/form-data" 可以传二进制字节文件
  表单的默认编码方式：文本
  enctype="application/x-www-form-urlencoded"
 -->
	<form action="upload" method="post" enctype="multipart/form-data">
	<!-- fieldset:画框 -->
		<fieldset>
			<legend>文件上传</legend>
			选择文件<input type="file" name="myFile" /> <br> 
			<input type="submit" value="上传" />
		</fieldset>
	</form>

</body>
</html>