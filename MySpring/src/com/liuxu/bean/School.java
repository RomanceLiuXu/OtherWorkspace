package com.liuxu.bean;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

/**
 *
 * @author LiuXu
 * @time2018年8月22日下午10:05:33
 **/
@Component("sch")
@Lazy
public class School {
//	@Autowired
//	@Qualifier("stu")
	@Resource(name="stu")
	private Student student;
	@Autowired
	private Teacher teacher;
	
	public void show(){
		student.show();
		teacher.show();
	}
	
}
