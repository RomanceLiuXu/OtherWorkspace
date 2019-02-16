package com.lanou.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.lanou.bean.Emp;
import com.lanou.dao.EmpDao;

/**
*
* @author LiuXu
* @time2018年8月23日上午11:29:25
**/
@Service("empService")
public class EmpServiceImpl implements EmpService {

	@Resource
	private EmpDao empDao;
	
	@Override
	public List<Emp> listAll() {
	   List<Emp> emps = empDao.findAll();
	   System.out.println("-目标方法-");
//	   String s = null;
//	   s.length();
//	   String[] s = {"aa","ss"};
//	   String a = s[2];
		return emps;
	}

	public EmpDao getEmpDao() {
		return empDao;
	}

	public void setEmpDao(EmpDao empDao) {
		this.empDao = empDao;
	}

}
