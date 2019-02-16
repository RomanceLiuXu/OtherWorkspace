package com.liuxu.Aspect;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.aopalliance.intercept.Joinpoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * 切面类
 * 
 * @author LiuXu
 * @time2018年8月23日下午8:40:25
 **/
@Component
@Aspect
public class AopAspect {

	@Pointcut("execution(* com.liuxu.action.EmpAction.showAll(..))")
	public void cut(){
		
	}
	
	@Before(value="cut()")
	public void MyBefore(Joinpoint joinpoint) {
		System.out.println("前置方法执行");
	}

	@AfterReturning(value="cut()")
	public void MyAfter() {
		System.out.println("后置方法执行");
	}

	@AfterThrowing(value="cut",throwing="e")
	public void MyExpection(Exception e) throws FileNotFoundException {
		PrintWriter out = null;
		if (e instanceof NullPointerException) {
			out = new PrintWriter("/Users/xalo/Desktop/ex1.txt");
		} else if (e instanceof ArrayIndexOutOfBoundsException) {
			out = new PrintWriter("/Users/xalo/Desktop/ex2.txt");
		} else {
			out = new PrintWriter("/Users/xalo/Desktop/ex3.txt");
		}
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        out.println("异常产生时间:"+sdf.format(new Date()));
        out.println("异常类型:"+e.getClass().getName());
        e.printStackTrace(out);
        out.close();
	}

	/**
	 * 环绕通知
	 * @param joinPoint
	 */
	@Around(value="cut()")
	public void MyAround(ProceedingJoinPoint joinPoint){
		System.out.println("环绕方法执行之前");
		try {
			joinPoint.proceed();
		} catch (Throwable e) {
		
			e.printStackTrace();
		}
		System.out.println("环绕方法执行之后");
	}
	
	
	
}
