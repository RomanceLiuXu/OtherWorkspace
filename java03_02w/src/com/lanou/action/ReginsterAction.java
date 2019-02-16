package com.lanou.action;

/**
 *
 * @author LiuXu
 * @time2018年7月26日下午8:27:04
 **/
public class ReginsterAction {

	private String rcode;
	private String rpsw;
	private String sex;
	private String hobby;
	private String msg;
	
	public String reginster() {
		
		return "success";
	}
	

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public String getRcode() {
		return rcode;
	}

	public void setRcode(String rcode) {
		this.rcode = rcode;
	}

	public String getRpsw() {
		return rpsw;
	}

	public void setRpsw(String rpsw) {
		this.rpsw = rpsw;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getHobby() {
		return hobby;
	}

	public void setHobby(String hobby) {
		this.hobby = hobby;
	}

}
