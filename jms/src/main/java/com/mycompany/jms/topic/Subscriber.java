/*
 * |-------------------------------------------------
 * | Copyright © 2015 Colin But. All rights reserved. 
 * |-------------------------------------------------
 */
package com.mycompany.jms.topic;

import javax.jms.JMSException;
import javax.jms.Session;
import javax.jms.Topic;
import javax.jms.TopicConnection;
import javax.jms.TopicConnectionFactory;
import javax.jms.TopicSession;
import javax.jms.TopicSubscriber;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import com.mycompany.jms.listener.Listener;

/**
 * Subscriber
 * 
 * @author colin
 *
 */
public class Subscriber {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		try {
			InitialContext context = new InitialContext();
			
			TopicConnectionFactory topicConnectionFactory = (TopicConnectionFactory) context.lookup("topicConnectionFactory");
			TopicConnection topicConnection = topicConnectionFactory.createTopicConnection();
			topicConnection.start();
			
			TopicSession session = topicConnection.createTopicSession(false, Session.AUTO_ACKNOWLEDGE);
			
			Topic topic = (Topic) context.lookup("topic");
			
			TopicSubscriber subscriber = session.createSubscriber(topic);
			subscriber.setMessageListener(new Listener());
			
		} catch (NamingException | JMSException e) {
			e.printStackTrace();
		}
	}

}
