package com.lanou.work;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

/**
 * 服务器端
 * 
 * @author LiuXu
 * @time2018年7月4日上午9:05:19
 **/
public class Service3 {

	public static void main(String[] args) {

		try {
			ServerSocket ss = new ServerSocket(10000);
			while (true) {
				System.out.println("服务器端监听中...");
				Socket sc = ss.accept();

				// 读数据
				BufferedReader br = new BufferedReader(new InputStreamReader(sc.getInputStream()));
				String con = br.readLine();
				//
				System.out.println("接收客户端发来的消息为:" + con);
				if (con.equals("bye")) {
//					写数据
					String sendCon = "bye";
					PrintWriter pw = new PrintWriter(new OutputStreamWriter(sc.getOutputStream()),true);
					pw.println(sendCon);
					sc.close();
					ss.close();
					break;
				}
				// 写数据
				Scanner scanner = new Scanner(System.in);
				System.out.println("服务器端--请输入:");
				String sendCon = scanner.next();
				PrintWriter pw = new PrintWriter(new OutputStreamWriter(sc.getOutputStream()), true);
				pw.println(sendCon);
				if (sendCon.equals("bye")) {
					break;
				}
			}

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
