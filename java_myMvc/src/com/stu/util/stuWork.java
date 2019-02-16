package com.stu.util;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.alibaba.fastjson.JSON;

/**
 *
 * @author LiuXu
 * @time2018年7月9日下午10:11:55
 **/
public class stuWork {

//	public static void main(String[] args) {
//		// 获取list集合并解析为JSON字符串传送给前端
//		stuWork stuWork = new stuWork();
//		List<Student> students = stuWork.selectStus();
//		// 解析为json对象
//		String result = JSON.toJSONString(students);
//		System.out.println(result);
//	}

	// 连接数据库,查询数据
	public List<Student> selectStus() {
		List<Student> students = new ArrayList<>();
		String sql = "select * from student";
		ResultSet rs = SQLUtil2.qureyMethod(sql, null);
		// 遍历
		try {
			if (rs != null) {
				while (rs.next()) {
					// 实例化
					Student student = new Student();
					student.setId(rs.getString("s_id"));
					student.setName(rs.getString("s_name"));
					student.setBirth(rs.getString("s_birth"));
					student.setSex(rs.getString("s_sex"));
					students.add(student);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return students;
	}

}
