package com.lanou.javaobserver;

import java.util.Observable;
import java.util.Observer;

/**
*
* @author LiuXu
* @time2018年8月7日下午2:44:01
**/
public class User1 implements Observer {

	@Override
	public void update(Observable o, Object arg) {
	    System.out.println(arg);
	}

}
