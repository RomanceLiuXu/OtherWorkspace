<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset=UTF-8>
<title>文件上传</title>
</head>
<body>
<fieldset>
<legend>文件上传</legend>
<form action="uploads.do" method="post" enctype="multipart/form-data">
<input type="file" name="uploadFiles" multiple="multiple"/>
<input type="submit" value="上传"/>
</form>
<a href="myFile/download.do">下载</a>
</fieldset>

</body>
</html>