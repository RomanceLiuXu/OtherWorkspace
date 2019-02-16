package com.lanou.bean;
/**
*
* @author LiuXu
* @time2018年8月22日上午10:00:21
**/
public class School {

	private Teacher teacher;
	private Student student;
	
	public void show(){
		teacher.show();
		student.show();
	}
	
	public Teacher getTeacher() {
		return teacher;
	}
	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}
	public Student getStudent() {
		return student;
	}
	public void setStudent(Student student) {
		this.student = student;
	}
	
	
	
	
	
}
