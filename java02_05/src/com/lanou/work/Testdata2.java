package com.lanou.work;

/**
 *
 * @author LiuXu
 * @time2018年7月4日下午8:19:41
 **/
public class Testdata2 {

	private String testshuzu1;
	private String testshuzu2;

	public Testdata2() {
		super();
	}

	@Override
	public String toString() {
		return "Testdata2 [testshuzu1=" + testshuzu1 + ", testshuzu2=" + testshuzu2 + "]";
	}

	public Testdata2(String testshuzu1, String testshuzu2) {
		super();
		this.testshuzu1 = testshuzu1;
		this.testshuzu2 = testshuzu2;
	}

	public String getTestshuzu1() {
		return testshuzu1;
	}

	public void setTestshuzu1(String testshuzu1) {
		this.testshuzu1 = testshuzu1;
	}

	public String getTestshuzu2() {
		return testshuzu2;
	}

	public void setTestshuzu2(String testshuzu2) {
		this.testshuzu2 = testshuzu2;
	}

}
