package com.lanou.designed;

import javax.rmi.CORBA.Stub;

/**
 * 水生动物类
 * 
 * @author LiuXu
 * @time2018年8月15日下午2:14:22
 **/
public class Aquatic extends Stub{

	public void breathe(String animal) {
		System.out.println("呼吸水中的空气");
	}

	@Override
	public String[] _ids() {
		
		return null;
	}
	
}
