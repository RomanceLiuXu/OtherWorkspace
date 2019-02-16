package com.lanou.bean;
/**
*
* @author LiuXu
* @time2018年7月30日下午9:54:18
**/
public class Employee {

	private String name;
	private String sex;
	private int age;
	public Employee() {
		super();
	}
	public Employee(String name, String sex, int age) {
		super();
		this.name = name;
		this.sex = sex;
		this.age = age;
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
	@Override
	public String toString() {
		return "Employee [name=" + name + ", sex=" + sex + ", age=" + age + "]";
	}
	
	
	
	
}
