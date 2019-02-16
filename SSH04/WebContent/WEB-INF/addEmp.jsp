<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset=UTF-8>
<title>标题</title>
</head>
<body>
<form action="addEmp.do" method="post">
<fieldset>
<label>添加员工</label><br/>
姓名:<input type="text" name="uname"/><br/>
性别:
男:<input type="radio" name="gender" value="m"/>
女:<input type="radio" name="gender" value="f"/>
<br/>
年龄:<input type="number" name="age"/><br/>
生日:<input type="date" name="birth"/><br/>
调色板:<input type="color" name="color"/>
<input type="submit" value="添加"/>${msg }
</fieldset>

</form>
</body>
</html>