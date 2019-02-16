package com.lanou.test;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.subject.Subject;
import org.junit.Assert;
import org.junit.Test;

/**
 * shiro之登录/退出
 * 
 * SecurityManager 安全管理器
 * 即所有与安全有关的操作都会与 SecurityManager 交互; 且它管理着所有 Subject;可以看出它是 Shiro 的核心，
 * 它负责与后边介绍的其他组件进行 交互，如果学习过 SpringMVC，你可以把它看成 DispatcherServlet 前端控制器;
 * subject（主体），代表当前的用户，与当前应用交互的任何东西
 * 所有Subject 都绑定 到 SecurityManager，与 Subject 的所有交互都会委托给 SecurityManager;
 * 可以把Subject认为是一个门面;SecurityManager 才是实际的执行者;
 * @author LiuXu
 * @time2018年9月15日下午2:33:36
 **/
public class ShiroTest {

	@Test
	public void tset1() {
		// 获取securityManagerFactory工厂
		IniSecurityManagerFactory factory = new IniSecurityManagerFactory("classpath:shiro.ini");
		// 得到SecurityManager实例，并绑定给securityUtils
		SecurityManager securityManager = factory.getInstance();
		SecurityUtils.setSecurityManager(securityManager);
		// 得到Subject及创建用户名/密码身份验证Token（即用户身份/凭证）
		Subject subject = SecurityUtils.getSubject();
		UsernamePasswordToken token = new UsernamePasswordToken("zhang", "123");
		try {
			// 登录，即身份验证
			subject.login(token);
		} catch (Exception e) {
			// 身份验证失败
		}
		// 断言用户已经登录
		Assert.assertEquals(true, subject.isAuthenticated());
		// 退出
		subject.logout();

	}

}
