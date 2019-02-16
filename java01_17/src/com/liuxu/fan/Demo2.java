package com.liuxu.fan;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
* 反射
* @author LiuXu
* @time2018年6月28日下午4:41:25
**/
public class Demo2 {

	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
//		反射(反编译): .java文件--->.class文件
		
//	获取class对象方式一
	 student s = new student();
	 Class stuc = s.getClass();
	 System.out.println(stuc);
//	 方式二
	Class stuc1 = Class.forName("com.liuxu.fan.student");
	 System.out.println(stuc1);
		
//	 获取更多的信息
	 Constructor[]   cs = stuc.getConstructors();//不能获取到private修饰的构造方法
	 System.out.println(cs.length);
	 System.out.println(stuc.getDeclaredConstructors().length);//可以获取到private修饰的构造方法
	 
//	 获得student对象
	student ss = (student) cs[0].newInstance();
	ss.setName("hah");
	System.out.println("反射后:"+ss.getName());
//	获取所有的方法
	Method[] ms = stuc.getDeclaredMethods();
//	遍历
	for (Method method : ms) {
		System.out.println(method);
	}
	 
	 student student = (student)ms[2].invoke(stuc.newInstance());
	
	}
	
	
}
class student{
	private String name;

	public student() {
		super();
	}

	public student(String name) {
		super();
		this.name = name;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
    
}