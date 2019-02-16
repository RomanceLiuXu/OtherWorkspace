package com.stu.mvc.service;

import java.util.ArrayList;
import java.util.List;

import com.stu.mvc.beans.Student;
import com.stu.mvc.dao.stuDao;
import com.stu.mvc.service.Interf.stuServiceInterf;


/**
 *
 * @author LiuXu
 * @time2018年7月9日下午9:09:24
 **/
public class stuService implements stuServiceInterf {

	stuDao dao = new stuDao();
	List<Student> students = new ArrayList<>();

	@Override
	public List<Student> findStudents(int page, int pnum) {

		// 判断传输的数据
		if (page > 0 && pnum > 0) {

			// 交给dao层处理
			students = dao.findStudents(page, pnum);

		}

		return students;
	}

	@Override
	public int getNum(String tableName, int pnum) {
		int num = 0;
		if (tableName != null && !tableName.equals("") && pnum > 0) {
			num = dao.getNum(tableName, pnum);
		}
		return num;
		
	}

}
