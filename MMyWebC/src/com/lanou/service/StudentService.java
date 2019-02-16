package com.lanou.service;

import java.util.List;

import com.lanou.bean.Student;

/**
 *
 * @author LiuXu
 * @time2018年8月27日下午1:32:46
 **/
public interface StudentService {

	/** 查找所有学生 */
	public List<Student> findStudent(int page,int pageCount);
	
	/** 添加学生*/
	public void addStdent(Student student);
	
	/** 查询记录总条数*/ 
	public long findStuNum();

}
