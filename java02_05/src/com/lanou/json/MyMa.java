package com.lanou.json;

import java.util.ArrayList;
import java.util.List;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

/**
 *
 * @author LiuXu
 * @time2018年7月4日下午4:38:25
 **/
public class MyMa {

	public static void main(String[] args) {

		MyTest<List<Test>> mt = new MyTest<List<Test>>();
		List<Test> ts = new ArrayList<>();
		mt.data = ts;
		mt.code = 200;
		mt.msg = "成功";
		// 创建集合
		// 实例化
		Test t1 = new Test("点击统计", 1, 35655);
		Test t2 = new Test("注册统计", 0, 3);
		Test t3 = new Test("点击统计", 2, 13);
		Test t4 = new Test("点击统计", 34, 34896);
		Test t5 = new Test("ekt", 9912, 2);
		// 添加到集合中
		ts.add(t1);
		ts.add(t2);
		ts.add(t3);
		ts.add(t4);
		ts.add(t5);

		// 实例化 -- 最外层
		JsonObject jo = new JsonObject();
		// 实例化--多个对象
		JsonArray ja = new JsonArray();
		// 遍历
		for (int i = 0; i < ts.size(); i++) {
			// 实例化
			JsonObject joinner = new JsonObject();
			// 设置
			joinner.addProperty("type", ts.get(i).getType());
			joinner.addProperty("typeId", ts.get(i).getTypeId());
			joinner.addProperty("count", ts.get(i).getCount());
			// 添加到ja中
			ja.add(joinner);
		}
		// 将ja添加到jo中
		jo.addProperty("code", mt.code);
		jo.addProperty("msg", mt.msg);
		jo.add("data", ja);

		// 转为字符串
		System.out.println(jo.toString());
		
	}

}
