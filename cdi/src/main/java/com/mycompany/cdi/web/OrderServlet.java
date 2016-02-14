package com.mycompany.cdi.web;

import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.http.HttpServlet;

import com.mycompany.cdi.annotations.Jpa;
import com.mycompany.cdi.service.OrderService;

@Named("orderServlet")
public class OrderServlet extends HttpServlet {

	private static final long serialVersionUID = 8354905839598041198L;
	
	private OrderService orderService;
	
	@Inject
	public OrderServlet(@Jpa OrderService orderService) {
		this.orderService = orderService;
	}
}
