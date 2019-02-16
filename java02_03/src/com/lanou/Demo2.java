package com.lanou;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * 存储过程的调用
 * 
 * @author LiuXu
 * @time2018年7月2日下午4:58:50
 **/
public class Demo2 {

	public static void main(String[] args) {
		// 调用存储过程
		// test1();
		// 调用存储过程
		// test2();
	}

	public static void test1() {
		CallableStatement cs = null;
		// 获取连接
		Connection con = SQLUtil2.getCon();
		//
		if (con != null) {
			// 定义变量
			int n = 8;
			// 调用存储过程method9并获取CallableStatement的对象
			try {
				cs = con.prepareCall("{call method9(" + n + ")}");
				boolean bo = cs.execute();
				// 判断结果 true--查询 false--非查询
				if (bo) {
					System.out.println("存储过程执行查询");
				} else {
					System.out.println("存储过程执行非查询");
				}
			} catch (SQLException e) {
				e.printStackTrace();
				System.out.println("存储过程执行失败");
			} finally {
				SQLUtil2.myClose(con);
				SQLUtil2.myClose(cs);
			}
		}
	}

	public static void test2() {
		CallableStatement cs = null;
		// 获取连接
		Connection con = SQLUtil2.getCon();
		//
		if (con != null) {
			// 定义变量
			int n = 8;
			// 调用存储过程method9并获取CallableStatement的对象
			try {
				cs = con.prepareCall("{call method9(?)}");
				// 给占位符进行赋值操作
				cs.setInt(1, 9);

				boolean bo = cs.execute();
				// 判断结果 true--查询 false--非查询
				if (bo) {
					System.out.println("存储过程执行查询");
				} else {
					System.out.println("存储过程执行非查询");
				}
			} catch (SQLException e) {
				e.printStackTrace();
				System.out.println("存储过程执行失败");
			} finally {
				SQLUtil2.myClose(con);
				SQLUtil2.myClose(cs);
			}
		}
	}

}
