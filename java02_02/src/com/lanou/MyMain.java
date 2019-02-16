package com.lanou;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Map;

/**
 *
 * @author LiuXu
 * @time2018年6月29日上午11:40:14
 **/
public class MyMain {

	public static void main(String[] args) {
		// 实例化
		Demo2 d2 = new Demo2();
		// 调用查询的方法
		// d2.select();
		// d2.select1();
		// d2.update();
		// d2.select();
		// 实例化工具类
		SQLUtil1 ut = new SQLUtil1();
		// // 调用查询的方法
//		List<Map<String, Object>> lists= ut.exeQuery("select * from test2");
		
		// System.out.println("个数为:" + lists.size());
		//
		// // 遍历
		// for (Map<String, Object> map : lists) {
		//
		// for (String str : map.keySet()) {
		// System.out.print(str + ":" + map.get(str) + " ");
		// }
		// System.out.println();
		// }
		//
		// // 调用方法
		// boolean is =ut.exeUpdate("insert into test2 values(14,'ccc')");
		// System.out.println(is);
		// // 查询id=1的数据
		// List<Map<String, Object>> lists = ut.exeQuery("select * from test2
		// where id = 1");
		// // 获取属性值设置给类的对象的属性
		// Test2 t2 = new Test2();
		// //
		// t2.setId((int) lists.get(0).get("id"));
		// t2.setName((String) lists.get(0).get("name"));
		// System.out.println(t2);

		List<Map<String, Object>> lists = ut.exeQuery("select * from test2");
		List<Test2> list = new ArrayList<>();
		// 遍历
		for (Map<String, Object> map : lists) {
			Test2 t = new Test2();
			t.setId((int)map.get("id"));
			t.setName((String) map.get("name"));
			list.add(t);
		}
		// 遍历
		for (Test2 test2 : list) {
			System.out.println(test2.getId() + ":" + test2.getName());
		}
		
		
		
	}

}
