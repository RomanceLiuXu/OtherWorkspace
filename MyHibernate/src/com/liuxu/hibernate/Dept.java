package com.liuxu.hibernate;

import java.io.Serializable;

/**
 *
 * @author LiuXu
 * @time2018年8月15日下午8:09:54
 **/
public class Dept implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6929614387490357559L;

	private int deptId;// id
	private String deptName;// 部门名称
	private String deptLocation;// 部门地址
	
	public Dept() {
		super();
	}

	public Dept(int deptId, String deptName, String deptLocation) {
		super();
		this.deptId = deptId;
		this.deptName = deptName;
		this.deptLocation = deptLocation;
	}

	public int getDeptId() {
		return deptId;
	}

	public void setDeptId(int deptId) {
		this.deptId = deptId;
	}

	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

	public String getDeptLocation() {
		return deptLocation;
	}

	public void setDeptLocation(String deptLocation) {
		this.deptLocation = deptLocation;
	}

	@Override
	public String toString() {
		return "Dept [deptId=" + deptId + ", deptName=" + deptName + ", deptLocation=" + deptLocation + "]";
	}

}
