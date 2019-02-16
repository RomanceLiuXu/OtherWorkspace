package com.lanou;

/**
 *
 * @author LiuXu
 * @time2018年8月6日上午11:23:37
 **/
public class Car {

	private String type;
	private double price;

	public Car() {
		super();
	}

	public Car(String type, double price) {
		super();
		this.type = type;
		this.price = price;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

}
