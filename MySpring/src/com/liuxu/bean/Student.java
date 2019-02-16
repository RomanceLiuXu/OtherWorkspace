package com.liuxu.bean;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 *
 * @author LiuXu
 * @time2018年8月22日下午9:20:41
 **/
@Component("stu")
@Lazy
public class Student {

	@Value("小黄")
    private String name;
	@Value("12")
    private int age;
    
	public void show(){
		System.out.println(name);
		System.out.println(age);
	}
	
	@PostConstruct
	public void init(){
		System.out.println("student初始化的方法");
	}
	@PreDestroy
	public void destroy(){
		System.out.println("student销毁的方法");
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
	
	
	
}
