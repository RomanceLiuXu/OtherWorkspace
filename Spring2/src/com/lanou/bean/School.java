package com.lanou.bean;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

/**
 *
 * @author LiuXu
 * @time2018年8月22日下午5:42:02
 **/
/**
 * @Autowired byType:按照类型进行匹配
 * @Resource byName:按照名称进行匹配
 * 
 */
@Component("sch")
public class School {
	// @Autowired
	@Resource(name = "tea") // 强制按照名称注入
	private Teacher teacher;
	@Autowired
	@Qualifier("stu") // 强制按照名称注入
	private Student student;

	public void show() {
		teacher.show();
		student.show();
	}
}
