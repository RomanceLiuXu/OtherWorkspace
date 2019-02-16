package com.lanou.service;

import java.util.List;

import com.lanou.bean.Emp;

/**
 *
 * @author LiuXu
 * @time2018年9月9日下午2:18:06
 **/
public interface EmpService {

	/**查询所有*/
	public List<Emp> findAll();
	/**添加*/
	public void addEmp(Emp emp);
}
