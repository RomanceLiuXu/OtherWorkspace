package com.liuxu.hibernate;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

/**
 * 多对多
 * 
 * @author LiuXu
 * @time2018年8月17日下午3:43:00
 **/
@Entity
@Table(name = "project")
public class Project implements Serializable {

	@Id
	@Column(name = "p_id")
	private int pid;
	@Column(name = "p_name")
	private String pname;
	// 表示该项目有几个员工参与
	@ManyToMany(targetEntity = Employee.class, cascade = CascadeType.ALL)
	@JoinTable(name = "proemp", // 中间表名
			joinColumns = @JoinColumn(name = "rproid"), // 本类在中间表中的字段名
			inverseJoinColumns = @JoinColumn(name = "rempid")) // 关联类在中间表的字段名
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
