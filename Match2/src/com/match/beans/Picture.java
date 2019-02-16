package com.match.beans;

import java.io.Serializable;

/**
*
* @author LiuXu
* @time2018年7月11日下午11:27:18
**/
public class Picture implements Serializable{

	private int pid;//用户图片id
	private String pname;//文件名
	private String paddress;//文件路径
	private int uid;//对应的用户id
	
	public Picture() {
		super();
	}
	
	public Picture(int pid, String pname, String paddress) {
		super();
		this.pid = pid;
		this.pname = pname;
		this.paddress = paddress;
	}



	public Picture(int pid, String pname, String paddress, int uid) {
		super();
		this.pid = pid;
		this.pname = pname;
		this.paddress = paddress;
		this.uid = uid;
	}
	@Override
	public String toString() {
		return "User [pid=" + pid + ", pname=" + pname + ", paddress=" + paddress + ", uid=" + uid + "]";
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
	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
	
	
	
	
	
}
