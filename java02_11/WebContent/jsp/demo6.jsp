<%@page import="com.lanou.Student"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset=UTF-8>
<title>java方法和对象</title>
</head>
<body>

	<%!public void method1() {
		System.out.print("java方法");
	}%>
	<!-- 调用方法 -->
	<%
		method1();
	%>
	
	<!-- 实例化实体类对象 -->
	
	<%
	
	Student student  =  new Student("lhl","女",18);
	 System.out.print(student); 
	
	%>
	
	<<%-- %!
	public void test(){
		System.out.print(student.getAge());
	}
	
	%> --%>
	
	
	<!-- 方法的调用 -->
	<% 
	
	mytest(1);
	%>
	
	<!-- 定义一个java方法，要申明在外部，方法中不能再声明方法 -->
	<%!
	
	public void mytest(int n){
		if(n > 0){
			System.out.print("我大于0");
		}else{
			System.out.print("我小于等于0");
		}
	}
	
	%>
	
	<!--对象的实例化 (方法中的实例化)-->
	<% 
	Student stu = new  Student("kk","nan",15);
	
	%>
	
	<!--对象的实例化 (全局的对象)-->
	<%!
	Student stud = new  Student("kk","nan",15);
	
	%>
</body>
</html>