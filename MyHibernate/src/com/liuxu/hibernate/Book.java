package com.liuxu.hibernate;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * 一对多的多方
 * 
 * @author LiuXu
 * @time2018年8月16日下午5:33:11
 **/
@Entity
@Table(name = "book")
public class Book implements Serializable {

	@Id
	@Column(name = "b_id")
	private int bid;
	@Column(name = "b_name")
	private String name;
	@Column(name = "b_author")
	private String author;
	// 表示当前图书属于哪个student
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "b_studentid")
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
		return "Book [bid=" + bid + ", name=" + name + ", author=" + author + ", student.name=" + student.getName()
				+ "]";
	}

}
