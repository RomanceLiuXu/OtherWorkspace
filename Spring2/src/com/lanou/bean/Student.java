package com.lanou.bean;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 *
 * @author LiuXu
 * @time2018年8月22日下午5:29:01
 **/
@Component("stu")
public class Student {

	@Value("liuxu")
	private String name;
	@Value("男")
	private String gender;
	@Value("${jdbc.driver}")
	private String driver;
	@Value("${jdbc.url}")
	private String url;
	
	
	
	public void show() {
		System.out.println(name);
		System.out.println(gender);
		System.out.println(driver);
		System.out.println(url);
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getDriver() {
		return driver;
	}
	public void setDriver(String driver) {
		this.driver = driver;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	
	
	
}
