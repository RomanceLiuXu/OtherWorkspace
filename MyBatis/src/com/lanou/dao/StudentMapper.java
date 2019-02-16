package com.lanou.dao;

import com.lanou.bean.Student;

/**
 *
 * @author LiuXu
 * @time2018年9月19日上午11:10:34
 **/
public interface StudentMapper {

	public Student findStudentById(int id);
	
}
