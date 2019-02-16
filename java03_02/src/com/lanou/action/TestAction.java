package com.lanou.action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.lanou.bean.Car;

/**
 * 测试的action
 * 
 * @author LiuXu
 * @time2018年7月26日上午11:35:49
 **/
public class TestAction {

	private String name;

	private Car car;
	
	private List<Car> cars;
	
	private Map<String, Car> maps;

	public String method1() {

		System.out.println(name);
		return "success";
	}

	public String method2() {
		// 成员变量设置值
		this.setName("liuxu");
		// 实例化
		car = new Car("小白", "大众", 20000);
		cars = new ArrayList<>();
		cars.add(car);
		maps = new HashMap<>();
		maps.put("one", car);
		return "success";
	}

	public String method3() {
		
		return "error";
	}
	
	
	public Map<String, Car> getMaps() {
		return maps;
	}

	public void setMaps(Map<String, Car> maps) {
		this.maps = maps;
	}

	public List<Car> getCars() {
		return cars;
	}

	public void setCars(List<Car> cars) {
		this.cars = cars;
	}

	public Car getCar() {
		return car;
	}

	public void setCar(Car car) {
		this.car = car;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	/**
	 * action中默认执行的方法: 当struts.xml中的action中未指定method属性，则执行该方法
	 * 
	 * @return 返回结果
	 */
	// public String execute() {
	//
	// return "lhl";
	// }

}
