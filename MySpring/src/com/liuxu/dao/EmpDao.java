package com.liuxu.dao;

import java.util.List;

import com.liuxu.bean.Emp;

/**
 *
 * @author LiuXu
 * @time2018年8月23日下午7:47:37
 **/
public interface EmpDao {

	/**
	 * 查找所有用户
	 */
	public List<Emp> findAll();
	
}
