package com.lanou.dao;

import java.util.List;

import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.lanou.bean.User;

import sun.misc.Signal;

/**
 *
 * @author LiuXu
 * @time2018年8月25日下午2:24:51
 **/
@Repository("userDao")
public class UserDaoImpl implements UserDao {
	@Autowired
	private HibernateTemplate hibernateTemplate;

	@Override
	public User findUser(User user) {
		String hql = "from User where name=? and password=?";
//		String[] value = new String[] {user.getName(), user.getPassword()};
		
		List<User>  singleUser = (List<User>) hibernateTemplate.find(hql, user.getName(),user.getPassword());
        if (singleUser.size()!=0) {
        	return singleUser.get(0);
		}
        return null;
	}

	@Override
	public void saveUser(User user) {
         hibernateTemplate.save(user);
	}

	@Override
	public boolean checkUser(String username) {
		String hql = "from User where name=?";
		List<User> user = (List<User>) hibernateTemplate.find(hql, username);
		if (user.size()!=0) {
			return false;
		}
		return true;
	}

	
	}
