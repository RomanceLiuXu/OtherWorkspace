package com.lanou.action;

import com.lanou.bean.Student;
import com.lanou.service.StuService;
import com.lanou.service.interf.StuServiceI;

/**
 *
 * @author LiuXu
 * @time2018年7月30日下午8:19:49
 **/
public class StuAction {

	private Student student;

	public String reginsterAction() {
		String result = "";
		System.out.println(student.getSex());
		StuServiceI service = new StuService();
		if (IsNull(student) && student.getAge() > 0) {
			result = service.reginsterCheck(student);
		}

		return result;
	}

	public boolean IsNull(Student student) {
		if (student.getCode() != null && !"".equals(student.getCode()) && student.getPsw() != null
				&& !"".equals(student.getPsw()) && student.getSex() != null && !"".equals(student.getSex())) {
			return true;
		}
		return false;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

}
