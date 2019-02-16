package com.lanou;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.MessageConsumer;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;

import com.mysql.jdbc.log.Log;

/**
 * 消息消费者
 * 
 * @author wx
 * @time 2018年8月20日下午9:56:11
 **/
public class JMSConsumer {
	// 默认链接用户名
	private static final String USERNAME = ActiveMQConnection.DEFAULT_USER;
	// 默认链接密码
	private static final String PASSWORD = ActiveMQConnection.DEFAULT_PASSWORD;
	// 默认链接地址
	 private static final String BROKEURL = ActiveMQConnection.DEFAULT_BROKER_URL;

	public static void main(String[] args) {
		// 链接工厂
		ConnectionFactory connectionFactory;
		// 链接
		Connection connection = null;
		// 会话 接受或者发送消息的线程
		Session session;
		// 消息的目的地
		Destination destination;
		// 消息消费者
		MessageConsumer messageConsumer;
		// 实例化链接工厂
		connectionFactory = new ActiveMQConnectionFactory(JMSConsumer.USERNAME, JMSConsumer.PASSWORD,"tcp://192.168.20.178:61616");
		try {
			// 通过工厂获取链接
			connection = connectionFactory.createConnection();
			// 启动链接
			connection.start();
			session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
			// 创建一个消息队列
			destination = session.createTopic("myTopic");
			// 创建消息消费者
			messageConsumer = session.createConsumer(destination);
			while (true) {
				TextMessage textMessage = (TextMessage) messageConsumer.receive();
				if (textMessage != null) {
					System.out.println("收到的消息：" + textMessage.getText());
				} else {
					break;
				}
			}

		} catch (JMSException e) {
			e.printStackTrace();
		}

	}
}
