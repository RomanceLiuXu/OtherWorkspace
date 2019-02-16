package com.lanou.mywork;

/**
 *
 * @author LiuXu
 * @time2018年7月5日下午7:07:09
 **/
public class StudentE {

	private String name;
	private int age;
	private int score;

	public StudentE() {
		super();
	}

	public StudentE(String name, int age, int score) {
		super();
		this.name = name;
		this.age = age;
		this.score = score;
	}

	@Override
	public String toString() {
		return "StudentE [name=" + name + ", age=" + age + ", score=" + score + "]";
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

}
