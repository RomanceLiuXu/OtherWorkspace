package com.lanou.dao;

import java.util.List;

import org.apache.commons.lang.ObjectUtils.Null;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.DetachedCriteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateCallback;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.lanou.bean.Student;

/**
 *
 * @author LiuXu
 * @time2018年8月27日下午1:34:18
 **/
@Repository("studentDao")
public class StudentDaoImpl implements StudentDao {

	@Autowired
	private HibernateTemplate hibernateTemplate;

	@Override
	public List<Student> findStudent(int page, int pageCount) {
		// List<Student> students = (List<Student>)
		// hibernateTemplate.findByCriteria(DetachedCriteria.forClass(Student.class),
		// 1, 2);

		List<Student> students = hibernateTemplate.execute(new HibernateCallback<List<Student>>() {
			@Override
			public List<Student> doInHibernate(Session session) throws HibernateException {
				String hql = "from Student";
				Query query = session.createQuery(hql);
				int start = (page - 1) * pageCount;
				query.setFirstResult(start);
				query.setMaxResults(pageCount);
				return query.list();
			}
		});

		if (students.isEmpty() || students.size() == 0) {
			return null;
		}
		return students;
	}

	@Override
	public void addStdent(Student student) {

		hibernateTemplate.save(student);
	}

	@Override
	public long findStuNum() {
		String hql = "select count(*) from Student";
		List<Long> num = (List<Long>) hibernateTemplate.find(hql);
		return num.get(0);
	}

}
