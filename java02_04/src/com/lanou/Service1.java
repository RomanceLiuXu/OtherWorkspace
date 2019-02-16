package com.lanou;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

/**
 * 第一个服务器
 * 
 * @author LiuXu
 * @time2018年7月3日上午11:34:15
 **/
public class Service1 {

	public static void main(String[] args) {

		try {
			// 1.实例化一个ServerSocket对象，并设置端口号
			ServerSocket ss = new ServerSocket(10000);
			// 打印
			System.out.println("服务器端启动,正在监听...");
			// 2.服务器端监听(监听谁访问了该端口)
			Socket sc = ss.accept();
			// 获取客户端发来的消息
			InputStream is = sc.getInputStream();
			InputStreamReader ir = new InputStreamReader(is);
			BufferedReader br = new BufferedReader(ir);
			// 读数据
			String str = "";
			String con = "";
			while ((str = br.readLine()) != null) {
				con += str;
			}
			// 打印
			System.out.println("客户端发来的消息:" + con);

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
