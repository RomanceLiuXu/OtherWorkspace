package com.liuxu.hibernate;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

/**
 * 多对多
 * 
 * @author LiuXu
 * @time2018年8月17日下午3:42:46
 **/
@Entity
@Table(name = "employee")
public class Employee implements Serializable {

	@Id
	@Column(name = "e_id")
	private int eid;
	@Column(name = "e_name")
	private String ename;
	// 表示当前员工有的项目
	@ManyToMany(targetEntity = Project.class, cascade = CascadeType.ALL)
	@JoinTable(name = "proemp", // 中间表名
			joinColumns = @JoinColumn(name = "rempid"), // 本类在中间表的字段名
			inverseJoinColumns = @JoinColumn(name = "rproid")) // 关联类在中间表的字段名
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
