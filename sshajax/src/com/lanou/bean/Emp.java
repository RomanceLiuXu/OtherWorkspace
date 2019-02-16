package com.lanou.bean;

import java.io.Serializable;

/**
 *
 * @author LiuXu
 * @time2018年9月9日下午2:16:39
 **/
public class Emp implements Serializable {

	private int id;
	private String uname;
	private String gender;
	private int age;

	public Emp() {
		super();
	}

	public Emp(int id, String uname, String gender, int age) {
		super();
		this.id = id;
		this.uname = uname;
		this.gender = gender;
		this.age = age;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUname() {
		return uname;
	}

	public void setUname(String uname) {
		this.uname = uname;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

}
