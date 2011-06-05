package com.hascode.tutorial.mdb;

import javax.ejb.MessageDriven;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

@MessageDriven(mappedName = "jms/hascode/Queue")
public class SimpleMessageMDB implements MessageListener {

	@Override
	public void onMessage(final Message message) {
		try {
			TextMessage textMessage = (TextMessage) message;
			System.out.println("New message received: " + textMessage.getText());
		} catch (JMSException e) {
			e.printStackTrace();
		}
	}

}
