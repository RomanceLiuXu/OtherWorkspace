package com.lanou.work;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

/**
 *
 * @author LiuXu
 * @time2018年7月4日上午9:05:39
 **/
public class Cilent3 {

	public static void main(String[] args) {

		try {
			while (true) {
				Socket sc = new Socket("127.0.0.1", 10000);
				// 发送数据
				Scanner scanner = new Scanner(System.in);
				System.out.println("客户端--请输入发送的内容:");
				String sendSer = scanner.next();
				PrintWriter pw = new PrintWriter(new OutputStreamWriter(sc.getOutputStream()), true);
				pw.println(sendSer);

				// 接收数据
				BufferedReader br = new BufferedReader(new InputStreamReader(sc.getInputStream()));
				String res = br.readLine();
				System.out.println("接收到服务发来的消息为:" + res);
				if (res.equals("bye")) {
					break;
				}

			}
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
