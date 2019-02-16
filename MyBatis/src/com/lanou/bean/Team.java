package com.lanou.bean;

/**
 *
 * @author LiuXu
 * @time2018年9月18日下午4:51:03
 **/
public class Team {

	private int tid;
	private String tname;
	private String location;
	private Manager manager;
	
	
	public Team() {
		super();
	}
	public Team(int tid, String tname, String location, Manager manager) {
		super();
		this.tid = tid;
		this.tname = tname;
		this.location = location;
		this.manager = manager;
	}
	
	@Override
	public String toString() {
		return "Team [tid=" + tid + ", tname=" + tname + ", location=" + location + "]";
	}
	public int getTid() {
		return tid;
	}
	public void setTid(int tid) {
		this.tid = tid;
	}
	public String getTname() {
		return tname;
	}
	public void setTname(String tname) {
		this.tname = tname;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public Manager getManager() {
		return manager;
	}
	public void setManager(Manager manager) {
		this.manager = manager;
	}
	
	
}
