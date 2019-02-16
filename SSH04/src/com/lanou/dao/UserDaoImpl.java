package com.lanou.dao;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.lanou.bean.User;

/**
 *
 * @author LiuXu
 * @time2018年9月10日上午11:33:56
 **/
@Repository("userDao")
public class UserDaoImpl implements UserDao {

	@Resource
	private HibernateTemplate hibernateTemplate;
	@Override
	public User findUserByUsernameAndPassword(String username, String password) {
		String hql = "from User where username=? and password=?";
		List<User> user = (List<User>) hibernateTemplate.find(hql, username,password);
		if (user==null || user.isEmpty()) {
			return null;
		}else{
			return user.get(0);
		}
	}

}
