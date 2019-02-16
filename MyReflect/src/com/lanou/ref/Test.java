package com.lanou.ref;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * 反射
 * 
 * @author LiuXu
 * @time2018年7月25日下午2:23:15
 **/
public class Test {

	public static void main(String[] args)
			throws ClassNotFoundException, NoSuchMethodException, SecurityException, InstantiationException,
			IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchFieldException {
		// 第一种获取Class对象的方式:
		// 反射机制 Class对象
		// Person person = new Person();
		// person.setAge(10);
		// 获取Class对象 获取到Person类中定义的所有内容
		// Class<? extends Person> p1 = new Person().getClass();

		// 第二种获取Class对象的方式
		 Class p = Person.class;
		// if (p1==p) {
		// System.out.println("p1==p");/

		// 第三中方式获取Class对象
		Class<?> perClass = Class.forName("com.lanou.ref.Person");
		// 使用构造方法
		// Constructor con = perClass.getConstructor();//获取的无参的构造方法
		Constructor con = perClass.getConstructor(String.class);// 获取的有参的构造方法
		// Constructor con = perClass.getDeclaredConstructor(String.class);//获取所有声明的构造方法
		// 获取私有的有参的构造方法
		// 如果该方法是私有的，需要配置该信息，让可以使用私有的构造方法
		// con.setAccessible(true);
		// 创建了一个Person对象
//		 Person person = (Person) con.newInstance("liuxu");
		Object person = con.newInstance("liuxu");
		// 直接通过Class对象获取Person对象
		// Person person = (Person) perClass.newInstance();
		// person.setName("liuxu");
		// System.out.println(person.getName());

		// 获取某个方法并调用
		Method method1 = perClass.getMethod("setAge", int.class);// 有参的
		method1.invoke(person, 10);//调用方法
		Method method = perClass.getMethod("getName");// 无参的
		Method method2 = perClass.getDeclaredMethod("test");//私有的
		method2.setAccessible(true);// 忽略修饰符
		// 执行Person对象中的method方法
		Object name = method.invoke(person);
		method2.invoke(person);
		System.out.println(name);

		// 获取所有字段
		Field[] fields = perClass.getFields();
		perClass.getDeclaredFields();
		// 获取对应的字段
		Field name1 = perClass.getDeclaredField("name");
		// 给字段设置属性值
		name1.setAccessible(true);
		name1.set(person, "lala");
		//调用getName方法
		Object name2 = method.invoke(person);
		System.out.println(name1.get(person));
		// 获取公开的构造方法
		// Constructor<?>[] con = perClass.getConstructors();
		// 获取所有声明的构造方法
		// Constructor<?>[] con = perClass.getDeclaredConstructors();
		// for (Constructor<?> constructor : con) {
		// System.out.println(constructor);
		// }

		// 获取Person类中的所有公开方法(还有object的方法)
		// Method[] methods = p.getMethods();

		// 获取所有的声明的方法
		 Method[] methods = p.getDeclaredMethods();
		
		 for (Method methodd : methods) {
		 System.out.println(methodd);
		 }

	}

}
