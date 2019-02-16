package com.lanou.javaobserver;

import java.util.Observable;

/**
 *
 * @author LiuXu
 * @time2018年8月7日下午2:41:42
 **/
public class Anchor extends Observable {
	private String data;

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
		setChanged();
		notifyObservers(data);
	}

}
