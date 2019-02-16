package com.match.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.jws.soap.SOAPBinding.Use;


import com.match.beans.User;
import com.match.dao.interf.RegisterDaoI;
import com.match.util.SQLUtil2;

/**
 *
 * @author keb
 * @tim2018年7月12日下午3:44:18
 **/
public class RegisterDaoE implements RegisterDaoI{

	@Override
	public int addMethod(User user) {
		int uid = -1;
		boolean flag = true;
		//判断数据库是否存在改name;  
		//准备判断依据
		String judgename = user.getName();
		//掉查询方法,然后便利看是否有name相同的
		//准备sql语句
		String sqljudge = "select name from user where name='"+judgename+"'";
		ResultSet rs = SQLUtil2.queryMethod(sqljudge, null);
		try {
			if (rs.next()) {
				//存在
				flag = false;
			}else{
				//不存在
				String sql = "insert into user values(?,?,?,?,?,?,?)";
				String[] parm = { 0+"",user.getName(),user.getAge()+"",user.getSex(),user.getAddress(),user.getPsw(),user.getAnswer()};
			boolean is = SQLUtil2.updateMethod(sql, parm);
			if (is) {
				ResultSet rs1 = SQLUtil2.queryMethod("select uid from user where name='"+user.getName()+"'", null);
	            if (rs1.next()) {
					uid = rs1.getInt("uid");
				} 					
			}
			
			}
		} catch (SQLException e1) {
			
			e1.printStackTrace();
		}
	
		return uid;
		
	}

}
