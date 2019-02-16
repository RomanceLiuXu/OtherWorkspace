package com.lanou.bean;
/**
*
* @author LiuXu
* @time2018年7月30日下午5:00:26
**/
public class Test3Entity {

	private String x;
	private String y;
	
	public Test3Entity() {
		super();
	}
	public Test3Entity(String x, String y) {
		super();
		this.x = x;
		this.y = y;
	}
	public String getX() {
		return x;
	}
	public void setX(String x) {
		this.x = x;
	}
	public String getY() {
		return y;
	}
	public void setY(String y) {
		this.y = y;
	}
	@Override
	public String toString() {
		return "Test3Entity [x=" + x + ", y=" + y + "]";
	}
	
	
	
	
}
