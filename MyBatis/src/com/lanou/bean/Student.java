package com.lanou.bean;

import java.util.List;

/**
 *
 * @author LiuXu
 * @time2018年9月19日下午3:11:43
 **/
public class Student {

	private int sid;
	private String sname;
	private String sex;
	private List<Teacher> teachers;
	
	public Student() {
		super();
	}
	@Override
	public String toString() {
		return "Student [sid=" + sid + ", sname=" + sname + ", sex=" + sex + "]";
	}
	public Student(int sid, String sname, String sex, List<Teacher> teachers) {
		super();
		this.sid = sid;
		this.sname = sname;
		this.sex = sex;
		this.teachers = teachers;
	}
	public int getSid() {
		return sid;
	}
	public void setSid(int sid) {
		this.sid = sid;
	}
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public List<Teacher> getTeachers() {
		return teachers;
	}
	public void setTeachers(List<Teacher> teachers) {
		this.teachers = teachers;
	}
	
	
}
