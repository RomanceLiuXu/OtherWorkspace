package com.lanou;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 第四个服务端
 * 
 * @author LiuXu
 * @time2018年7月3日下午7:02:55
 **/
public class Service4 {

	public static void main(String[] args) {

//	     
			try {
//				获取对象
				ServerSocket ss = new ServerSocket(15000);
				System.out.println("服务端正在监听中...");
//				监听
				Socket sc = ss.accept();
//				获取对象
				ObjectInputStream objis = new ObjectInputStream(sc.getInputStream());
//				获取客户端传来的实体类对象
				Car car =  (Car) objis.readObject();
//				打印读取的结果
				System.out.println(car);
				
			} catch (IOException e) {
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
	}

}
