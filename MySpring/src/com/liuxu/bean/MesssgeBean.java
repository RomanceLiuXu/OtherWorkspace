package com.liuxu.bean;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Properties;
import java.util.Set;

/**
 *
 * @author LiuXu
 * @time2018年8月22日下午8:13:12
 **/
public class MesssgeBean {

    private String name;
    private int age;
    private List<String> list;
    private Set<String> set;
    private Map<String, String> map;
    private Properties properties;
    
    public void show(){
    	System.out.println(name);
    	System.out.println(age);
    	System.out.println("----list集合-----");
    	for (String list : list) {
			System.out.println(list);
		}
    	System.out.println("----set集合---");
    	for (String set : set) {
			System.out.println(set);
		}
    	System.out.println("----map集合---");
    	Set<Entry<String, String>> entrySet = map.entrySet();
    	for (Entry<String, String> entry : entrySet) {
			System.out.println(entry.getKey()+":"+entry.getValue());
		}
    	System.out.println("----properties---");
    	Set<Object> keySet = properties.keySet();
    	for (Object key : keySet) {
			System.out.println(key+":"+properties.getProperty(key+""));
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

	public List<String> getList() {
		return list;
	}

	public void setList(List<String> list) {
		this.list = list;
	}

	public Set<String> getSet() {
		return set;
	}

	public void setSet(Set<String> set) {
		this.set = set;
	}

	public Map<String, String> getMap() {
		return map;
	}

	public void setMap(Map<String, String> map) {
		this.map = map;
	}

	public Properties getProperties() {
		return properties;
	}

	public void setProperties(Properties properties) {
		this.properties = properties;
	}
	
}
