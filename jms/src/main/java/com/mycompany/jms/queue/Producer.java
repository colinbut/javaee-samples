/*
 * |-------------------------------------------------
 * | Copyright © 2015 Colin But. All rights reserved. 
 * |-------------------------------------------------
 */
package com.mycompany.jms.queue;

import javax.jms.*;
import javax.naming.InitialContext;
import javax.naming.NamingException;

/**
 * Producer 
 * 
 * @author colin
 *
 */
public class Producer {
	
	/**
	 * Produces messages and sends them to the 'queue'
	 * 
	 * uses JMS 2.0 code features		
	 */
	public static void produceV2() {
		
		
		try {
			InitialContext initialContext = new InitialContext();
			
			QueueConnectionFactory queueConnectionFactory = (QueueConnectionFactory) initialContext
					.lookup("myQueueConnectionFactory");
			
			JMSContext jmsContext = queueConnectionFactory.createContext();
			
			Queue queue = (Queue) initialContext.lookup("myQueue");
			
			jmsContext.createProducer().send(queue, "Sending message via JMS queue using JMS 2.0");
			
			
		} catch (NamingException e) {
			e.printStackTrace();
		}
		
	}
	
	/**
	 * JMS 1.0 version of sending messages to JMS queue
	 * 
	 * use {@link #produceV2()} method instead
	 */
	@Deprecated
	public static void produce() {
		
		try {
			// create & start connection
			InitialContext initialContext = new InitialContext();
			
			QueueConnectionFactory queueConnectionFactory = (QueueConnectionFactory) initialContext
																	.lookup("myQueueConnectionFactory");
			QueueConnection queueConnection = queueConnectionFactory.createQueueConnection();
			queueConnection.start();
			
			// create queue session
			QueueSession queueSession = queueConnection.createQueueSession(false, Session.AUTO_ACKNOWLEDGE);
			
			// get the queue object
			Queue queue = (Queue) initialContext.lookup("myQueue");
			
			// create queue sender object
			QueueSender queueSender = queueSession.createSender(queue);
			
			// create the text message object to hold the message to send
			TextMessage message = queueSession.createTextMessage();
			
			// write the message and send it
			message.setText("Hello World - JMS Example");
			queueSender.send(message);
			
			// close the connection
			queueConnection.close();
			
			
		} catch (NamingException e) {
			e.printStackTrace();
		} catch (JMSException e) {
			e.printStackTrace();
		}
		
		
	}

}
