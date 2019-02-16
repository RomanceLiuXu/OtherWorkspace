package com.lanou.bean;

import java.io.Serializable;

/**
 *
 * @author LiuXu
 * @time2018年8月17日下午5:30:56
 **/
public class User implements Serializable {

	private int uid;
	private String uname;
	private String uaddress;
	// 代表当前用户有一张身份证
	private Card card;

	public User() {
		super();
	}

	public User(int uid, String uname, String uaddress, Card card) {
		super();
		this.uid = uid;
		this.uname = uname;
		this.uaddress = uaddress;
		this.card = card;
	}

	public User(int uid, String uname, String uaddress) {
		super();
		this.uid = uid;
		this.uname = uname;
		this.uaddress = uaddress;
	}

	public int getUid() {
		return uid;
	}

	public void setUid(int uid) {
		this.uid = uid;
	}

	public String getUname() {
		return uname;
	}

	public void setUname(String uname) {
		this.uname = uname;
	}

	public String getUaddress() {
		return uaddress;
	}

	public void setUaddress(String uaddress) {
		this.uaddress = uaddress;
	}

	public Card getCard() {
		return card;
	}

	public void setCard(Card card) {
		this.card = card;
	}

}
