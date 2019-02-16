package com.lanou;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.util.Scanner;

/**
 * UDP-服务器端
 * 
 * @author LiuXu
 * @time2018年7月4日上午9:59:04
 **/
public class Service1 {

	public static void main(String[] args) {
		try {
			// 实例化对象，给服务器端开一个端口
			DatagramSocket socket = new DatagramSocket(12345);
			// 接收客户端发来的消息
			// 1.创建容器(字节数组)
			byte[] bs = new byte[1024];
			// 2.实例化对象
			// bf:容器对应的字节数组
			// length:容器对应的字节数组的长度
			DatagramPacket dp = new DatagramPacket(bs, bs.length);
			// 3.接收消息
			socket.receive(dp);
			// 将字节数组转化为字符串
			String res = new String(bs);
			// 打印
			System.out.println("接收到客户端发来的消息:" + res);
			
			
//			给客户端回消息
			String str ="收到了";
			DatagramPacket dp1 = new DatagramPacket(str.getBytes(), str.getBytes().length, InetAddress.getByName("127.0.0.1"), 10000);
            socket.send(dp1);
			
		} catch (SocketException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
