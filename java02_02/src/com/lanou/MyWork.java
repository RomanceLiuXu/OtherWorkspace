package com.lanou;

import java.util.List;
import java.util.Map;


/**
 *
 * @author LiuXu
 * @time2018年6月29日下午7:44:51
 **/
public class MyWork {

	public static void main(String[] args) {
		// 实例化
		SQLUtil1 sUt = new SQLUtil1();

		// 调用方法
		List<Map<String, Object>> lists = sUt.exeQuery("select * from student");
		// List<Map<String, Object>> lists1 = sUt.exeQuery("select sum_score
		// from student ");
//		List<Map<String, Object>> lists2 = sUt.exeQuery("select * from student where english < 60");
		List<Map<String, Object>> lists3 = sUt.exeQuery("select * from student order by sum_score desc");

		//
		// boolean is = sUt.exeUpdate("insert into student
		// values(7,'周周1','男',26,65,60,65,190),(8,'周周2','男',26,65,60,65,190),(9,'周周3','男',26,65,60,65,190),(10,'周周4','男',26,65,60,65,190),(11,'周周1','男',26,65,60,75,190)");
		// System.out.println(is);

		// sUt.exeUpdate("insert into student
		// values(12,'周周1','男',26,65,60,65,190)");
		// sUt.exeUpdate("insert into student
		// values(13,'周周','男',26,65,60,65,190)");

//		String sql = "update student set age = age+1 where sex = '男'";
//		boolean is = sUt.exeUpdate(sql);
//		System.out.println(is);

	    
//		 sUt.exeUpdate("delete from student where id = 11");
 	
		 List<Map<String, Object>> lists4 = sUt.selectByPage(1,6);
		// 遍历打印所有
		 for (Map<String, Object> map : lists4) {
		 for (String str : map.keySet()) {
		 System.out.print(str + ":" + map.get(str) + " ");
		 }
		 System.out.println();
		 }

		// 遍历打印
//		for (Map<String, Object> map : lists2) {
//			for (String str : map.keySet()) {
//				System.out.print(str + ":" + map.get(str) + "    ");
//			}
//			System.out.println();
//		}
	}

}
