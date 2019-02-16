package com.lanou.bean;

import java.io.Serializable;

/**
 *
 * @author LiuXu
 * @time2018年7月11日下午7:03:07
 **/
public class User implements Serializable{

	private int uid;// 用户的id，唯一的标示
	private String name;// 用户姓名
	private int age;// 用户年龄
	private String sex;// 性别
	private String address;// 用户地址
	private String psw;// 用户密码
	private String answer;// 密保数字
	private Car car;
	
	public User() {
		super();
	}

	
	
	public User(int uid, String name, String psw, Car car) {
		super();
		this.uid = uid;
		this.name = name;
		this.psw = psw;
		this.car = car;
	}



	public Car getCar() {
		return car;
	}



	public void setCar(Car car) {
		this.car = car;
	}



	public User(int uid, String name, String psw) {
		super();
		this.uid = uid;
		this.name = name;
		this.psw = psw;
	}



	public User(String name, String sex, String psw) {
		super();
		this.name = name;
		this.sex = sex;
		this.psw = psw;
	}



	public User(int uid, String name, String sex, String psw) {
		super();
		this.uid = uid;
		this.name = name;
		this.sex = sex;
		this.psw = psw;
	}



	public User(String name, int age, String sex, String address, String psw, String answer) {
		super();
		this.name = name;
		this.age = age;
		this.sex = sex;
		this.address = address;
		this.psw = psw;
		this.answer = answer;
	}



	public User(int uid, String name, int age, String sex, String address, String psw, String answer) {
		super();
		this.uid = uid;
		this.name = name;
		this.age = age;
		this.sex = sex;
		this.address = address;
		this.psw = psw;
		this.answer = answer;
	}

	@Override
	public String toString() {
		return "User [uid=" + uid + ", name=" + name + ", age=" + age + ", sex=" + sex + ", address=" + address
				+ ", psw=" + psw + ", answer=" + answer + "]";
	}

	public int getUid() {
		return uid;
	}

	public void setUid(int uid) {
		this.uid = uid;
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

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPsw() {
		return psw;
	}

	public void setPsw(String psw) {
		this.psw = psw;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

}
