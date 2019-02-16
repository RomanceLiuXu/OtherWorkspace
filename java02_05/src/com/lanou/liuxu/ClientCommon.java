package com.lanou.liuxu;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.Scanner;

/**
 * 客户端
 * 
 * @author LiuXu
 * @time2018年7月4日下午2:51:51
 **/
public class ClientCommon {
	public static void main(String[] args) {
		try {
			// 实例化
			DatagramSocket socket = new DatagramSocket(7894);
			Send send = new Send();
			send.socket = socket;
			send.start();
			Receive receive = new Receive();
			receive.socket = socket;
			receive.start();

		} catch (SocketException e) {
			e.printStackTrace();
		}

	}

}

/**
 * 发送消息
 * 
 * @author xalo
 *
 */
class Send extends Thread {
	DatagramSocket socket;// 获取对象

	@Override
	public void run() {
		super.run();
		while (true) {
			// 准备发送的数据
			System.out.println("客户端--请输入数据:");
			Scanner scanner = new Scanner(System.in);// 获取对象
			String str = scanner.next();
			// 获取对象
			try {
				DatagramPacket dp = new DatagramPacket(str.getBytes(), str.getBytes().length,
						InetAddress.getByName("192.168.20.44"), 5656);
				socket.send(dp);
			} catch (UnknownHostException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}

class Receive extends Thread {

	DatagramSocket socket;// 获取对象
	// 接收数据

	@Override
	public void run() {
		super.run();
		while (true) {
			// 接收消息
			byte[] bs = new byte[1024];
			// 2.实例化对象
			// bf:容器对应的字节数组
			// length:容器对应的字节数组的长度
			DatagramPacket dp1 = new DatagramPacket(bs, bs.length);
			// 3.接收消息
			try {
				socket.receive(dp1);
				// 将字节数组转化为字符串
				String res = new String(bs);
				// 打印
				System.out.println("接收到服务端发来的消息:" + res);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}