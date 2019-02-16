package com.liuxu.ssas;

/**
 * 成绩抽象类
 * 
 * @author LiuXu
 * @time2018年6月10日下午3:04:49
 **/
public abstract class AScore {

	private String subjectName;// 学科名
	private double subjectScore;// 成绩

	public AScore() {
		super();
	}

	public AScore(String subjectName, double subjectScore) {
		super();
		this.subjectName = subjectName;
		this.subjectScore = subjectScore;
	}

	public String getSubjectName() {
		return subjectName;
	}

	public void setSubjectName(String subjectName) {
		this.subjectName = subjectName;
	}

	public double getSubjectScore() {
		return subjectScore;
	}

	public void setSubjectScore(double subjectScore) {
		this.subjectScore = subjectScore;
	}

}
