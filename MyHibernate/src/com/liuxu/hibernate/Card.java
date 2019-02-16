package com.liuxu.hibernate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

/**
 * 一对一
 * 
 * @author LiuXu
 * @time2018年8月22日下午11:21:46
 **/
@Entity // 表明是一个实体类
@Table(name = "card") // 数据库表名
public class Card {
	@Id
	@Column(name = "cid")
	// @GeneratedValue(strategy=GenerationType.AUTO)//主键生成策略
	private int cid;
	@Column(name = "cNo")
	private String cNo;
	@OneToOne(cascade = CascadeType.ALL)
	@PrimaryKeyJoinColumn
	private User user;

	public Card() {
		super();
	}

	public Card(int cid, String cNo) {
		super();
		this.cid = cid;
		this.cNo = cNo;
	}

	public Card(int cid, String cNo, User user) {
		super();
		this.cid = cid;
		this.cNo = cNo;
		this.user = user;
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
