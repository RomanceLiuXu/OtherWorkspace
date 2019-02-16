package com.lanou.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author LiuXu
 * @time2018年9月19日上午10:17:07
 **/
public class People implements Serializable {

	private int pid;
	private String username;
	private String address;
	private List<Card> cards = new ArrayList<>();// 表示多方集合

	public People() {
		super();
	}

	public People(int pid, String username, String address, List<Card> cards) {
		super();
		this.pid = pid;
		this.username = username;
		this.address = address;
		this.cards = cards;
	}

	@Override
	public String toString() {
		return "People [pid=" + pid + ", username=" + username + ", address=" + address + "]";
	}

	public int getPid() {
		return pid;
	}

	public void setPid(int pid) {
		this.pid = pid;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public List<Card> getCards() {
		return cards;
	}

	public void setCards(List<Card> cards) {
		this.cards = cards;
	}

}
