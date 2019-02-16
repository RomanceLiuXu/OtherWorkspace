package com.liuxu.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.liuxu.bean.Emp;
import com.liuxu.dao.EmpDao;

/**
 *
 * @author LiuXu
 * @time2018年8月23日下午7:59:00
 **/
@Service("empService")
public class EmpServiceImpl implements EmpService{
    
	@Autowired
	private EmpDao empDao;
	@Override
	public List<Emp> findAll() {
	
		List<Emp> emps = empDao.findAll();
		return emps;
	}
	public EmpDao getEmpDao() {
		return empDao;
	}
	public void setEmpDao(EmpDao empDao) {
		this.empDao = empDao;
	}

}
