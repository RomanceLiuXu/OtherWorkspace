package com.lanou;

/**
 *
 * @author LiuXu
 * @time2018年7月2日下午9:24:07
 **/
public class Person {
	private int id;// id
	private String code;// 用户名
	private String psw;// 密码

	public Person() {
		super();
	}

	public Person(int id, String code, String psw) {
		super();
		this.id = id;
		this.code = code;
		this.psw = psw;
	}

	@Override
	public String toString() {
		return "Person [id=" + id + ", code=" + code + ", psw=" + psw + "]";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

}
