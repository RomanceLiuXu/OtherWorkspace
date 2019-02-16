package com.lanou.work;

/**
 *
 * @author LiuXu
 * @time2018年7月4日下午7:51:18
 **/
public class AllTest<T> {

	private String test1;
	private String test2;

	T testdata1;

	public AllTest() {
		super();
	}

	public AllTest(String test1, String test2, T testdata1) {
		super();
		this.test1 = test1;
		this.test2 = test2;
		this.testdata1 = testdata1;
	}

	public String getTest1() {
		return test1;
	}

	public void setTest1(String test1) {
		this.test1 = test1;
	}

	public String getTest2() {
		return test2;
	}

	public void setTest2(String test2) {
		this.test2 = test2;
	}

	public T getTestdata1() {
		return testdata1;
	}

	public void setTestdata1(T testdata1) {
		this.testdata1 = testdata1;
	}

	@Override
	public String toString() {
		return "AllTest [test1=" + test1 + ", test2=" + test2 + ", testdata1=" + testdata1 + "]";
	}

}
