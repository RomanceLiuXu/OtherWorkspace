package com.sumi.bean;

import java.io.Serializable;
import java.util.Date;

/**
 * 流程类
 * 
 * @author LiuXu
 * @time2018年8月31日下午10:38:07
 **/
public class myProcess implements Serializable{

	private int id;
	private String proName;// 流程名
	private String proDes;// 流程简单描述
	private int proLevel;// 流程级别
	private Employee employee;// 员工对象
	private int proStatus;//流程状态
	private Date proDate;//流程创建时间

	public myProcess(String proName, String proDes, Date proDate) {
		super();
		this.proName = proName;
		this.proDes = proDes;
		this.proDate = proDate;
	}

	public myProcess(int id, String proName, String proDes, int proLevel, Employee employee, int proStatus,
			Date proDate) {
		super();
		this.id = id;
		this.proName = proName;
		this.proDes = proDes;
		this.proLevel = proLevel;
		this.employee = employee;
		this.proStatus = proStatus;
		this.proDate = proDate;
	}

	public Date getProDate() {
		return proDate;
	}

	public void setProDate(Date proDate) {
		this.proDate = proDate;
	}

	public myProcess(int id, String proName, String proDes, int proLevel, Employee employee, int proStatus) {
		super();
		this.id = id;
		this.proName = proName;
		this.proDes = proDes;
		this.proLevel = proLevel;
		this.employee = employee;
		this.proStatus = proStatus;
	}

	public int getProStatus() {
		return proStatus;
	}

	public void setProStatus(int proStatus) {
		this.proStatus = proStatus;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getProName() {
		return proName;
	}

	public void setProName(String proName) {
		this.proName = proName;
	}

	public String getProDes() {
		return proDes;
	}

	public void setProDes(String proDes) {
		this.proDes = proDes;
	}

	public int getProLevel() {
		return proLevel;
	}

	public void setProLevel(int proLevel) {
		this.proLevel = proLevel;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public myProcess(int id, String proName, String proDes, int proLevel, Employee employee) {
		super();
		this.id = id;
		this.proName = proName;
		this.proDes = proDes;
		this.proLevel = proLevel;
		this.employee = employee;
	}

	public myProcess() {
		super();
	}

	public myProcess(String proName, String proDes, int proLevel, int proStatus) {
		super();
		this.proName = proName;
		this.proDes = proDes;
		this.proLevel = proLevel;
		this.proStatus = proStatus;
	}

	

}
