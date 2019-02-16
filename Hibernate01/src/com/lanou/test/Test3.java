package com.lanou.test;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.CriteriaQuery;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import org.hibernate.engine.TypedValue;
import org.junit.Before;
import org.junit.Test;

import com.lanou.bean.Dept;
import com.lanou.bean.Emp;
import com.lanou.util.HibernateUtil;

import oracle.net.aso.i;

/**
 * 三种查询方式
 * 
 * @author LiuXu
 * @time2018年8月16日上午11:00:08
 **/
public class Test3 {

	Session session;

	@Before
	public void init() {
		SessionFactory factory = HibernateUtil.getSessionFactory();
		session = factory.openSession();
	}

	/**
	 * 通过HQL语句查询数据表中所有的数据 执行HQL语句方法
	 * list():当调用时会立即向数据库中发送sql语句，查询所有对象的完整信息并保存在list集合中
	 * 
	 * iterate()：当调用时会启用延迟加载，向数据库中发送sql语句，查询所有对象的id属性值，
	 * 返回的是代理对象（只有id），然后将这些代理对象保存在iterator迭代器中，当我们迭代
	 * 某个对象，需要查询这个对象的非id属性时，会拿出该对象的id值，去根据id发送sql语句查询该对象的完整信息
	 * 
	 * uniqueResult():当确定返回结果只有一个值时调用
	 */
	@Test
	public void test1() {
		// 定义一个查询所有数据的HQL(Dept是类名，首字母大写,deptNo是对象的属性值)
		String hql = "from Dept where deptNo=1";
		// query对象用于封装hql语句
		Query query = session.createQuery(hql);
		// 当确定返回结果只有一个值时，调用uniqueResult();
		Dept dept = (Dept) query.uniqueResult();
		System.out.println(dept);

		// 根据id查询名字(deptName deptNo为对象的属性值)
		hql = "select deptName from Dept where deptNo=7";
		query = session.createQuery(hql);
		String str = (String) query.uniqueResult();
		System.out.println(str);
		// 调用list方法执行hql语句（查找所有字段名）
		// List<Dept> depts = query.list();
		// for (Dept dept : depts) {
		// System.out.println(dept);
		//
		// }·
		// 使用iterate()方法执行hql语句(查询所有的id字段)
		// Iterator<Dept> iterate = query.iterate();
		// while (iterate.hasNext()) {
		// Dept dept = iterate.next();
		// System.out.println(dept.getDeptNo());
		// System.out.println(dept.getDeptName());
		// }

		// 关闭session
		session.close();
	}

	/**
	 * 给带占位符的hql语句赋值
	 */
	@Test
	public void test2() {
		// 定义带占位符的hql语句
		String hql = "from Dept where deptName=? and location=?";
		hql = "from Dept where deptName=:deptName and location=:location";
		// 通过query对象给占位符赋值，占位符下标从0开始
		Query query = session.createQuery(hql);
		// 以?充当占位符
		// query.setString(0, "销售部");
		// query.setString(1, "天津");
		// query.setParameter(0, "销售部");
		// query.setParameter(1, "天津");

		// 如果以冒号充当占位符
		// query.setString("deptName", "销售部");
		// query.setString("location", "天津");

		// query.setParameter("deptName", "销售部");
		// query.setParameter("location", "天津");

		// 以命名参数方式给占位符赋值(要求以冒号充当占位符)
		Map<String, String> map = new HashMap<>();
		map.put("deptName", "销售部");
		map.put("location", "天津");
		query.setProperties(map);

		Dept dept = (Dept) query.uniqueResult();
		System.out.println(dept);
		session.close();

	}

	/**
	 * 分页查询
	 */
	@Test
	public void test3() {
		// 定义sql
		String hql = "from Emp";
		// 创建query对象封装hql
		Query query = session.createQuery(hql);
		// 获取页码和页容
		int page = 2;
		int pageCount = 2;
		// 给limit后面的两个参数赋值
		query.setFirstResult((page - 1) * pageCount);
		query.setMaxResults(pageCount);
		List<Emp> list = query.list();
		for (Emp emp : list) {
			System.out.println(emp.toString());
		}
		// 查询总共有多少页
		// 先查询一共有多少条记录
		hql = "select count(*) from Emp";
		query = session.createQuery(hql);
		long rows = (long) query.uniqueResult();
		// 查询总页数
		long totalPages = rows % pageCount == 0 ? rows / pageCount : rows / pageCount + 1;
		System.out.println(rows);
		System.out.println("总页数:" + totalPages);
		session.close();
	}

	/**
	 * 查询总条数
	 */
	@Test
	public void conut() {
		String hql = "select count(*) from Emp";
		Query query = session.createQuery(hql);
		long count = (long) query.uniqueResult();
		System.out.println(count);
		session.close();
	}

	/**
	 * 动态参数查询
	 * @throws ParseException
	 */
	@Test
	public void test4() throws ParseException {
		// 创建一个Criteria对象，可以封装多个动态查询参数
		Criteria criteria = session.createCriteria(Emp.class);
		// 查询置位是CLERK的员工信息
		// Restrictions封装某一个动态查询参数
		criteria.add(Restrictions.eq("ejob", "CLERK"));
		// 薪水大于5000
		criteria.add(Restrictions.gt("salary", Double.valueOf(5000)));
		// 查询2015-2017年入职
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		criteria.add(Restrictions.between("hiredate", df.parse("2015-01-01"), df.parse("2017-12-31")));

		// 查询2014年之后入职并且薪水小于5000的员工信息
		criteria = session.createCriteria(Emp.class);
		criteria.add(Restrictions.and(Restrictions.gt("hiredate", df.parse("2014-1-1")),
				Restrictions.lt("salary", Double.valueOf(5000))));
		// 执行查询
		List<Emp> list = criteria.list();
		for (Emp emp : list) {
			System.out.println(emp);
		}
		session.close();
	}

	
	/**
	 * 原生sql语句查询
	 */
	@Test
	public void test5() {
		// 定义sql语句 emp为表名
		String sql = "select * from emp";
		// SQLQuery用于封装sql语句   addEntity 查询对应类型的实体
		SQLQuery query = session.createSQLQuery(sql).addEntity(Emp.class);
        //执行sql语句
		List<Emp> list = query.list();
		for (Emp emp : list) {
			System.out.println(emp);
		}
       session.close();
	}

}
