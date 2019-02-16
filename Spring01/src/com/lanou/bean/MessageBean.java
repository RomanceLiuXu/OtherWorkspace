package com.lanou.bean;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Properties;
import java.util.Set;

/**
 *
 * @author LiuXu
 * @time2018年8月22日上午10:19:16
 **/
public class MessageBean {

	private String name;
	private int age;
	private Date birthday;
	private List<Object> list;
	private Map<String, String> books;
	private Set<String> cities;
	private Properties props;
	
	
	public void show(){
		System.out.println(name);
		System.out.println(age);
		System.out.println(birthday);
		System.out.println("--list集合--");
		for (Object string : list) {
			System.out.println(string);
		}
		System.out.println("--map集合--");
		Set<Entry<String, String>> entrySet = books.entrySet();
		for (Entry<String, String> entry : entrySet) {
			System.out.println(entry.getKey()+":"+entry.getValue());
		}
		System.out.println("--set集合--");
		for (String city : cities) {
			System.out.println("city:"+city);
		}
		System.out.println("--properties--");
		Set<Object> keySet = props.keySet();
		for (Object key : keySet) {
			System.out.println(key+":"+props.getProperty(key+""));
		}
		
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


	public Date getBirthday() {
		return birthday;
	}


	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}


	public List<Object> getList() {
		return list;
	}


	public void setList(List<Object> list) {
		this.list = list;
	}


	public Map<String, String> getBooks() {
		return books;
	}


	public void setBooks(Map<String, String> books) {
		this.books = books;
	}


	public Set<String> getCities() {
		return cities;
	}


	public void setCities(Set<String> cities) {
		this.cities = cities;
	}


	public Properties getProps() {
		return props;
	}


	public void setProps(Properties props) {
		this.props = props;
	}
	
}
