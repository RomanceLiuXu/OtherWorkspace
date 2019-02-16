package com.liuxu.bean;

import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

/**
 *
 * @author LiuXu
 * @time2018年8月22日下午9:27:56
 **/
@Component("tea")
@Lazy(true)
public class Teacher {

	@Value("#{mlist[0]}")
	private String name;
	@Value("#{mmap['1003']}")
	private String sex;
	
	public void show(){
		System.out.println(name);
		System.out.println(sex);
	}
}
