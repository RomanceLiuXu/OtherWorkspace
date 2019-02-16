package com.stu.mvc.dao.interf;

import java.util.List;

import com.stu.mvc.beans.Student;

/**
 *
 * @author LiuXu
 * @time2018年7月9日下午9:13:52
 **/
public interface stuDaoInterf {

	/**
	 * 连接数据库查询学生表中的数据
	 * 
	 * @param page
	 *            页码
	 * @param pnum
	 *            每页显示的条数
	 * @return 学生的集合对象
	 */
	List<Student> findStudents(int page, int pnum);

	/**
	 * 获取数据库中相应表的总页数
	 * 
	 * @param tableName
	 *            表名
	 * @param pnum
	 *            每页显示的数据
	 * @return 总页数
	 */
	int getNum(String tableName, int pnum);

}
