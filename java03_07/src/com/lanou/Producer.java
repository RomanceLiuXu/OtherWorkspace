package com.lanou;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;

/**
 *
 * @author LiuXu
 * @time2018年8月22日下午2:15:22
 **/
public class Producer {

	// 默认连接用户名
	private static final String USERNAME = ActiveMQConnection.DEFAULT_USER;
	// 默认连接密码
	private static final String PASSWORD = ActiveMQConnection.DEFAULT_PASSWORD;
	// 默认的连接地址
	private static final String BROKERURL = ActiveMQConnection.DEFAULT_BROKER_URL;

	public static void main(String[] args) {
		// 定义连接工厂
		ConnectionFactory connectionFactory;
		// 实例化连接对象
		Connection connection = null;
		// 实例化session对象,传递消息线程
		Session session;
		// 定义消息目的地
		Destination destination;
		// 定义一个消息发送者
		MessageProducer messageProducer;
		// 实例化连接工厂
		connectionFactory = new ActiveMQConnectionFactory(USERNAME, PASSWORD, BROKERURL);

		try {
			// 通过工厂获取连接
			connection = connectionFactory.createConnection();
			// 启动连接
			connection.start();
			// 创建session
			session = connection.createSession(true, Session.AUTO_ACKNOWLEDGE);
			// 创建一个消息队列
			destination = session.createTopic("myTopic");
			// 创建消息生产者
			messageProducer = session.createProducer(destination);
			// 调用发消息的方法
			sendMessage(session, messageProducer);
			session.commit();
		} catch (JMSException e) {

			e.printStackTrace();
		}finally {
			if (connection!=null) {
				try {
					connection.close();
				} catch (JMSException e) {
					e.printStackTrace();
				}
			}
		}

	}

	/**
	 * 发送消息的方法
	 * 
	 * @param session
	 * @param messageProducer
	 */
	public static void sendMessage(Session session, MessageProducer messageProducer) {
		try {
			while (true) {
				
				TextMessage message = session.createTextMessage("这是我发送的第一个消息");
				messageProducer.send(message);
				System.out.println("发送的消息为:" + message);
			}
		} catch (JMSException e) {

			e.printStackTrace();
		}
	}

}
