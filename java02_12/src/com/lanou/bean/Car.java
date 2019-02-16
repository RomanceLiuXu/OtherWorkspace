package com.lanou.bean;

import java.util.Iterator;

/**
*
* @author LiuXu
* @time2018年7月18日下午3:28:58
**/
public class Car {

	private int id;
	private String type;
	
	
	public Car() {
		super();
		
	}
	public Car(int id, String type) {
		super();
		this.id = id;
		this.type = type;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	
	
}
