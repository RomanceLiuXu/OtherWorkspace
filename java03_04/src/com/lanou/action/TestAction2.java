package com.lanou.action;

import com.opensymphony.xwork2.ActionSupport;

/**
 *
 * @author LiuXu
 * @time2018年7月30日下午4:35:05
 **/
public class TestAction2 extends ActionSupport {

	private String str;
	private String str1;

	@Override
	public String execute() throws Exception {
		str = "uuuu";
		return SUCCESS;
	}

	public String method1() {
		str1 = "xxxx";
		return SUCCESS;
	}
	
	
	public String getStr() {
		return str;
	}

	public void setStr(String str) {
		this.str = str;
	}

	public String getStr1() {
		return str1;
	}

	public void setStr1(String str1) {
		this.str1 = str1;
	}

}
