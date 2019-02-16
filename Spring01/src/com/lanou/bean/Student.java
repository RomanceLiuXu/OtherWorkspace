package com.lanou.bean;

/**
 *
 * @author LiuXu
 * @time2018年8月22日上午9:42:20
 **/
public class Student {

	private String name;
	private int age;

	public void show() {
		System.out.println("name:" + name);
		System.out.println("age:" + age);
	}

	public Student() {
		super();
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

}
