package com.lanou.aspect;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.aopalliance.intercept.Joinpoint;
import org.aspectj.apache.bcel.generic.NEW;
import org.aspectj.lang.ProceedingJoinPoint;

/**
 * 提取的切面类
 * 
 * @author LiuXu
 * @time2018年8月23日下午4:20:19
 **/
public class EmpAspect {

	public void beginTransaction() {
		System.out.println("--前置通知,开启事务--");
	}

	public void commitTransaction() {
		System.out.println("--后置通知，提交事务--");
	}

	/**
	 * 异常通知 处理目标方法抛出的异常
	 * 
	 * @param ex:代表目标方法抛出的异常
	 * @throws FileNotFoundException
	 */
	public void handleException(Exception ex) throws FileNotFoundException {
		PrintWriter out = null;
		if (ex instanceof NullPointerException) {
			out = new PrintWriter("/Users/xalo/Desktop/ex1.txt");
			System.out.println("空指针异常");
		} else if (ex instanceof ArrayIndexOutOfBoundsException) {
			out = new PrintWriter("/Users/xalo/Desktop/ex2.txt");
			System.out.println("数组下标异常");
		}else {
			out = new PrintWriter("/Users/xalo/Desktop/ex3.txt");
			System.out.println(ex);
		}
		SimpleDateFormat saf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		out.println("异常产生时间:" + saf.format(new Date()));
		out.println("异常类型:" + ex.getClass().getName());
		out.println("--异常详情--");
		ex.printStackTrace(out);
		out.close();
	}
	
	/**
	 * 最终通知
	 */
	public void closeConnection(){
		System.out.println("-最终通知-");
		
	}
	
	/**
	 * 
	 * @param joinpoint  连接点，连接到目标方法
	 * @throws Throwable
	 */
	public Object aroundAspect(ProceedingJoinPoint joinpoint) throws Throwable{
		System.out.println("----环绕方法执行之前----");
//		通过连接点调用目标方法
		Object obj = joinpoint.proceed();
		System.out.println("----环绕方法执行之后----");
		return obj;
	}

}
