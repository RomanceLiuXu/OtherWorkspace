package com.lanou.work;

import java.util.ArrayList;
import java.util.List;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

/**
 *
 * @author LiuXu
 * @time2018年7月4日下午9:41:49
 **/
public class Work1 {

	public static void main(String[] args) {

		// 实例化
		Testdata2 td2_1 = new Testdata2("12", "11");
		Testdata2 td2_2 = new Testdata2("13", "14");
		Testdata2 td2_3 = new Testdata2("15", "16");
		// 新建list存放testdata2对象
		List<Testdata2> list1 = new ArrayList<>();
		list1.add(td2_1);
		list1.add(td2_2);
		list1.add(td2_3);

		// 实例化
		Testdata1<List<Testdata2>> td1 = new Testdata1<List<Testdata2>>("97895455", 3, list1);

		// 实例化
		AllTest<Testdata1<List<Testdata2>>> allTest = new AllTest<Testdata1<List<Testdata2>>>("wx9fdb8ble7ce3c68f",
				"123456789", td1);

		// 将对象解析为json数据

		// 实例化---最里层

		JsonObject obj1 = new JsonObject();
		// 实例化--多个对象
		JsonArray arr = new JsonArray();
		// 遍历
		for (int i = 0; i < list1.size(); i++) {
			JsonObject objInner = new JsonObject();
			objInner.addProperty("testshuzu1", list1.get(i).getTestshuzu1());
			objInner.addProperty("testshuzu2", list1.get(i).getTestshuzu2());
			// 将内层加到JA中
			arr.add(objInner);
		}
		// 将arr添加到obj1中
		obj1.add("testData2", arr);
		// System.out.println(obj1.toString());

		// 实例化
		JsonObject obj2 = new JsonObject();
		obj2.addProperty("testdatason1", td1.getTestdatason1());
		obj2.addProperty("testdatason1", td1.getTestdatason2());
		obj2.add("testData2", obj1);

		// 实例化 -- 最外层
		JsonObject obj = new JsonObject();
		obj.addProperty("test1", allTest.getTest1());
		obj.addProperty("test2", allTest.getTest2());
		obj.add("testData1", obj2);

		System.out.println(obj.toString());
		// // 实例化 最外层
		// JsonObject obj = new JsonObject();
		// // 实例化--多个对象
		// JsonArray ja = new JsonArray();
		// // 遍历
		// for (int i = 0; i < cars.size(); i++) {
		// JsonObject objectinner = new JsonObject();
		// objectinner.addProperty("name", cars.get(i).getName());
		// objectinner.addProperty("type", cars.get(i).getType());
		//
		// // 将内层添加到JA中
		// ja.add(objectinner);
		// }
		// // 将JA添加到JO中
		// obj.add("cars", ja);
		// // JO 转换为字符串
		// System.out.println(obj.toString());

	}

}
