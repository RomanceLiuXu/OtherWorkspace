package com.lanou.bean;

/**
 *
 * @author LiuXu
 * @time2018年7月30日上午9:54:34
 **/
public class User {

	private String name;
	private String psw;

	public User() {
		super();
	}

	public User(String name, String psw) {
		super();
		this.name = name;
		this.psw = psw;
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

	@Override
	public String toString() {
		return "User [name=" + name + ", psw=" + psw + "]";
	}

}
