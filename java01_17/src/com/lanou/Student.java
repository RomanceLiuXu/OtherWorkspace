package com.lanou;

/**
 * 学生类
 * 
 * @author LiuXu
 * @time2018年6月7日下午2:41:22
 **/
public class Student extends SubjectAndScore {

	private int id;// 学号
	private String name;// 姓名
	private String sex;// 性别
	private int age;// 年龄

	public Student() {
		super();
	}

	public Student(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public Student(int id, String name, String sex, int age) {
		super();
		this.id = id;
		this.name = name;
		this.sex = sex;
		this.age = age;
	}

	public Student(String mathName, double mathScore, String chineseName, double chineseScore, int id, String name,
			String sex, int age) {
		super(mathName, mathScore, chineseName, chineseScore);
		this.id = id;
		this.name = name;
		this.sex = sex;
		this.age = age;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public int hashCode() {

		return id;
	}

	// 按照学号去重
	@Override
	public boolean equals(Object obj) {
		// 先比较内存地址
		if (this == obj) {
			return true;
		}
		// 要比较的对象的类型
		if (!(obj instanceof Student)) {
			return false;
		}
		Student stu = (Student) obj;
		if (this.id == stu.id) {
			return true;
		}
		return false;

	}

	@Override
	public String toString() {
		return id + "\t" + name + "\t" + sex + "\t" + age;
	}

}
