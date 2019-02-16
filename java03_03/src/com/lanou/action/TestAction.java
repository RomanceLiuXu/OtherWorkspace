package com.lanou.action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.lanou.bean.Person;

/**
 *
 * @author LiuXu
 * @time2018年7月27日上午9:28:29
 **/
public class TestAction {

	private String one;
	private String two;
	private String msg;// 接口请求后返回的消息
	private Person person;
	List<Person> persons;
	private Map<String, Object> maps;

	public List<Person> getPersons() {
		
		return persons;
	}

	public void setPersons(List<Person> persons) {
		this.persons = persons;
	}

	public String method1() {

		msg = "success";
		return "success";
	}

	public String method2() {
		person = new Person("liuxu", "男", 20);

		return "true";
	}

	public String method3() {
		persons = new ArrayList<>();
		persons.add(new Person("liuxu", "nan", 20));
		persons.add(new Person("liuxu1", "nan", 20));
		persons.add(new Person("liuxu2", "nan", 20));
		return "success3";
	}

	public String method4() {
		maps = new HashMap<>();
		persons = new ArrayList<>();
		persons.add(new Person("liuxu", "nan", 20));
		persons.add(new Person("liuxu1", "nan", 20));
		persons.add(new Person("liuxu2", "nan", 20));
        maps.put("code", 200);
        maps.put("message", "请求成功");
        maps.put("content", persons);
        return "success4";
	}
	
	public Map<String, Object> getMaps() {
		
		return maps;
	}

	public void setMaps(Map<String, Object> maps) {
		this.maps = maps;
	}

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public String getOne() {
		return one;
	}

	public void setOne(String one) {
		this.one = one;
	}

	public String getTwo() {
		return two;
	}

	public void setTwo(String two) {
		this.two = two;
	}

}
