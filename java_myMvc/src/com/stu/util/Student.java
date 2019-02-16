package com.stu.util;

/**
 *
 * @author LiuXu
 * @time2018年7月9日下午9:15:38
 **/
public class Student {

	private String id;// id
	private String name;// 姓名
	private String birth;// 出生年月日
	private String sex;// 性别

	public Student() {
		super();
	}

	public Student(String id, String name, String birth, String sex) {
		super();
		this.id = id;
		this.name = name;
		this.birth = birth;
		this.sex = sex;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", birth=" + birth + ", sex=" + sex + "]";
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBirth() {
		return birth;
	}

	public void setBirth(String birth) {
		this.birth = birth;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

}
