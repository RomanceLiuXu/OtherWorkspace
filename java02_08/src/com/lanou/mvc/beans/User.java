package com.lanou.mvc.beans;
/**
*
* @author LiuXu
* @time2018年7月9日下午4:56:55
**/
public class User {

	private int id;
	private String code;
	private String psw;
	
	
	public User() {
		super();
	}
	public User(int id, String code, String psw) {
		super();
		this.id = id;
		this.code = code;
		this.psw = psw;
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
