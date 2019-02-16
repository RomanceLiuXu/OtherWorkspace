package com.sumi.bean;

import java.util.HashSet;
import java.util.Set;

/**
*
*@author SPF
*@time 2018年8月28日下午2:38:41
*/
public class Department {
	private int did;
	private String dname;
	private Set<Employee> employees = new HashSet<Employee>();//一个部门对应多个员工
	public Department() {
		super();
	}
	public Department(int did, String dname) {
		super();
		this.did = did;
		this.dname = dname;
	}
	public int getDid() {
		return did;
	}
	public void setDid(int did) {
		this.did = did;
	}
	public String getDname() {
		return dname;
	}
	public void setDname(String dname) {
		this.dname = dname;
	}
	public Set<Employee> getEmployees() {
		return employees;
	}
	public void setEmployees(Set<Employee> employees) {
		this.employees = employees;
	}
	
	

}
