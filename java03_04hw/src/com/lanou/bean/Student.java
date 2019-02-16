package com.lanou.bean;

/**
 *
 * @author LiuXu
 * @time2018年7月30日下午8:14:52
 **/
public class Student {

	private String code;
	private String psw;
	private int age;
	private String sex;

	public Student() {
		super();
	}

	public Student(String code, String psw, int age, String sex) {
		super();
		this.code = code;
		this.psw = psw;
		this.age = age;
		this.sex = sex;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getPsw() {
		return psw;
	}

	public void setPsw(String psw) {
		this.psw = psw;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

}
