package com.lanou.bean;

import java.io.Serializable;

/**
 *
 * @author LiuXu
 * @time2018年9月19日上午10:17:15
 **/
public class Card implements Serializable {

	private int cid;
	private String cno;
	private String remark;
	private People people;//表示一方
	
	public Card() {
		super();
	}
	public Card(int cid, String cno, String remark, People people) {
		super();
		this.cid = cid;
		this.cno = cno;
		this.remark = remark;
		this.people = people;
	}
	
	@Override
	public String toString() {
		return "Card [cid=" + cid + ", cno=" + cno + ", remark=" + remark + "]";
	}
	public int getCid() {
		return cid;
	}
	public void setCid(int cid) {
		this.cid = cid;
	}
	public String getCno() {
		return cno;
	}
	public void setCno(String cno) {
		this.cno = cno;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public People getPeople() {
		return people;
	}
	public void setPeople(People people) {
		this.people = people;
	}
	
}
