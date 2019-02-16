package com.lanou.test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.lanou.bean.Card;
import com.lanou.bean.Emp;
import com.lanou.bean.Manager;
import com.lanou.bean.People;
import com.lanou.bean.Student;
import com.lanou.bean.Teacher;
import com.lanou.bean.Team;
import com.lanou.bean.User;
import com.lanou.dao.CardMapper;
import com.lanou.dao.EmpMapper;
import com.lanou.dao.ManagerMapper;
import com.lanou.dao.PeopleMapper;
import com.lanou.dao.StudentMapper;
import com.lanou.dao.TeacherMapper;
import com.lanou.dao.TeamMapper;
import com.lanou.util.MyBatisUtil;

/**
 *
 * @author LiuXu
 * @time2018年9月18日上午9:31:55
 **/
public class TestCase2 {

	SqlSessionFactory factory;
	SqlSession session;

	@Before
	public void InitialContext() {
		factory = MyBatisUtil.getSqlSessionFactory();
		session = factory.openSession();
	}

	/**
	 * 动态查询
	 */
	@Test
	public void test1() {
		Emp emp = new Emp();
		emp.setDeptno(20);
		List<Emp> emps = session.selectList("findEmps", emp);
		System.out.println(emps);
	}

	/**
	 * 动态查询
	 */
	@Test
	public void test2() {
		Emp emp = new Emp();
		emp.setSalary(5000);
		List<Emp> emps = session.selectList("findEmpsBySalary", emp);
		System.out.println(emps);
	}

	/**
	 * 动态查询
	 */
	@Test
	public void test3() {
		Emp emp = new Emp();
		List<Emp> emps = session.selectList("findEmpsBySex", emp);
		System.out.println(emps);
	}

	@Test
	public void test4() {
		Emp emp = new Emp();
		emp.setJob("销售");
		emp.setSalary(5000);
		List<Emp> emps = session.selectList("findEmpsByJobAndSalary", emp);
		for (Emp emp2 : emps) {
			System.out.println(emp2);
		}

	}

	@Test
	public void test5() {
		Emp emp = session.selectOne("findEmpById", 7);
		emp.setName("买买");
		emp.setSex(null);
		int rows = session.update("updateEmp", emp);
		System.out.println("修改的行数:" + rows);
		session.commit();
	}

	@Test
	public void test6() throws ParseException {
		// 获取一个映射接口
		EmpMapper mapper = session.getMapper(EmpMapper.class);
		// 查找单个
		Emp emp = mapper.findEmpById(2);
		// 更新
		emp.setName("新的2号");
		// 新增
		String date = "1962-12-12";
		mapper.addEmp(new Emp("最后的啦啦", "男", "市场", 54454, new SimpleDateFormat("yyyy-MM-dd").parse(date), 20));
		// 删除
		mapper.deleteEmpById(1);
		// 更新
		mapper.updateEmp(emp);
		// 查找所有
		List<Emp> emps = mapper.findAll();
		for (Emp emp2 : emps) {
			System.out.println(emp2);
		}
		System.out.println(emp);
	}

	@Test
	public void test7() {
		EmpMapper mapper = session.getMapper(EmpMapper.class);
		String name = mapper.findEmpNameById(2);
		System.out.println(name);
	}

	@Test
	public void testOneToOne() {
		// 获取映射接口对象
		ManagerMapper mapper = session.getMapper(ManagerMapper.class);
		// 调用接口查询方法
		Manager m = mapper.findManagerById(1);
		System.out.println(m);
		// 级联获取关联一方的对象
		Team team = m.getTeam();
		System.out.println(team);
	}

	/**
	 * 测试一对一
	 */
	@Test
	public void testOneToOne1() {
		TeamMapper mapper = session.getMapper(TeamMapper.class);
		Team t = mapper.findTeamById(1);
		System.out.println(t);
		System.out.println(t.getManager());
	}

	/**
	 * 测试一对多和多对一
	 */
	@Test
	public void testonetoMany() {
		// PeopleMapper mapper = session.getMapper(PeopleMapper.class);
		// People people = mapper.findPeopleById(1);
		// System.out.println(people);
		// System.out.println(people.getCards());
		CardMapper mapper = session.getMapper(CardMapper.class);
		Card card = mapper.findCardById(4);
		System.out.println(card);
		System.out.println(card.getPeople());
	}

	/**
	 * 多对多的级联查询
	 */
	@Test
   public void testmanytoMany(){
//		   TeacherMapper mapper = session.getMapper(TeacherMapper.class);
//		   Teacher t = mapper.findTeacherById(1);
//		   System.out.println(t);
//		   System.out.println(t.getStudents());
		StudentMapper mapper = session.getMapper(StudentMapper.class);
		Student student = mapper.findStudentById(1);
		System.out.println(student);
		System.out.println(student.getTeachers());
   }
	
	@After
	public void destroy() {
		session.close();
	}

}
