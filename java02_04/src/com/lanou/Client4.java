package com.lanou;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * 第四个客户端
 * 
 * @author LiuXu
 * @time2018年7月3日下午7:03:09
 **/
public class Client4 {
	public static void main(String[] args) {
		try {
			// 获取对象
			Socket sc = new Socket("127.0.0.1", 15000);
			// 实例化
			ObjectOutputStream objOs = new ObjectOutputStream(sc.getOutputStream());
			// 准备对象
			Car car = new Car("小白", "奔驰");
			// 写数据(对象)
			objOs.writeObject(car);
			// 关闭输出流
			sc.shutdownInput();
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
