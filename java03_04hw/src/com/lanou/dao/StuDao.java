package com.lanou.dao;

import com.lanou.bean.Student;
import com.lanou.dao.interf.StuDaOI;
import com.lanou.util.SQLUtil2;

/**
 *
 * @author LiuXu
 * @time2018年7月30日下午8:19:24
 **/
public class StuDao implements StuDaOI {

	@Override
	public String reginsterCheck(Student student) {
		String result = "error";
		if (student != null) {
			String sql = "insert into mstudent values(?,?,?,?,?)";
			String[] parm = { 0 + "", student.getCode(), student.getPsw(), student.getAge()+"", student.getSex()};
			boolean IsAdd = SQLUtil2.updateMethod(sql, parm);
			if (IsAdd) {
				result = "success";
			}

		}
		return result;

	}

}
