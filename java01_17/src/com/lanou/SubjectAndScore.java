package com.lanou;

/**
 *
 * @author LiuXu
 * @time2018年6月7日下午5:35:46
 **/
public class SubjectAndScore {
	private String mathName;// 数学学科
	private double mathScore;// 数学成绩
	private String chineseName;// 数学学科
	private double chineseScore;// 数学成绩

	public SubjectAndScore() {
		super();
	}

	public SubjectAndScore(String mathName, double mathScore, String chineseName, double chineseScore) {
		super();
		this.mathName = mathName;
		this.mathScore = mathScore;
		this.chineseName = chineseName;
		this.chineseScore = chineseScore;
	}

	public String getMathName() {
		return mathName;
	}

	public void setMathName(String mathName) {
		this.mathName = mathName;
	}

	public double getMathScore() {
		return mathScore;
	}

	public void setMathScore(double mathScore) {
		this.mathScore = mathScore;
	}

	public String getChineseName() {
		return chineseName;
	}

	public void setChineseName(String chineseName) {
		this.chineseName = chineseName;
	}

	public double getChineseScore() {
		return chineseScore;
	}

	public void setChineseScore(double chineseScore) {
		this.chineseScore = chineseScore;
	}

}
