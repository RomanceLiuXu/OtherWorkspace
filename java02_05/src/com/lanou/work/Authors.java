package com.lanou.work;

/**
 *
 * @author LiuXu
 * @time2018年7月4日下午10:24:23
 **/
public class Authors {

	private String firstName;
	private String lastName;
	private String genre;

	public Authors() {
		super();
	}

	public Authors(String firstName, String lastName, String genre) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.genre = genre;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

}
