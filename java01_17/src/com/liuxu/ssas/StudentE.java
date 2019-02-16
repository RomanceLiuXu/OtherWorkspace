package com.liuxu.ssas;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author LiuXu
 * @time2018年6月10日下午2:26:19
 **/
public class StudentE implements IStudent {

	// 存放多个学生的容器
	static List<Student> stus = new ArrayList<>();

	@Override
	public boolean addStudent(Student student) {
		if (student != null) {
			return stus.add(student);
		}
		return false;
	}

	@Override
	public boolean removeStudent(int id) {
		Student student = selectStudent(id);
		if (student != null) {
			return stus.remove(student);
		}
		return false;
	}

	@Override
	public List<Student> selectStudents() {

		return stus;
	}

	@Override
	public Student selectStudent(int id) {
		// 循环遍历集合，查询学生
		for (Student student : stus) {
			// 判断id是否相等
			if (student.getId() == id) {
				// 返回该学生
				return student;
			}
		}

		return null;
	}

}
