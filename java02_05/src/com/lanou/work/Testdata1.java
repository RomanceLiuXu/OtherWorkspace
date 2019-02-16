package com.lanou.work;
/**
*
* @author LiuXu
* @time2018年7月4日下午8:09:31
**/
public class Testdata1<T> {

	private String testdatason1;
	
	private int testdatason2;
	
	T testdata2;
	

	public Testdata1() {
		super();
	}

	public Testdata1(String testdatason1, int testdatason2, T testdata2) {
		super();
		this.testdatason1 = testdatason1;
		this.testdatason2 = testdatason2;
		this.testdata2 = testdata2;
	}

	public String getTestdatason1() {
		return testdatason1;
	}

	public void setTestdatason1(String testdatason1) {
		this.testdatason1 = testdatason1;
	}

	public int getTestdatason2() {
		return testdatason2;
	}

	public void setTestdatason2(int testdatason2) {
		this.testdatason2 = testdatason2;
	}

	@Override
	public String toString() {
		return "Testdata1 [testdatason1=" + testdatason1 + ", testdatason2=" + testdatason2 + ", testdata2=" + testdata2
				+ "]";
	}

	public T getTestdata2() {
		return testdata2;
	}

	public void setTestdata2(T testdata2) {
		this.testdata2 = testdata2;
	}
	
	
	
}
