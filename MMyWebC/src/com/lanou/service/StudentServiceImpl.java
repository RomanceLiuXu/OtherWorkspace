package com.lanou.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lanou.bean.Student;
import com.lanou.dao.StudentDao;

/**
 *
 * @author LiuXu
 * @time2018年8月27日下午1:33:04
 **/
@Service("studentService")
public class StudentServiceImpl  implements StudentService{

	@Autowired
	private StudentDao stuDao;
	
	@Override
	public List<Student> findStudent(int page,int pageCount) {
	
		return stuDao.findStudent(page,pageCount);
	}

	@Override
	public void addStdent(Student student) {
		stuDao.addStdent(student);
	}

	@Override
	public long findStuNum() {
		
		return stuDao.findStuNum();
	}

}
