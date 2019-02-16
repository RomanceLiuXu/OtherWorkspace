package com.lanou;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author LiuXu
 * @time2018年7月2日下午7:55:41
 **/
public class myWork {

	public static void main(String[] args) {
		// 准备sql语句
		String sql = "select * from users where code = ? and psw = ?";
		// 准备账号和密码
		// System.out.println("请输入账号:");
		String code = "小王";
		// System.out.println("请输入密码:");
		String psw = "123456";
		// 准备登录数组
		String[] parm = {code, psw};
		// 调用方法，返回结果集
		ResultSet rs = SQLUtil2.qureyMethod(sql, parm);
		try {
			if (rs.next()) {
				System.out.println("登录成功");
			} else {
				System.out.println("登录失败");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		// 准备sql语句
		String sql1 = "select * from users";
		// 调用方法,返回结果集
		ResultSet rs1 = SQLUtil2.qureyMethod(sql1, null);
		// 创建list集合
		List<Person> lists = new ArrayList<>();
		// 遍历结果集
		try {
			while (rs1.next()) {
				Person person = new Person();
				person.setId(rs1.getInt("id"));
				person.setCode(rs1.getString("code"));
				person.setPsw(rs1.getString("psw"));
				lists.add(person);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		// 遍历list集合
		for (Person person : lists) {
			System.out.println(person);
		}

		// 增加一个用户
		// 准备数组
		// String[] parm1 = { "4", "'小李'", "'li12345'" };
		// boolean b = SQLUtil2.insertMethod("users", parm1);
		// if (b) {
		// System.out.println("新增用户成功");
		// } else {
		// System.out.println("新增用户失败");
		// }

		// 修改某一用户的密码
		// 新密码
		String nPsw = "'new123456'";
		// 准备sql语句
		String sql2 = "update users set psw=" + nPsw + " where id = ?";
		// 准备数组
		String[] parm2 = { "1" };
		// 获取对应的list集合中对应person对象的下标
		int index = Integer.parseInt(parm2[0]);
		// 修改对应属性值
		lists.get(index - 1).setPsw(nPsw);
		// 调用方法
		boolean is = SQLUtil2.updateMethod(sql2, parm2);
		if (is) {
			System.out.println("修改成功");
		} else {
			System.out.println("修改失败");
		}

	}

}
