package com.lanou;

import java.io.Serializable;

/**
 * 学生的实体类
 * 
 * @author LiuXu
 * @time2018年7月5日下午4:35:56
 **/
public class StudentE implements Serializable {

	private String name;
	private int age;
	private String sex;

	public StudentE(String name, int age, String sex) {
		super();
		this.name = name;
		this.age = age;
		this.sex = sex;
	}

	public StudentE() {
		super();
	}

	@Override
	public String toString() {
		return "StudentE [name=" + name + ", age=" + age + ", sex=" + sex + "]";
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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
