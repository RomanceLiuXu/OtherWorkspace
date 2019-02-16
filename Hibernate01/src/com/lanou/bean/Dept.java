package com.lanou.bean;

import java.io.Serializable;

/**
 * 根据数据库中的表创建的实体类（做映射关系）
 * 类名和表名不一定一致
 * 表中字段个数和实体类中属性个数一致
 * 表中字段数据类型要和实体类中的类型一致
 * @author LiuXu
 * @time2018年8月15日上午11:15:48
 **/
public class Dept implements Serializable{

	//版本号 在进行反序列化时会用到
	private static final long serialVersionUID = 719718815868427647L;

	private int deptNo;//id
	private String deptName;//部门名称
	private String location;//部门所在地
	
	
	public Dept() {
		super();
	}


	public Dept(int deptNo, String deptName, String location) {
		super();
		this.deptNo = deptNo;
		this.deptName = deptName;
		this.location = location;
	}


	public int getDeptNo() {
		return deptNo;
	}


	public void setDeptNo(int deptNo) {
		this.deptNo = deptNo;
	}


	public String getDeptName() {
		return deptName;
	}


	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}


	public String getLocation() {
		return location;
	}


	public void setLocation(String location) {
		this.location = location;
	}


	@Override
	public String toString() {
		return "Dept [deptNo=" + deptNo + ", deptName=" + deptName + ", location=" + location + "]";
	}
	
	
	
}
