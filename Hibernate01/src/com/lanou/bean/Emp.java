package com.lanou.bean;

import java.util.Date;

/**
 *
 * @author LiuXu
 * @time2018年8月16日下午2:42:18
 **/
public class Emp {

	private int eid;
	private String ename;
	private String ejob;
	private double salary;
	private Date hiredate;
	
	public Emp() {
		super();
	}
	public Emp(int eid, String ename, String ejob, double salary, Date hiredate) {
		super();
		this.eid = eid;
		this.ename = ename;
		this.ejob = ejob;
		this.salary = salary;
		this.hiredate = hiredate;
	}
	public int getEid() {
		return eid;
	}
	public void setEid(int eid) {
		this.eid = eid;
	}
	public String getEname() {
		return ename;
	}
	public void setEname(String ename) {
		this.ename = ename;
	}
	public String getEjob() {
		return ejob;
	}
	public void setEjob(String ejob) {
		this.ejob = ejob;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	public Date getHiredate() {
		return hiredate;
	}
	public void setHiredate(Date hiredate) {
		this.hiredate = hiredate;
	}
	@Override
	public String toString() {
		return "Emp [eid=" + eid + ", ename=" + ename + ", ejob=" + ejob + ", salary=" + salary + ", hiredate="
				+ hiredate + "]";
	}
	
}
