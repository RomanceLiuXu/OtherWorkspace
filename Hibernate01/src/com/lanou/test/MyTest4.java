package com.lanou.test;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.junit.Before;
import org.junit.Test;

import com.lanou.bean.Book;
import com.lanou.bean.Dept;
import com.lanou.bean.Emp;
import com.lanou.bean.Student;
import com.lanou.util.HibernateUtil;

/**
 *
 * @author LiuXu
 * @time2018年8月16日下午7:39:14
 **/
public class MyTest4 {

	Session session;

	@Before
	public void init() {
		SessionFactory factory = HibernateUtil.getSessionFactory();
		session = factory.openSession();
	}

	/**
	 * HQL查询
	 */
	@Test
	public void test1() {
		// hql语句 Dept为类名
		String hql = "from Dept";
		// 获取query对象
		Query query = session.createQuery(hql);
		// 调用list()方法
		// List<Dept> depts = query.list();
		// for (Dept dept : depts) {
		// System.out.println(dept);
		// }
		// Iterator<Dept> iterate = query.iterate();
		// while (iterate.hasNext()) {
		// Dept dept = iterate.next();
		// System.out.println(dept.getDeptName());
		// }
		// 查询确定返回一个确定的值时使用uniqueResult()方法
		hql = "from Dept where deptNo=7";
		query = session.createQuery(hql);
		Dept dept = (Dept) query.uniqueResult();
		System.out.println(dept);
		// 关闭
		session.close();
	}

	/**
	 * 给占位符赋值
	 */

	@Test
	public void test3() {
		String hql = "from Dept where deptNo=?and deptName=?";
		Query query = session.createQuery(hql);
		// 占位符从0开始
		query.setInteger(0, 7);
		query.setString(1, "营销部");
		hql = "from Dept where deptNo=:deptNo and deptName=:deptName";
		query = session.createQuery(hql);
		// 给占位符赋值
		query.setParameter("deptNo", 7);
		query.setParameter("deptName", "营销部");

		Dept dept = (Dept) query.uniqueResult();
		System.out.println(dept);
	}

	/**
	 * 使用动态参数查询
	 * 
	 * @throws ParseException
	 */
	@Test
	public void test2() throws ParseException {

		Criteria criteria = session.createCriteria(Emp.class);
		// 查询id为5
		criteria.add(Restrictions.lt("eid", 5));
		// 查询入职时间在2015年之后
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		criteria.add(Restrictions.gt("hiredate", df.parse("2015-01-01")));// 测试不包含此日期
		// 工资大于5000的
		criteria.add(Restrictions.gt("salary", Double.valueOf(5000)));
		List<Emp> list = criteria.list();
		for (Emp emp : list) {
			System.out.println(emp);
		}

	}

	/**
	 * 分页查询
	 */
	@Test
	public void test4() {
		String hql = "from Emp";
		Query query = session.createQuery(hql);
		int page = 2;
		int pageCount = 2;
		query.setFirstResult(page);
		query.setMaxResults(pageCount);
		List<Emp> list = query.list();
		for (Emp emp : list) {
			System.out.println(emp);
		}
		// 查询总页数
		// 先查询总记录条数
		hql = "select count(*) from Emp";
		query = session.createQuery(hql);
		long count = (long) query.uniqueResult();
		long allPageCount = count % pageCount == 0 ? count / pageCount : count / pageCount + 1;
		System.out.println(count);
		System.out.println("总页数:"+allPageCount);
	}
	
	/**
	 * 多表联查
	 */
	@Test
	public void test5(){
		String hql = "select b.name,s.name from Book as b,Student as s where b.student.sid = s.sid";
		Query query = session.createQuery(hql);
		List<Object[]> objects = query.list();
		for (Object[] objects2 : objects) {
			for (Object object : objects2) {
				System.out.println(object);
			}
		}
		session.close();
	}
	
	@Test
	public void test6() {
		Transaction tx = session.beginTransaction();
		Book book1 = (Book) session.get(Book.class, 1);
		Book book2 = (Book) session.get(Book.class, 2);
		Set<Book> books = new HashSet<>();
		books.add(book1);
		books.add(book2);
	    Student student = new Student(2, "wx", books);
	    session.saveOrUpdate(student);
	    tx.commit();
	    session.close();
	}
}
