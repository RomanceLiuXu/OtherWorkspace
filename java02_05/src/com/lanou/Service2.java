package com.lanou;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

/**
 *
 * @author LiuXu
 * @time2018年7月4日上午10:56:29
 **/
public class Service2 {

	public static void main(String[] args) {

		// 实例化
		try {
			DatagramSocket socket = new DatagramSocket(5555);
			// 接收客户端传来的数据
			// 1.实例化
			byte[] bytes = new byte[1024];
			// 2.实例化
			DatagramPacket dp = new DatagramPacket(bytes, bytes.length);
			// 3.读数据
			socket.receive(dp);
			// 4.实例化
			ByteArrayInputStream bis = new ByteArrayInputStream(bytes);

			// 实例化
			ObjectInputStream ois = new ObjectInputStream(bis);

			// 获取传来的对象
			Car car = (Car) ois.readObject();
			System.out.println(car);

			// 服务器端向客户端传送对象
			// 实例化对象
			Car car2 = new Car("小黑","大众");
			// 实例化
			ByteArrayOutputStream bos = new ByteArrayOutputStream();
			// 实例化
			ObjectOutputStream objOs = new ObjectOutputStream(bos);
			// 写入对象
			objOs.writeObject(car2);
			// 实例化
			DatagramPacket dp1 = new DatagramPacket(bos.toByteArray(), bos.toByteArray().length,
					InetAddress.getByName("127.0.0.1"), 6666);
			// 发送对象
			socket.send(dp1);

		} catch (SocketException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

	}

}
