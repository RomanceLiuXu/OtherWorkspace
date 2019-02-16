package com.liuxu.fan;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 泛型
 * 
 * @author LiuXu
 * @time2018年6月28日下午3:57:41
 **/
public class Demo1 {
	/*
	 * 主函数
	 */
	public static void main(String[] args) {
		// 泛型的本质是参数化类型，也就是说所操作的数据类型被指定为一个参数。这种参数类型可以用在类，接口和方法的创建中
		// 好处
		// 1.类型安全
		// 2.消除强制类型转换
		// 3.提高性能
		// 4.提高代码的重用率
		
//		注意事项
//		1.泛型的类型参数只能是类类型（包括自定义类型），不能是简单类型
//		2.泛型的类型参数可以有多个
//		3.不能对确切的泛型类型使用instanceof操作
//		4.不能创建一个确切的泛型类型数组
		List<String> str = new ArrayList<>();

		// 泛型标示
		// T--type
		// E--element
		// K--key
		// V--value

		Test1<Integer> t1 = new Test1<>();
		Test1<cat> t2 = new Test1<>();

		// 实例化
		cat c = new cat();
		if (c instanceof cat) {

		}

		String[] strs = new String[4];

		cat[] cs = new cat[4];

		// getData(t2);
		getData(t1);
		
		Test1<cat> tt = new Test1();
		tt.method1(new cat());

	}

	// ? extends a:指定了上限，只能传入a和a的子类类型
	// ? super b:指定了下限，只能传b和b的父类类型
	public static void getData(Test1<? extends Number> s) {
		System.out.println("进入");
		// cat c = new cat("11",2);
		// s.setObj(c);
		// System.out.println(s.getObj().getName());

	}

}

class Test1<T> {
	private T obj;

	public Test1(T obj) {
		super();
		this.obj = obj;
	}

	public Test1() {
		super();
	}

	public void method1(T obj) {
		// 获取class对象
		Class objc = obj.getClass();
		// 获取类中所有的方法
		Method[] ms = objc.getDeclaredMethods();
		// 遍历
		for (Method method : ms) {
			System.out.println(method);
		}

	}

	public T getObj() {
		return obj;
	}

	public void setObj(T obj) {
		this.obj = obj;
	}

}

class cat {
	private String name;
	private int age;

	public cat() {
		super();
	}

	public cat(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

}
