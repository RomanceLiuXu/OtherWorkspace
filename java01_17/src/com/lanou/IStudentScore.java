package com.lanou;

import java.util.List;

/**
 * 操作成绩接口
 * 
 * @author LiuXu
 * @time2018年6月7日下午5:29:37
 **/
public interface IStudentScore {

	// 添加学生的成绩
	public abstract void addSS(int id);

	// 删除学生成绩
	public abstract void removeSS(int id, String subject);

	// 查询学生的成绩
	public abstract List<Student> stuAndScos();
}
