package com.lanou;

/**
 * 实体类
 * 
 * @author LiuXu
 * @time2018年6月29日下午4:18:38
 **/
public class Test2 {

	private int id;//id
	private String name;//姓名

	public Test2() {
		super();
	}

	public Test2(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Test2 [id=" + id + ", name=" + name + "]";
	}

}
