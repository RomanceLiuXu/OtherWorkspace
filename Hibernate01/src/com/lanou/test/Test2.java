package com.lanou.test;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.lanou.bean.Attendance;
import com.lanou.bean.Dept;
import com.lanou.util.HibernateUtil;

/**
 * junit单元测试
 * 
 * @author LiuXu
 * @time2018年8月15日下午4:37:24
 **/
public class Test2 {

	SessionFactory factory;

	@Before
	public void init() {
		factory = HibernateUtil.getSessionFactory();
	}

	/**
	 * 测试持久状态对象 内存中有对象，数据库中有与之对应的数据 当修改对象的属性时，数据库中数据也会跟着自动修改 
	 * 什么样的对象是持久状态的对象
	 * 1.新创建的对象调用save()或者saveOrUpdate() 
	 * 2.通过get()或者load()从数据库中加载出来的对象
	 * 所有持久化状态对象都会被存储在内存的session缓存区域中
	 */
	@Test
	public void test() {
		// 获取session对象
		Session session = factory.openSession();
		// 开启事务
//		Transaction ts = session.beginTransaction();
//		// 调用get方法获取一个持久状态的对象
//		Dept dept = (Dept) session.get(Dept.class, 2);
//		// 修改对象的属性
//		dept.setDeptName("市场部");
//		dept.setLocation("北京");
//		// 提交事务
//		ts.commit();
		Attendance a = (Attendance) session.get(Attendance.class, 1);
//		System.out.println(a.getCreateTime());
		Date d = new Date();
		Date d1 = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String format1 = sdf.format(d);
		String format3 = sdf.format(d1);
		String format2 = sdf.format(a.getCreateTime());
		System.out.println(format1+"----"+format2);
		System.out.println(format1.equals(format2));
		String hql = "from Attendance where jobnum=1801";
		Query query = session.createQuery(hql);
	    List<Attendance> list = query.list();
	    int n = 0;
		for (Attendance attendance : list) {
			if (sdf.format(attendance.getCreateTime()).equals(format1)) {
				n++;
			}
		}
		System.out.println("今日打卡次数:"+n);
		// 关闭session
		session.close();
	}

	/**
	 * 临时状态对象(瞬时态) 内存中有对象，数据库中没有与之对应的数据 
	 * 什么样的对象是临时状态 
	 * 1.新创建的对象
	 * 2.持久状态对象调用delete()方法
	 */
	@Test
	public void test2() {
		// 新建一个临时状态的对象
		Dept dept = new Dept(5, "销售部", "天津");
		// 临时态的对象调用save()或saveOrUpde()变为持久态
		// 获取session对象
		Session session = factory.openSession();
		// 开启事务
		Transaction ts = session.beginTransaction();
		session.save(dept);
		// 持久态的对象修改属性值
		// dept.setDeptNo(4);
		// 提交事务
		ts.commit();
		// 关闭
		session.close();
	}

	/**
	 * 游离对象 内存中有对象，数据库中有与之对应的数据 但是对象处于离线状态，
	 * 修改对象的属性，数据库中的数据不会跟着修改 
	 * 什么样的对象是游离状态
	 * 1.session关闭 
	 * 2.从session缓存中踢出了某个持久态对象 
	 * 3.清空session缓存
	 */
	@Test
	public void test3() {
		// 获取session对象
		Session session = factory.openSession();
		// 开启事务
		Transaction ts = session.beginTransaction();
		// 获取一个持久态对象
		Dept dept = (Dept) session.get(Dept.class, 2);
		// session关闭
		// session.close();
		// 从session中踢出了某个持久态对象
		// session.evict(dept);
		// 清空session缓存，踢出所有持久态对象
		session.clear();
		// 游离态对象回到持久态,调用update()或者saveOrUpdate()
		session.saveOrUpdate(dept);
		session.update(dept);
		dept.setLocation("上海");
		// 提交事务
		ts.commit();
		session.close();
	}

	@After
	public void destroy() {
		System.out.println("销毁操作");
	}
}
