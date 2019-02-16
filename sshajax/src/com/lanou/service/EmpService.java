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
	/**删除*/
	public void deleteEmp(int id);
	/**修改*/
	public void updateEmp(Emp emp);
	/**根据名称获取对象*/
	public Emp findEmpByName(String uname);
}
