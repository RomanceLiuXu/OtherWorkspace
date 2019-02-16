package com.lanou;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author LiuXu
 * @time2018年7月2日下午2:17:44
 **/
public class MyMain {

	public static void main(String[] args) {
		// // 准备sql语句
		// String sql = "insert into test3 values(?,?)";
		// // 准备占位符数据数组
		// String[] parm = { "4", "lhl4" };
		// boolean is = SQLUtil2.updateMethod(sql, parm);
		// System.out.println(is);

		// // 准备sql语句
		// String sql = "select * from test3 where id = ?";
		// // 准备占位符数据
		// String[] parm = {"1"};
		// // ResultSet q = SQLUtil2.qureyMethod(sql, parm);
		// String sql = "select * from test3";
		// ResultSet q = SQLUtil2.qureyMethod(sql, null);
		// if (q != null) {
		// try {
		// // 遍历
		// while (q.next()) {
		// // 获取id字段的值
		// int id = q.getInt("id");
		// // 获取name字段的值
		// String name = q.getString("name");
		// System.out.println(id + "--" + name);
		// }
		// } catch (SQLException e) {
		// e.printStackTrace();
		// } finally {
		// // 关闭
		// SQLUtil2.sqlClose();
		// }
		// }
		// System.out.println(q.toString());

		// 准备数组
		// String[] parm = { "5", "'lhl5'" };
		// boolean is = SQLUtil2.insertMethod("test3", parm);
		// System.out.println(is);

		// 删除的方法
		// 准备sql语句
		// String sql = "delete from orders where id = ?";
		// // 准备数组
		// String[] parm = {"9"};
		// boolean is = SQLUtil3.myDelete(sql, parm);
		// System.out.println(is);

		// 更新的方法
		// // 准备数组
		// String[] parm = { "liuxu", "1" };
		// boolean is = SQLUtil2.myUdate("orders", parm);
		// System.out.println(is);

		// 查询的方法
		String[] parm = { "1" };
		ResultSet rs = SQLUtil2.mySelect("orders", parm);
		// 遍历
		try {
			while (rs.next()) {
				int id = rs.getInt("id");
				String name = rs.getString("name");
				int price = rs.getInt("price");
				System.out.println(id + "---" + name + "---" + price);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
