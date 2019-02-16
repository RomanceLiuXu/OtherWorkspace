package com.lanou;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.Scanner;

/**
 *
 * @author LiuXu
 * @time2018年7月4日上午11:38:32
 **/
public class Client3 {

	public static void main(String[] args) {
		try {
			DatagramSocket socket = new DatagramSocket(12345);
			Scanner scanner = new Scanner(System.in);
			while (true) {
				System.out.println("客户端--请输入:");
				String str = scanner.next();
				DatagramPacket dp = new DatagramPacket(str.getBytes(), str.getBytes().length,
						InetAddress.getByName("127.0.0.1"), 11111);
				socket.send(dp);

				// 接收消息
				byte[] bs = new byte[1024];
				// 2.实例化对象
				// bf:容器对应的字节数组
				// length:容器对应的字节数组的长度
				DatagramPacket dp1 = new DatagramPacket(bs, bs.length);
				// 3.接收消息
				socket.receive(dp1);
				// 将字节数组转化为字符串
				String res = new String(bs);
				// 打印
				System.out.println("接收到服务端发来的消息:" + res);
			}
		} catch (SocketException e) {

			e.printStackTrace();
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
