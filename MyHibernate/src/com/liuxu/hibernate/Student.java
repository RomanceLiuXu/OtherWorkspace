package com.liuxu.hibernate;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

/**
 * 一对多的一方
 * 
 * @author LiuXu
 * @time2018年8月16日下午5:33:02
 **/
@Entity
@Table(name = "student")
public class Student implements Serializable {

	@Id
	@Column(name = "s_id")
	private int sid;
	@Column(name = "s_name")
	private String name;
	// 表示多方集合
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "b_studentid")
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
