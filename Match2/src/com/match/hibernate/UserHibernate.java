package com.match.hibernate;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.liuxu.beans.User;
import com.match.hibernateI.UserHibernateI;
import com.match.util.HibernateUtil;

/**
 *
 * @author LiuXu
 * @time2018年8月18日下午5:26:16
 **/
public class UserHibernate implements UserHibernateI {

	private Session session;

	/**
	 * 构造方法
	 */
	public UserHibernate() {
		// 实例化SessionFactory
		SessionFactory factory = HibernateUtil.getSessionFactory();
		// 获取session对象
		session = factory.openSession();
	}

	// 登录
	@Override
	public User login(User user) {
		User sUser = new User();
		if (user != null) {
			// 查询数据库的数据
			String hql = "from User where name=? and psw=?";
			Query query = session.createQuery(hql);
			// 给占位符赋值
			query.setString(0, user.getName());
			query.setString(1, user.getPsw());
			// 查询
			sUser = (User) query.uniqueResult();
		}

		return sUser;
	}

	// 主页的数据显示
	@Override
	public List<User> findAllUsers(User user) {
		List<User> users = new ArrayList<User>();
		if (user != null) {
			String hql = "from User";
			Query query = session.createQuery(hql);
			users = query.list();
		}

		return users;
	}

	// 注册
	@Override
	public boolean register(User user) {
		boolean isRegister = false;
		if (user != null) {
			Transaction tx = session.beginTransaction();
			session.save(user);
			isRegister = true;
			tx.commit();
		}
		session.close();
		return isRegister;
	}

	// 同城匹配
	@Override
	public List<User> sameCity(User user) {
		List<User> users = new ArrayList<User>();
		if (user != null) {
			String address = user.getAddress().substring(0, 2);
			String hql = "from User where address like '" + address + "%'";
			Query query = session.createQuery(hql);
			users = query.list();
		}
		session.close();
		return users;
	}

	// 异城匹配
	@Override
	public List<User> notSameCity(User user) {
		List<User> users = new ArrayList<User>();
		if (user != null) {
			String address = user.getAddress().substring(0, 2);
			String hql = "from User where address not like '" + address + "%'";
			Query query = session.createQuery(hql);
			users = query.list();
		}
		session.close();
		return users;
	}

	// 修改密码
	@Override
	public boolean updatePsw(User user, String newPsw) {
		boolean isUpdate = false;
		if (user != null) {
			Transaction tx = session.beginTransaction();
			user.setPsw(newPsw);
			session.save(user);
			tx.commit();
			isUpdate = true;
		}
		session.close();
		return isUpdate;
	}

	// 找回密码
	@Override
	public User checkPsw(String name, String answer) {
		User user = new User();
		Transaction tx = session.beginTransaction();
		String hql = "from User where name=? and answer=?";
		Query query = session.createQuery(hql);
		query.setString(0, name);
		query.setString(1, answer);
		user = (User) query.uniqueResult();
		tx.commit();
		return user;
	}

}
