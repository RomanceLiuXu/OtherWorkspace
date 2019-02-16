package com.lanou.dao;

import java.util.List;

import com.lanou.bean.Emp;

/**
 *
 * @author LiuXu
 * @time2018年9月9日下午2:17:40
 **/
public interface EmpDao {

	/** 查询所有数据*/
	public List<Emp> findAll();
	/**添加一个员工*/
	public void addEmp(Emp emp);
	/**根据id查找一个对象*/
	public Emp findEmpById(int id);
	/** 根据id删除一个对象*/
	public void deleteEmpById(int id);
	
	public void updateEmp(Emp emp);
}
