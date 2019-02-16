package com.lanou.bean;

import java.util.Date;

/**
 *
 * @author LiuXu
 * @time2018年8月23日上午9:43:21
 **/
public class Emp {

	private int id;
	private String name;
	private String job;
	private double salary;
	private Date hiredate;

	public Emp() {
		super();
	}

	public Emp(int id, String name, String job, double salary, Date hiredate) {
		super();
		this.id = id;
		this.name = name;
		this.job = job;
		this.salary = salary;
		this.hiredate = hiredate;
	}

	public Emp(String name, String job, double salary, Date hiredate) {
		super();
		this.name = name;
		this.job = job;
		this.salary = salary;
		this.hiredate = hiredate;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getJob() {
		return job;
	}

	public void setJob(String job) {
		this.job = job;
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
		return "Emp [id=" + id + ", name=" + name + ", job=" + job + ", salary=" + salary + ", hiredate=" + hiredate
				+ "]";
	}

}
