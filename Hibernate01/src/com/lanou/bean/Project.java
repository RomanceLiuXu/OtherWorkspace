package com.lanou.bean;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author LiuXu
 * @time2018年8月17日下午3:43:00
 **/
public class Project implements Serializable {

	private int pid;
	private String pname;
	// 表示该项目有几个员工参与
	private Set<Employee> employees = new HashSet<>();

	public Project() {
		super();
	}

	public Project(int pid, String pname) {
		super();
		this.pid = pid;
		this.pname = pname;
	}

	public Project(int pid, String pname, Set<Employee> employees) {
		super();
		this.pid = pid;
		this.pname = pname;
		this.employees = employees;
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

	public Set<Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(Set<Employee> employees) {
		this.employees = employees;
	}

}
