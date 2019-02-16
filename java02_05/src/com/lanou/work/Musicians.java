package com.lanou.work;

/**
 *
 * @author LiuXu
 * @time2018年7月4日下午10:24:48
 **/
public class Musicians {

	private String firstName;
	private String lastName;
	private String instrument;

	public Musicians() {
		super();
	}

	public Musicians(String firstName, String lastName, String instrument) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.instrument = instrument;
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

	public String getInstrument() {
		return instrument;
	}

	public void setInstrument(String instrument) {
		this.instrument = instrument;
	}

}
