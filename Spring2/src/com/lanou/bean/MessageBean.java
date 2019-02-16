package com.lanou.bean;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 *
 * @author LiuXu
 * @time2018年8月22日下午4:40:19
 **/

/**
 * 相当于在spring容器中配置
 * <bean id="messageBean" class="com.lanou.bean.MessageBean"></bean>
 * 默认id为类名首字母小写，也可以自己指定id
 */
@Component("msg") // 指定bean组件的id为msg
@Scope("singleton")//默认是singleton单例
@Lazy(true)//注解的默认值是true，执行延迟实例化
public class MessageBean {

	public MessageBean() {
		System.out.println("--构造器--");
	}

	/**
	 * 初始化的方法
	 */
	@PostConstruct
	public void init() {
		System.out.println("-int方法-");
	}

	/**
	 * 销毁的方法（单例，容器关闭）
	 */
	@PreDestroy
	public void destroy() {
		System.out.println("-destroy方法-");
	}

}
