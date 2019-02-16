package com.match.beans;

import java.io.Serializable;

/**
*
* @author LiuXu
* @time2018年7月11日下午11:27:18
**/
public class Picture2 implements Serializable{

	private int pid;//用户图片id
	private String pname;//文件名
	private String paddress;//文件路径
    private UserP userP;
	public Picture2() {
		super();
	}
	public Picture2(int pid, String pname, String paddress) {
		super();
		this.pid = pid;
		this.pname = pname;
		this.paddress = paddress;
	}
	public Picture2(int pid, String pname, String paddress, UserP userP) {
		super();
		this.pid = pid;
		this.pname = pname;
		this.paddress = paddress;
		this.userP = userP;
	}
	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public String getPaddress() {
		return paddress;
	}
	public void setPaddress(String paddress) {
		this.paddress = paddress;
	}
	public UserP getUserP() {
		return userP;
	}
	public void setUserP(UserP userP) {
		this.userP = userP;
	}
	
	
	
	
}
