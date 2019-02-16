package com.lanou.ref;

/**
 *
 * @author LiuXu
 * @time2018年7月25日下午2:23:45
 **/
public class Person {

	private String name;
	protected int age;
	public double height;

	public Person(String name, int age, double height) {
		super();
		this.name = name;
		this.age = age;
		this.height = height;
	}

	public Person(String name) {
		super();
		this.name = name;
	}
	
	public Person() {
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

	public double getHeight() {
		return height;
	}

	public void setHeight(double height) {
		this.height = height;
	}

	private void test() {
		System.out.println("私有方法");
	}

	protected void pro(int a) {
		System.out.println("a:" + a);
	}

}
