package com.liuxu;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.Factory;

/**
 *
 * @author LiuXu
 * @time2018年8月20日下午2:19:56
 **/
public class TestShiro1 {

	public void test() {
		Factory<SecurityManager> factory = new IniSecurityManagerFactory("shiro-realm.ini");
		SecurityManager sm = factory.getInstance();
		SecurityUtils.setSecurityManager(sm);
		Subject subject = SecurityUtils.getSubject();
		UsernamePasswordToken token = new UsernamePasswordToken("abcd1234", "1234");
		try {
			// 无返回值，登录失败会抛异常
			subject.login(token);
			System.out.println("登录成功");
		} catch (Exception e) {

		}
	}

}
