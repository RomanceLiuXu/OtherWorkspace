package com.liuxu.ssas;

/**
 *
 * @author LiuXu
 * @time2018年6月10日下午3:19:05
 **/
public class AScoreE extends AScore {
	private int id;// 唯一的标示(人的id--学生的id)

	public AScoreE() {
		super();
	}

	public AScoreE(String subjectName, double subjectScore, int id) {
		super(subjectName, subjectScore);
		this.id = id;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

}
