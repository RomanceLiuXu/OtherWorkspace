package com.lanou.work;

import java.io.Serializable;

/**
 * 用户类
 * 
 * @author LiuXu
 * @time2018年7月3日下午8:59:11
 **/
public class Users implements Serializable {

	private String account;// 账号
	private String psw;// 密码

	public Users() {
		super();
	}

	public Users(String account, String psw) {
		super();
		this.account = account;
		this.psw = psw;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getPsw() {
		return psw;
	}

	public void setPsw(String psw) {
		this.psw = psw;
	}

}
