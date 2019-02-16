package com.lanou.action;

/**
 *
 * @author LiuXu
 * @time2018年7月28日上午10:11:50
 **/
public class ReginsterAction {

	private String username;
	private String psw;
	private String cpsw;
	private String name;
	private int age;
	private String birth;
	private String email;
	private String msg;

	public String reginsterCheck() {
		// 非空判断
		if (username == null || "".equals(username) || psw == null || "".equals(psw) || cpsw == null
				|| "".equals(cpsw)) {
			this.msg = "用户名或密码不能为空";
			return "error";
			// 密码一致判断
		} else if (!psw.equals(cpsw)) {
			this.msg = "密码输入不一致";
			return "error";
		}

		return "success";
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPsw() {
		return psw;
	}

	public void setPsw(String psw) {
		this.psw = psw;
	}

	public String getCpsw() {
		return cpsw;
	}

	public void setCpsw(String cpsw) {
		this.cpsw = cpsw;
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

	public String getBirth() {
		return birth;
	}

	public void setBirth(String birth) {
		this.birth = birth;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
