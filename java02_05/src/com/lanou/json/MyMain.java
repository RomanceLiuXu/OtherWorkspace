package com.lanou.json;

import java.util.ArrayList;
import java.util.List;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.lanou.Car;

/**
 * Json
 * 
 * @author LiuXu
 * @time2018年7月4日下午4:01:57
 **/
public class MyMain {

	public static void main(String[] args) {
		// 对象--->Json串
		// Json串--->对象

		// // 简单类型的对象
		// String str = "哈哈";
		// int n = 10;
		// // 转json
		// JsonObject obj = new JsonObject();
		// // 向jsonobject中添加数据
		// obj.addProperty("con", str);
		// obj.addProperty("num", n);
		// // 将jsonobject转成字符串
		// String json = obj.toString();
		// System.out.println("js串:" + json);

		// // 自定义类型的对象
		// Car car = new Car("黑白", "西西欧系");
		// // 实例化
		// JsonObject obj = new JsonObject();
		// // 实例化
		// JsonObject jsonInner = new JsonObject();
		// // 设置
		// jsonInner.addProperty("name", car.getName());
		// jsonInner.addProperty("type", car.getType());
		// // 将内层jo加到外层jo中
		// obj.add("Car", jsonInner);
		//
		// System.out.println(obj.toString());
		//

		// 集合对象转JSON数据

		// 定义一个集合对象
		List<Car> cars = new ArrayList<>();
		// 实例化Car
		Car car1 = new Car("小花", "蓝鸥");
		Car car2 = new Car("小白", "汽车");
		Car car3 = new Car("小紫", "山地车");
		Car car4 = new Car("小黑", "越野车");
		// 将对象添加到集合中
		cars.add(car1);
		cars.add(car2);
		cars.add(car3);
		cars.add(car4);

		// 实例化 最外层
		JsonObject obj = new JsonObject();
		// 实例化--多个对象
		JsonArray ja = new JsonArray();
		// 遍历
		for (int i = 0; i < cars.size(); i++) {
			JsonObject objectinner = new JsonObject();
			objectinner.addProperty("name", cars.get(i).getName());
			objectinner.addProperty("type", cars.get(i).getType());

			// 将内层添加到JA中
			ja.add(objectinner);
		}
		// 将JA添加到JO中
		obj.add("cars", ja);
		// JO 转换为字符串
		System.out.println(obj.toString());

		// // 将json转为对象
		// String jsonStr =
		// "{'cars':[{'name':'小花','type':'蓝鸥'},{'name':'小白','type':'汽车'},{'name':'小黑','type':'越野车'}]}";
		//
		// List<Car> cars = new ArrayList<>();
		// // 实例化
		// JsonParser jp = new JsonParser();
		// // 通过jp获取JsonObject对象
		// JsonObject obj = (JsonObject) jp.parse(jsonStr);
		//
		// // 通过obj获取cars对应的集合对象
		// JsonArray arr = (JsonArray) obj.get("cars");
		//
		// // 遍历arr
		// for (int i = 0; i < arr.size(); i++) {
		// Car car = new Car();
		// JsonObject obj1 = (JsonObject) arr.get(i);
		// // System.out.println(obj1.get("name"));
		// car.setName(obj1.get("name").getAsString());
		// car.setType(obj1.get("type").getAsString());
		// cars.add(car);
		// }
		//
		// for (Car car : cars) {
		// System.out.println(car);
		// }
	}

}
