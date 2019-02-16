package com.lanou.bean;

import java.io.Serializable;

/**
 *
 * @author LiuXu
 * @time2018年9月18日下午4:49:52
 **/
public class Manager implements Serializable {

	private int mid;
	private String mname;
	private Team team;
	
	public Manager() {
		super();
	}
	public Manager(int mid, String mname, Team team) {
		super();
		this.mid = mid;
		this.mname = mname;
		this.team = team;
	}
	
	@Override
	public String toString() {
		return "Manager [mid=" + mid + ", mname=" + mname + "]";
	}
	public int getMid() {
		return mid;
	}
	public void setMid(int mid) {
		this.mid = mid;
	}
	public String getMname() {
		return mname;
	}
	public void setMname(String mname) {
		this.mname = mname;
	}
	public Team getTeam() {
		return team;
	}
	public void setTeam(Team team) {
		this.team = team;
	}
    
}
