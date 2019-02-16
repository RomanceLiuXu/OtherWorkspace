package com.liuxu.beans;

/**
 *
 * @author LiuXu
 * @time2018年8月18日下午3:05:18
 **/
public class User {

	 private int uid;//标识
	 private String name;//姓名
	 private int age;//年龄
	 private String sex;//性别
	 private String address;//地址
	 private String psw;//密码
	 private String answer;//密保
	 private Picture picture;//用户对应的图片信息
	
	 
	 public User() {
		super();
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


	public User(String name, int age, String sex, String address, String psw, String answer, Picture picture) {
		super();
		this.name = name;
		this.age = age;
		this.sex = sex;
		this.address = address;
		this.psw = psw;
		this.answer = answer;
		this.picture = picture;
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

	public User(int uid, String name, int age, String sex, String address, String psw, String answer,
			Picture picture) {
		super();
		this.uid = uid;
		this.name = name;
		this.age = age;
		this.sex = sex;
		this.address = address;
		this.psw = psw;
		this.answer = answer;
		this.picture = picture;
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
	public Picture getPicture() {
		return picture;
	}
	public void setPicture(Picture picture) {
		this.picture = picture;
	}

	@Override
	public String toString() {
		return "User [uid=" + uid + ", name=" + name + ", age=" + age + ", sex=" + sex + ", address=" + address
				+ ", psw=" + psw + ", answer=" + answer + ", picture=" + picture + "]";
	}
	
	 
	 
	 
}
