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
public class TestCase3 {

	SqlSessionFactory factory;

	@Before
	public void InitialContext() {
		factory = MyBatisUtil.getSqlSessionFactory();
	}
     
	/**
	 * 一级缓存：相同的sqlSession多次执行相同的SQL语句
	 */
	@Test
	public void testFirstLevelCache(){
		SqlSession session = factory.openSession();
		PeopleMapper mapper = session.getMapper(PeopleMapper.class);
		People p1 = mapper.findPeopleById(1);
		PeopleMapper mapper1 = session.getMapper(PeopleMapper.class);
		People p2 = mapper1.findPeopleById(1);
		System.out.println(p1);
		System.out.println(p2);
	}
	
	/**
	 * 测试二级缓存
	 * 同一个Mapper下不同的sqlSession所共享的
	 * 不同的sqlSession对同一个mapper下的相同的sql语句执行查询会共享二级缓存
	 */
	@Test
    public void test2(){
    		SqlSession session1 = factory.openSession();
    		PeopleMapper mapper1 = session1.getMapper(PeopleMapper.class);
    		People people1 = mapper1.findPeopleById(1);
    		System.out.println(people1);
    		session1.close();
    		SqlSession session2 = factory.openSession();
    		PeopleMapper mapper2 = session2.getMapper(PeopleMapper.class);
    		People people2 = mapper2.findPeopleById(1);
    		System.out.println(people2);
    		session2.close();
    }
	
	
//	@After
//	public void destroy() {
//		session.close();
//	}

}
