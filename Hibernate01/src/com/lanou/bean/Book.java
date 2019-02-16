package com.lanou.bean;

import java.io.Serializable;

/**
 *
 * @author LiuXu
 * @time2018年8月16日下午5:33:11
 **/
public class Book implements Serializable {

	private int bid;
	private String name;
	private String author;
	// 表示当前图书属于哪个student
	private Student student;

	public Book() {
		super();
	}
	public Book(int bid, String name, String author) {
		super();
		this.bid = bid;
		this.name = name;
		this.author = author;
	}

	public Book(int bid, String name, String author, Student student) {
		super();
		this.bid = bid;
		this.name = name;
		this.author = author;
		this.student = student;
	}

	public int getBid() {
		return bid;
	}

	public void setBid(int bid) {
		this.bid = bid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}
	@Override
	public String toString() {
		return "Book [bid=" + bid + ", name=" + name + ", author=" + author + ", student.name=" + student.getName() + "]";
	}

}
