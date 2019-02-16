package com.lanou.bean;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author LiuXu
 * @time2018年8月16日下午5:33:02
 **/
public class Student implements Serializable {

	private int sid;
	private String name;
	// 表示多方集合
	private Set<Book> books = new HashSet<>();

	public Student() {
		super();
	}

	public Student(int sid, String name) {
		super();
		this.sid = sid;
		this.name = name;
	}

	public Student(int sid, String name, Set<Book> books) {
		super();
		this.sid = sid;
		this.name = name;
		this.books = books;
	}

	public int getSid() {
		return sid;
	}

	public void setSid(int sid) {
		this.sid = sid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<Book> getBooks() {
		return books;
	}

	public void setBooks(Set<Book> books) {
		this.books = books;
	}

	@Override
	public String toString() {
		return "Student [sid=" + sid + ", name=" + name + ", books=" + books + "]";
	}

}
