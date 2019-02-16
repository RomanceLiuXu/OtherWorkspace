package com.sumi.bean;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import com.sun.org.apache.bcel.internal.generic.NEW;

/**
 *
 * @author SPF
 * @time 2018年8月28日下午2:40:19
 */
public class Employee {
	private int uid;// 员工编号
	private String jobnum;// 工号
	private String password;
	private String uname;// 姓名
	private String sex;// 性别
	private String email;// 邮箱
	private String phone;// 手机
	private String address;
	private Date hiredate;
	private Department department;
	private Role role;
	private Set<Attendance> attendances = new HashSet<>();
	private Set<myProcess> processes = new HashSet<>();

	public Employee(int uid, String jobnum, String password, String uname, String sex, String email, String phone,
			String address, Date hiredate, Department department, Role role, Set<Attendance> attendances,
			Set<myProcess> processes) {
		super();
		this.uid = uid;
		this.jobnum = jobnum;
		this.password = password;
		this.uname = uname;
		this.sex = sex;
		this.email = email;
		this.phone = phone;
		this.address = address;
		this.hiredate = hiredate;
		this.department = department;
		this.role = role;
		this.attendances = attendances;
		this.processes = processes;
	}

	public Set<myProcess> getProcesses() {
		return processes;
	}

	public void setProcesses(Set<myProcess> processes) {
		this.processes = processes;
	}

	public Employee() {
		super();
	}

	public Employee(String jobnum, String password, String uname, String sex, String email, String phone,
			String address, Date hiredate) {
		super();
		this.jobnum = jobnum;
		this.password = password;
		this.uname = uname;
		this.sex = sex;
		this.email = email;
		this.phone = phone;
		this.address = address;
		this.hiredate = hiredate;
	}

	public int getUid() {
		return uid;
	}

	public void setUid(int uid) {
		this.uid = uid;
	}

	public String getJobnum() {
		return jobnum;
	}

	public void setJobnum(String jobnum) {
		this.jobnum = jobnum;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUname() {
		return uname;
	}

	public void setUname(String uname) {
		this.uname = uname;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Date getHiredate() {
		return hiredate;
	}

	public void setHiredate(Date hiredate) {
		this.hiredate = hiredate;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public Set<Attendance> getAttendances() {
		return attendances;
	}

	public void setAttendances(Set<Attendance> attendances) {
		this.attendances = attendances;
	}

}
