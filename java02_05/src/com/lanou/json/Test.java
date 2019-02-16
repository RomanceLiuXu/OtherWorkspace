package com.lanou.json;

/**
 *
 * @author LiuXu
 * @time2018年7月4日下午4:39:03
 **/
public class Test {

	private String type;
	private int typeId;
	private int count;
	
	
	
	public Test() {
		super();
	}

	public Test(String type, int typeId, int count) {
		super();
		this.type = type;
		this.typeId = typeId;
		this.count = count;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getTypeId() {
		return typeId;
	}

	public void setTypeId(int typeId) {
		this.typeId = typeId;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

}
