package com.match.dao;

import com.match.beans.User;
import com.match.dao.interf.newpswDaoI;
import com.match.util.SQLUtil2;

/**
 *
 * @author keb
 * @tim2018年7月14日上午8:58:00
 **/
public class newpswDaoE implements newpswDaoI {

	@Override
	public boolean newpswMethod(User user) {
		String newpsw = "'" + user.getPsw() + "'";
		String name = "'" + user.getName() + "'";

		// 掉工具类的修改方法
		// 准备sql语句
		String sql = "update user set psw =" + newpsw + " where name=" + name;
		boolean boo = SQLUtil2.updateMethod(sql, null);
		return boo;
	}

}
