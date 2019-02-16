package com.liuxu.ssas;

import java.util.List;

/**
 *
 * @author LiuXu
 * @time2018年6月10日下午2:18:01
 **/
public interface IStudent {

	/**
	 * 添加学生的方法
	 * 
	 * @param student
	 *            要添加的学生
	 * @return true--添加成功 false--添加失败
	 */
	public abstract boolean addStudent(Student student);

	/**
	 * 通过学生id删除学生
	 * 
	 * @param id
	 *            学号
	 * @return 是否删除成功
	 */
	boolean removeStudent(int id);

	/**
	 * 查询所有学生
	 * @return 学生的集合
	 */
	List<Student> selectStudents();

	/**
	 * 查询单个学生
	 * @param id 要查询的id
	 * @return 学生对象
	 */
	Student selectStudent(int id);


}
