/*
 * |-------------------------------------------------
 * | Copyright © 2015 Colin But. All rights reserved. 
 * |-------------------------------------------------
 */
package com.mycompany.jms;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mycompany.jms.queue.Consumer;
import com.mycompany.jms.queue.Producer;

/**
 * A simple servlet to control access to JMS features
 * 
 * @author colin
 *
 */
@WebServlet("/jms-execute")
public class JmsServlet extends HttpServlet {

	private static final long serialVersionUID = 4154064067582921024L;
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) {
		
		String action = request.getParameter("action");
		
		if(action.equals("produce")) {
			Producer.produceV2();
		} else if(action.equals("consume")) {
			Consumer.consumeV2();
		}
		
	}
}
