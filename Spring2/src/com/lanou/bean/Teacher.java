package com.lanou.bean;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 *
 * @author LiuXu
 * @time2018年8月22日下午5:38:01
 **/
@Component("tea")
public class Teacher {

	@Value("${jdbc.username}")
	private String name;
	@Value("语文")
	private String xueke;
	
	public void show(){
		System.out.println(name);
		System.out.println(xueke);
	}
}
