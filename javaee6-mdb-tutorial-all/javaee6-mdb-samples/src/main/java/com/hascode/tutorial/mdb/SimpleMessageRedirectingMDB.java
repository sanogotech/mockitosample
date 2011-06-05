package com.hascode.tutorial.mdb;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;
import javax.ejb.MessageDriven;
import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.jms.TextMessage;

@MessageDriven(mappedName = "jms/hascode/Queue")
public class SimpleMessageRedirectingMDB implements MessageListener {
	@Resource(name = "jms/hascode/ConnectionFactory")
	private ConnectionFactory	connectionFactory;
	private Connection			connection;

	@Resource(name = "jms/hascode/EnrichedMessageQueue")
	private Destination			targetQueue;

	@PostConstruct
	private void initJMS() throws JMSException {
		connection = connectionFactory.createConnection();
	}

	@PreDestroy
	private void closeJMS() throws JMSException {
		connection.close();
	}

	@Override
	public void onMessage(final Message message) {
		try {
			TextMessage textMessage = (TextMessage) message;
			System.out.println("New message received: " + textMessage.getText());
			enrichAndPublish(textMessage);
		} catch (JMSException e) {
			e.printStackTrace();
		}
	}

	private void enrichAndPublish(final TextMessage textMessage) throws JMSException {
		final Session session = connection.createSession(true, Session.AUTO_ACKNOWLEDGE);
		final MessageProducer producer = session.createProducer(targetQueue);
		final TextMessage msg = session.createTextMessage();
		msg.setText(textMessage.getText() + " I was enriched ;)");
		producer.send(msg);
		session.close();
	}
}
