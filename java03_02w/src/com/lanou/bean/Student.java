package com.lanou.bean;
/**
* 学生类
* @author LiuXu
* @time2018年7月26日下午7:23:29
**/
public class Student {
   
	private int id;
	private String name;
	private String sex;
	private int age;
	private int mathScore;
	private int chineseScore;
	
	public Student() {
		super();
	}
	public Student(int id, String name, String sex, int age, int mathScore, int chineseScore) {
		super();
		this.id = id;
		this.name = name;
		this.sex = sex;
		this.age = age;
		this.mathScore = mathScore;
		this.chineseScore = chineseScore;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public int getMathScore() {
		return mathScore;
	}
	public void setMathScore(int mathScore) {
		this.mathScore = mathScore;
	}
	public int getChineseScore() {
		return chineseScore;
	}
	public void setChineseScore(int chineseScore) {
		this.chineseScore = chineseScore;
	}
	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", sex=" + sex + ", age=" + age + ", mathScore=" + mathScore
				+ ", chineseScore=" + chineseScore + "]";
	}
	
	
	
}
