package com.lanou.bean;

import java.io.Serializable;

/**
 *
 * @author LiuXu
 * @time2018年8月17日下午5:31:13
 **/
public class Card implements Serializable{

	private int cid;
	private String cNo;
	// 代表当前这张身份证属于哪个用户
	private User user;

	public Card() {
		super();
	}

	public Card(int cid, String cNo, User user) {
		super();
		this.cid = cid;
		this.cNo = cNo;
		this.user = user;
	}

	public Card(int cid, String cNo) {
		super();
		this.cid = cid;
		this.cNo = cNo;
	}

	public int getCid() {
		return cid;
	}

	public void setCid(int cid) {
		this.cid = cid;
	}

	public String getcNo() {
		return cNo;
	}

	public void setcNo(String cNo) {
		this.cNo = cNo;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}
