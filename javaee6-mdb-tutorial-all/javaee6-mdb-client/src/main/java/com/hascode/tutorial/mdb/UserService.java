package com.hascode.tutorial.mdb;

import javax.annotation.Resource;
import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.ObjectMessage;
import javax.jms.Queue;
import javax.jms.Session;

public class UserService {
	@Resource(lookup = "jms/hascode/ConnectionFactory")
	private static ConnectionFactory	connectionFactory;

	@Resource(lookup = "jms/hascode/Queue")
	private static Queue				queue;

	public static void main(String[] args) {
		User user = new User();
		user.setName("Mickey");
		try {
			Connection conn = connectionFactory.createConnection();
			Session session = conn.createSession(false, Session.AUTO_ACKNOWLEDGE);
			MessageProducer producer = session.createProducer(queue);
			ObjectMessage msg = session.createObjectMessage();
			msg.setObject(user);
			producer.send(msg);
			conn.close();
		} catch (JMSException e) {
			e.printStackTrace();
		}
	}
}
