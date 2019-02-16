package com.lanou.bean;

import java.io.Serializable;

/**
 *
 * @author LiuXu
 * @time2018年8月1日上午9:16:01
 **/
public class User implements Serializable{

	private int uid;
	private String name;
	private String psw;
    private String sex;
	
	public User() {
		super();
	}

	public User(int uid, String name, String psw, String sex) {
		super();
		this.name = name;
		this.psw = psw;
		this.sex = sex;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPsw() {
		return psw;
	}

	public void setPsw(String psw) {
		this.psw = psw;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public int getUid() {
		return uid;
	}

	public void setUid(int uid) {
		this.uid = uid;
	}

}
