package com.lanou.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lanou.bean.Emp;
import com.lanou.dao.EmpDao;

/**
 *
 * @author LiuXu
 * @time2018年9月9日下午2:25:30
 **/
@Service("empService")
public class EmpServiceImpl implements EmpService{

	@Autowired
	private EmpDao empDao;
	@Override
	public List<Emp> findAll() {
		
		return empDao.findAll();
	}
	@Override
	public void addEmp(Emp emp) {
		empDao.addEmp(emp);
	}
	@Override
	public void deleteEmp(int id) {
       empDao.deleteEmpById(id);		
	}
	@Override
	public void updateEmp(Emp emp) {
		empDao.updateEmp(emp);
	}
	@Override
	public Emp findEmpByName(String uname) {
		
		return empDao.findEmpByName(uname);
	}

}
