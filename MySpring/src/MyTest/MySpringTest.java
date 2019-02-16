package MyTest;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.liuxu.action.EmpAction;
import com.liuxu.bean.Emp;
import com.liuxu.bean.MesssgeBean;
import com.liuxu.bean.School;
import com.liuxu.bean.Student;
import com.liuxu.bean.Teacher;

/**
 *
 * @author LiuXu
 * @time2018年8月22日下午8:38:01
 **/
public class MySpringTest {

	AbstractApplicationContext ac;

	@Before
	public void init() {
		String cfg = "applicationContext.xml";
		ac = new ClassPathXmlApplicationContext(cfg);
	}

	/**
	 * 各种类型的依赖注入
	 */
	@Test
	public void test1() {
		MesssgeBean msg = ac.getBean("msg2", MesssgeBean.class);
		msg.show();
	}

	/**
	 * 注解的用法
	 */
	@Test
	public void test2() {
		// Student student = ac.getBean("stu", Student.class);
		// student.show();
		// Teacher teacher = ac.getBean("tea", Teacher.class);
		// teacher.show();
		School school = ac.getBean("sch", School.class);
		school.show();
	}

	@Test
	public void test3() {
		EmpAction action = ac.getBean("empAction", EmpAction.class);
		action.showAll();

	}

}
