package com.lanou.bean;

import java.util.Date;

/**
 *
 * @author LiuXu
 * @time2018年8月30日上午9:32:43
 **/
public class Attendance {

	private int id;
	private String jobnum;
	private Date createTime;

	public Attendance() {
		super();
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Attendance(int id, String jobnum, Date createTime) {
		super();
		this.id = id;
		this.jobnum = jobnum;
		this.createTime = createTime;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getJobnum() {
		return jobnum;
	}

	public void setJobnum(String jobnum) {
		this.jobnum = jobnum;
	}

	public Date getCreateTime() {
		return createTime;
	}

}
