package com.lanou.bean;

import java.util.List;

/**
 *
 * @author LiuXu
 * @time2018年9月19日下午3:11:34
 **/
public class Teacher {

	private int tid;
	private String tname;
	private String xueke;
	private List<Student> students;// 当前teacher关联的多个学生
	
	public Teacher() {
		super();
	}
	public Teacher(int tid, String tname, String xueke, List<Student> students) {
		super();
		this.tid = tid;
		this.tname = tname;
		this.xueke = xueke;
		this.students = students;
	}
	
	@Override
	public String toString() {
		return "Teacher [tid=" + tid + ", tname=" + tname + ", xueke=" + xueke + "]";
	}
	public int getTid() {
		return tid;
	}
	public void setTid(int tid) {
		this.tid = tid;
	}
	public String getTname() {
		return tname;
	}
	public void setTname(String tname) {
		this.tname = tname;
	}
	public String getXueke() {
		return xueke;
	}
	public void setXueke(String xueke) {
		this.xueke = xueke;
	}
	public List<Student> getStudents() {
		return students;
	}
	public void setStudents(List<Student> students) {
		this.students = students;
	}
	
	
	
}
