package com.lanou;

import java.io.Serializable;

/**
 *
 * @author LiuXu
 * @time2018年7月3日下午7:07:52
 **/
public class Car  implements Serializable{

	private String name;// 名称
	private String type;// 类型

	public Car() {
		super();
	}

	public Car(String name, String type) {
		super();
		this.name = name;
		this.type = type;
	}

	@Override
	public String toString() {
		return "Car [name=" + name + ", type=" + type + "]";
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

}
