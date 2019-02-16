package com.lanou.properties;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.Set;

/**
 *
 * @author LiuXu
 * @time2018年8月16日下午2:03:55
 **/
public class MyProperties {

	public static void main(String[] args) throws IOException {
		// // 实例化Properties
		Properties p = new Properties();
		// p.put("张三", "123");
		// p.put("李四", "124");
		// Set<Object> set = p.keySet();
		// for (Object key : set) {
		// Object object = p.get(key);
		// System.out.println(key + ":" + object);
		// }

		// 实例化输入流对象
		InputStream in = new BufferedInputStream(new FileInputStream("src/my.properties"));
		p.load(in);
		for (Object o : p.keySet()) {
			System.out.println(o + ":" + p.get(o));
		}

		FileOutputStream out = new FileOutputStream("src/my.properties");

	}

}
