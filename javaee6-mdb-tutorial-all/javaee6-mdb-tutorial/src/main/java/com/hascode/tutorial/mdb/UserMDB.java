package com.hascode.tutorial.mdb;

import javax.ejb.MessageDriven;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.ObjectMessage;

@MessageDriven(mappedName = "jms/hascode/Queue")
public class UserMDB implements MessageListener {
	@Override
	public void onMessage(final Message message) {
		try {
			ObjectMessage objectMessage = (ObjectMessage) message;
			User user = (User) objectMessage.getObject();
			System.out.println("User received - name: " + user.getName());
		} catch (JMSException e) {
			e.printStackTrace();
		}
	}

}
