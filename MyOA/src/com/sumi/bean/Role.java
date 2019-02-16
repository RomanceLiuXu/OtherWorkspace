package com.sumi.bean;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author SPF
 * @time 2018年8月28日下午2:46:12
 */
public class Role implements Serializable{
	private int rid;
	private String rname;
	private Set<Employee> employees = new HashSet<Employee>();// 一个权限对应多个员工

	public Role() {
		super();
	}

	public Role(int rid, String rname, Set<Employee> employees) {
		super();
		this.rid = rid;
		this.rname = rname;
		this.employees = employees;
	}

	public int getRid() {
		return rid;
	}

	public void setRid(int rid) {
		this.rid = rid;
	}

	public String getRname() {
		return rname;
	}

	public void setRname(String rname) {
		this.rname = rname;
	}

	public Set<Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(Set<Employee> employees) {
		this.employees = employees;
	}

}
