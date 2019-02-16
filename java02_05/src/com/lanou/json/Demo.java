package com.lanou.json;

import java.util.ArrayList;
import java.util.List;

import com.alibaba.fastjson.JSON;
import com.lanou.Car;

/**
 *
 * @author LiuXu
 * @time2018年7月4日下午5:24:44
 **/
public class Demo {

	public static void main(String[] args) {

		Car car = new Car("小盒", "大众");
		Car car1 = new Car("小da", "大众");
		List<Car> list = new ArrayList<>();
		list.add(car);
		list.add(car1);
		String string = JSON.toJSONString(list);
		System.out.println(string);

		// {"name":"小盒","type":"大众"}

		String str = "{'name':'小盒','type':'大众'}";
		Car car2 = (Car) JSON.parseObject(str, Car.class);
		System.out.println(car2);

	}

}
