package com.liuxu.ssas;

import java.util.List;

/**
 * 成绩的接口
 * @author LiuXu
 * @time2018年6月10日下午3:23:23
 **/
public interface IScore {

	// 添加一门学科的成绩
	boolean addScore(AScoreE ae);

	// 删除一门学科的成绩
	boolean removeScore(AScoreE ae);

	// 删除一门学科的成绩
	boolean removeScore(int id, String subjectName);

	// 查询学生的所有学科成绩
	List<AScoreE> selectSub(int id);
}
