package com.stu.mvc.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.stu.mvc.beans.Student;
import com.stu.mvc.controller.stuServlet;
import com.stu.mvc.dao.interf.stuDaoInterf;
import com.stu.util.SQLUtil2;

/**
 *
 * @author LiuXu
 * @time2018年7月9日下午9:12:02
 **/
public class stuDao implements stuDaoInterf {

	@Override
	public List<Student> findStudents(int page, int pnum) {

		List<Student> students = new ArrayList<>();
		// 通过page和pnum查询
		int start = (page - 1) * pnum;
		// 准备sql语句
		String sql = "select * from student limit " + start + "," + pnum;
		System.out.println(sql);
		ResultSet rs = SQLUtil2.qureyMethod(sql, null);
		if (rs != null) {
			try {
				while (rs.next()) {
					Student student = new Student();
					student.setId(rs.getString("s_id"));
					student.setBirth(rs.getString("s_birth"));
					student.setName(rs.getString("s_name"));
					student.setSex(rs.getString("s_sex"));
					students.add(student);
				}
			} catch (SQLException e) {

				e.printStackTrace();
			}
		}

		return students;
	}

	@Override
	public int getNum(String tableName, int pnum) {
		String sql = "select count(*) from student";
//		String[] str = { tableName };
		ResultSet rs = SQLUtil2.qureyMethod(sql, null);
		int num = 0 ;
		// 遍历
		if (rs != null) {
			try {
				while (rs.next()) {
               num = rs.getInt("count(*)");
                  
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}
//		计算页码
		if (num % pnum ==0) {
			num = num / pnum;
		}else {
			num = num / pnum + 1; 
		}

		return num;
	}

}
