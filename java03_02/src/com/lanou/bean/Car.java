package com.lanou.bean;

/**
 *
 * @author LiuXu
 * @time2018年7月26日下午4:15:58
 **/
public class Car {

	private String name;
	private String type;
	private int price;

	public Car() {
		super();
	}

	public Car(String name, String type, int price) {
		super();
		this.name = name;
		this.type = type;
		this.price = price;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

}
