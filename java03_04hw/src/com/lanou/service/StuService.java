package com.lanou.service;

import com.lanou.bean.Student;
import com.lanou.dao.StuDao;
import com.lanou.dao.interf.StuDaOI;
import com.lanou.service.interf.StuServiceI;

/**
 *
 * @author LiuXu
 * @time2018年7月30日下午8:18:33
 **/
public class StuService implements StuServiceI {
	StuDaOI dao = new StuDao();

	@Override
	public String reginsterCheck(Student student) {
		String result ="";
		if (student != null) {
             result = dao.reginsterCheck(student);
		}

		return result;
	}

}
