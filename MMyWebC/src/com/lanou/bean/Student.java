package com.lanou.bean;

/**
 *
 * @author LiuXu
 * @time2018年8月24日下午10:15:16
 **/
public class Student {

	private int id;
	private String name;
	private String sex;
	private double math;
	private double english;
	private double chinese;

	public Student() {
		super();
	}

	public Student(int id, String name, String sex, double math, double english, double chinese) {
		super();
		this.id = id;
		this.name = name;
		this.sex = sex;
		this.math = math;
		this.english = english;
		this.chinese = chinese;
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

	public double getMath() {
		return math;
	}

	public void setMath(double math) {
		this.math = math;
	}

	public double getEnglish() {
		return english;
	}

	public void setEnglish(double english) {
		this.english = english;
	}

	public double getChinese() {
		return chinese;
	}

	public void setChinese(double chinese) {
		this.chinese = chinese;
	}

}
