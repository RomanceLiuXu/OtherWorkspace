package com.lanou.dao;

import java.util.List;

import com.lanou.bean.Emp;

/**
 *
 * @author LiuXu
 * @time2018年8月23日上午10:07:43
 **/
public interface EmpDao {
	/** 查找所有数据*/
	public List<Emp> findAll();

	/** 根据id查找一个对象*/
	public Emp findEmpById(int id);

	/**根据id删除一个对象*/
	public void deleteEmpById(int id);

	/**插入一个对象*/
	public void save(Emp emp);

	/** 修改对象*/
	public void update(Emp emp);
}
