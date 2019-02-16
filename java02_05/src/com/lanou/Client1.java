package com.lanou;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

/**
 * 客户端
 * 
 * @author LiuXu
 * @time2018年7月4日上午9:59:16
 **/
public class Client1 {

	public static void main(String[] args) {
		// 1.实例化一个对象,给客户端开一个端口
		try {
			DatagramSocket socket = new DatagramSocket(10000);
			// 2.准备数据
			String str = "hello";
			// 3.实例化
			// 参数:
			// 1.buf:发送数据对应的字节数组
			// 2.length:发送数据对应的字节数组的长度
			// 3.address:发送的目标ip地址
			// 4.port:端口号
			DatagramPacket dp = new DatagramPacket(str.getBytes(), str.getBytes().length,
					InetAddress.getByName("192.168.10.5"), 5555);
			// 4.发送消息
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

		} catch (SocketException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
