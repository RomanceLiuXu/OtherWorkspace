package com.liuxu;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.realm.Realm;

import com.lanou.util.SQLUtil2;

/**
 *
 * @author LiuXu
 * @time2018年8月20日下午2:07:32
 **/
public class MyRealm implements Realm{

	@Override
	public AuthenticationInfo getAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
	String userName =  (String) token.getPrincipal();
	String password = new String((char[])token.getPrincipal());
    String sql = "select name from user where code=?";
    String[] parm = {userName}; 
	ResultSet rs = SQLUtil2.queryMethod(sql, parm);
	if (rs!=null) {
		try {
			if (rs.next()) {
				String doUserName = rs.getString("name");
				if (doUserName!=userName) {
					throw new UnknownAccountException("用户名不存在");
				}
				String doPassword = rs.getString("psw");
				if (doPassword!=password) {
					throw new IncorrectCredentialsException("密码错误");
				}
			}
		} catch (SQLException e) {
		
			e.printStackTrace();
		}
	}
	
		return null;
	}

	@Override
	public String getName() {
		
		return "MyRealm";
	}

	@Override
	public boolean supports(AuthenticationToken arg0) {
		// TODO Auto-generated method stub
		return false;
	}

}
