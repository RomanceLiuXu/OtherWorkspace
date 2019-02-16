package com.liuxu.beans;

import java.io.Serializable;

import com.match.beans.UserP;

/**
 *
 * @author LiuXu
 * @time2018年8月18日下午3:05:09
 **/
public class Picture implements Serializable {

	private int pid;//用户图片id
	private String pname;//文件名
	private String paddress;//文件路径
    private User user;
    
    public Picture() {
		super();
	}
    
    
    
	public Picture(String pname, String paddress) {
		super();
		this.pname = pname;
		this.paddress = paddress;
	}



	public Picture(String pname, String paddress, User user) {
		super();
		this.pname = pname;
		this.paddress = paddress;
		this.user = user;
	}



	public Picture(int pid, String pname, String paddress) {
		super();
		this.pid = pid;
		this.pname = pname;
		this.paddress = paddress;
	}



	public Picture(int pid, String pname, String paddress, User user) {
		super();
		this.pid = pid;
		this.pname = pname;
		this.paddress = paddress;
		this.user = user;
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
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}



	@Override
	public String toString() {
		return "Picture [pid=" + pid + ", pname=" + pname + ", paddress=" + paddress + ", user.id=" + user.getUid() + "]";
	}
	
	
	
}
