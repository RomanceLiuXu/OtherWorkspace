package com.liuxu.hibernate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

/**
 * 一对一
 * 
 * @author LiuXu
 * @time2018年8月22日下午11:21:36
 **/
@Entity
@Table(name = "user")
public class User {
	@Id
	@Column(name = "uid")
	private int uid;
	@Column(name = "uname")
	private String uname;
	@Column(name = "uaddress")
	private String uaddress;
	@OneToOne(cascade = CascadeType.ALL)
	@PrimaryKeyJoinColumn
	private Card card;

	public User() {
		super();
	}

	public User(int uid, String uname, String uaddress) {
		super();
		this.uid = uid;
		this.uname = uname;
		this.uaddress = uaddress;
	}

	public User(int uid, String uname, String uaddress, Card card) {
		super();
		this.uid = uid;
		this.uname = uname;
		this.card = card;
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

	public Card getCard() {
		return card;
	}

	public void setCard(Card card) {
		this.card = card;
	}

	public String getUaddress() {
		return uaddress;
	}

	public void setUaddress(String uaddress) {
		this.uaddress = uaddress;
	}

}
