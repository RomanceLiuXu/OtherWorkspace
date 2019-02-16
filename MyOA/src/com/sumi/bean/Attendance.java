package com.sumi.bean;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author LiuXu
 * @time2018年8月30日上午9:32:43
 **/
public class Attendance implements Serializable{

	private int id;
	private String jobnum;
	private Date createTime;
	private Employee employee;
	public Attendance() {
		super();
	}
	public Attendance(int id, String jobnum, Date createTime, Employee employee) {
		super();
		this.id = id;
		this.jobnum = jobnum;
		this.createTime = createTime;
		this.employee = employee;
	}
	
	
	public Attendance(String jobnum,Date createTime,Employee employee) {
		super();
		this.jobnum = jobnum;
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
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public Employee getEmployee() {
		return employee;
	}
	public void setEmployee(Employee employee) {
		this.employee = employee;
	}


}
