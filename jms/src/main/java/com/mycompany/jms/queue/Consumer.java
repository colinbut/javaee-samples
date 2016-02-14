/*
 * |-------------------------------------------------
 * | Copyright © 2015 Colin But. All rights reserved. 
 * |-------------------------------------------------
 */
package com.mycompany.jms.queue;

import javax.jms.JMSConsumer;
import javax.jms.JMSContext;
import javax.jms.JMSException;
import javax.jms.Queue;
import javax.jms.QueueConnection;
import javax.jms.QueueConnectionFactory;
import javax.jms.QueueReceiver;
import javax.jms.QueueSession;
import javax.jms.Session;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import com.mycompany.jms.listener.Listener;

/**
 * {@link Consumer}
 * 
 * @author colin
 *
 */
public class Consumer {

	/**
	 * Consumes a message from the JMS queue
	 * 
	 * uses JMS 2.0 features
	 */
	public static void consumeV2() {
		try{
			InitialContext initialContext = new InitialContext();
			
			QueueConnectionFactory queueConnectionFactory = (QueueConnectionFactory) 
														initialContext.lookup("myQueueConnectionFactory");
			Queue queue = (Queue) initialContext.lookup("myQueue");
			
			JMSContext jmsContext = queueConnectionFactory.createContext();
			
			JMSConsumer jmsConsumer = jmsContext.createConsumer(queue);
			System.out.println(jmsConsumer.receiveBody(String.class));
			
			
		} catch(NamingException e) {
			e.printStackTrace();
		}
		
	}
	
	/**
	 * JMS 1.0 version of consuming a message that is sent to
	 * 
	 * use {@link Consumer#consumeV2()} method instead
	 */
	@Deprecated
	public static void consume() {
		
		try {
			InitialContext initialContext = new InitialContext();
			
			QueueConnectionFactory queueConnectionFactory = (QueueConnectionFactory) 
														initialContext.lookup("myQueueConnectionFactory");
			QueueConnection queueConnection = queueConnectionFactory.createQueueConnection();
			queueConnection.start();
			
			QueueSession queueSession = queueConnection.createQueueSession(false, Session.AUTO_ACKNOWLEDGE);
			
			Queue queue = (Queue) initialContext.lookup("myQueue");
			
			QueueReceiver queueReceiver = queueSession.createReceiver(queue);
			
			queueReceiver.setMessageListener(new Listener());
			
		} catch (NamingException e) {
			e.printStackTrace();
		} catch (JMSException e) {
			e.printStackTrace();
		}
		
	}

}
