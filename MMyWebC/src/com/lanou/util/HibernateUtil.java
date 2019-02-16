package com.lanou.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * 获取session对象的工具类
 * 
 * @author LiuXu
 * @time2018年8月15日下午4:34:41
 **/
public class HibernateUtil {

	public static SessionFactory getSessionFactory() {
		// 加载Hibernate主配置文件
		Configuration cfg = new Configuration();
		// 加载配置文件
		cfg.configure("hibernate.cfg.xml");
		// 获取SessionFactory工厂对象
		SessionFactory factory = cfg.buildSessionFactory();
		return factory;
	}

}
