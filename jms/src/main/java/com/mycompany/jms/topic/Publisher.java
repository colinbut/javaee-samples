/*
 * |-------------------------------------------------
 * | Copyright © 2015 Colin But. All rights reserved. 
 * |-------------------------------------------------
 */
package com.mycompany.jms.topic;

import javax.jms.JMSException;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.jms.Topic;
import javax.jms.TopicConnection;
import javax.jms.TopicConnectionFactory;
import javax.jms.TopicPublisher;
import javax.jms.TopicSession;
import javax.naming.InitialContext;
import javax.naming.NamingException;

/**
 * Publisher 
 * 
 * @author colin
 *
 */
public class Publisher {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		try {
			InitialContext context = new InitialContext();
			
			TopicConnectionFactory topicConnectionFactory = (TopicConnectionFactory) context.lookup("topicConnectionFactory");
			TopicConnection topicConnection = topicConnectionFactory.createTopicConnection();
			topicConnection.start();
			
			TopicSession topicSession = topicConnection.createTopicSession(false, Session.AUTO_ACKNOWLEDGE);
			
			Topic topic = (Topic) context.lookup("topic");
			
			TopicPublisher topicPublisher = topicSession.createPublisher(topic);
			
			TextMessage textMessage = topicSession.createTextMessage("Topic - JMS Example");
			
			topicPublisher.publish(textMessage);
			
			topicConnection.close();
			topicPublisher.close();
			
		} catch (NamingException | JMSException e) {
			e.printStackTrace();
		}
		
	}

}
