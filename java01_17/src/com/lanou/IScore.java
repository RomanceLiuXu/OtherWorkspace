package com.lanou;

/**
 * 成绩接口
 * 
 * @author LiuXu
 * @time2018年6月7日下午2:48:09
 **/
public interface IScore {

	// 添加学生
	void addStudent(Student student);

	// 查询学生
	void searchStudent(Student student);

	// 删除学生
	void deleteStudent(Student student);

}
