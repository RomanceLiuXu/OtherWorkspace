package com.lanou.liuxu;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

/**
 * 共同的服务器端
 * 
 * @author LiuXu
 * @time2018年7月4日下午2:13:13
 **/
public class ServiceCommon {
	public static void main(String[] args) {
		// 实例化
		try {
			DatagramSocket socket = new DatagramSocket(5555);
			getServiceT gt = new getServiceT();
			gt.socket = socket;
			gt.start();
		} catch (SocketException e) {
			e.printStackTrace();
		}

	}
}

/*
 * 执行接收和发送端的线程类
 */
class getServiceT extends Thread {

	DatagramSocket socket;// 获取对象--属性
	// 集合对象--用来存放ip和端口
	Map<String, Integer> maps = new HashMap<>();

	@Override
	public void run() {
		super.run();
		while (true) {
			// 接收数据
			// 一、1.字节数组对象
			byte[] bytes = new byte[1024];
			// 2.实例化
			DatagramPacket dp = new DatagramPacket(bytes, bytes.length);
			try {
				// 3.接收数据
				socket.receive(dp);
				// 4.获取发送消息的客户端的ip和端口
				String ip = dp.getAddress().getHostAddress();
				int port = dp.getPort();
				// 5.将ip和端口存放到集合中
				maps.put(ip, port);

				// 6.获取客户端传来的字符串
				String str = new String(bytes);
				System.out.println(ip + ":" + str);

				// 二、发消息(非自己)
				// 准备群发的数据
				String sendStr = ip + "--" + str;
				// 2.获取map集合中的实体对象
				Set<Entry<String, Integer>> enties = maps.entrySet();
				// 3.遍历
				Iterator<Entry<String, Integer>> iterator = enties.iterator();
				while (iterator.hasNext()) {
					// 获取具体的实例对象
					Entry<String, Integer> next = iterator.next();
					// 获取ip
					String ip1 = next.getKey();
					// 获取端口
					int port1 = next.getValue();
					// 7.判断ip排除发送消息本身的客户端
					if (!ip1.equals(dp.getAddress().getHostAddress())) {
						// 8.实例化
						DatagramPacket dp1 = new DatagramPacket(sendStr.getBytes(), sendStr.getBytes().length,
								InetAddress.getByName(ip1), port1);
						// 9.发送消息
						socket.send(dp1);

					}

				}

			} catch (IOException e) {
				e.printStackTrace();
			}

		}
	}
}