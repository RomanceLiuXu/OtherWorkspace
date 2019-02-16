package com.lanou.bean;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author LiuXu
 * @time2018年8月17日下午3:42:46
 **/
public class Employee implements Serializable {

	private int eid;
	private String ename;
	// 表示当前员工有的项目
	private Set<Project> projects = new HashSet<>();

	public Employee() {
		super();
	}

	public Employee(int eid, String ename) {
		super();
		this.eid = eid;
		this.ename = ename;
	}


	public Employee(int eid, String ename, Set<Project> projects) {
		super();
		this.eid = eid;
		this.ename = ename;
		this.projects = projects;
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

	public Set<Project> getProjects() {
		return projects;
	}

	public void setProjects(Set<Project> projects) {
		this.projects = projects;
	}

}
