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
		String sqljudge = "select name from user;";
		ResultSet rs = SQLUtil2.queryMethod(sqljudge, null);
		//遍历rs;
		try {
			while(rs.next()){
				String existname = rs.getString("name");
				System.out.println(existname);
				if (existname.equals(judgename)) {
					//存在用户名,则说明添加失败
					flag = false;
				}
			}
			if (flag) {
				//准备数据--表明
				String tableName = "user";
				//准备添加的字段集合数据
				String name = "'"+user.getName()+"'";
				int age = user.getAge();
				String sex = "'"+user.getSex()+"'";
				String address = "'"+user.getAddress()+"'";
				String psw = "'"+user.getPsw()+"'";
				String answer = "'"+user.getAnswer()+"'";
				//声明一个Object 类型的数组,方便存储各类型添加数据
				Object[]arr =new Object[6];
				//添加至集合内
				arr[0]=name;
				arr[1]=age;
				arr[2]=sex;
				arr[3]=address;
				arr[4]=psw;
				arr[5]=answer;
				//掉方法jdbc连接数据库
				boolean boo = SQLUtil2.addobject(tableName, arr);
				//将是否注册成功返回给servlet;
				//判断是否注册成功,成功则根据姓名获取ID,否则返回-1;
				if (!boo) {
					return uid;
				}else{
					//再次查询表中数据,找到name与刚才添加的姓名相等的ID
					//准备sql语句
					String sqlqurre = "select uid from user where name ="+"'"+judgename+"'";
					ResultSet rse = SQLUtil2.queryMethod(sqlqurre, null);
					//遍历rse,然后找到name对应的ID
					while(rse.next()){
						 uid = rse.getInt("uid");
					}
				}
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		//将刚才添加的用户的uid返回去
		System.out.println(uid);
		return uid;
		
		
		
		
	}

}
