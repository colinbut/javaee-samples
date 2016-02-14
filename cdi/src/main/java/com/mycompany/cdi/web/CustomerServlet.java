package com.mycompany.cdi.web;

import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.http.HttpServlet;

import com.mycompany.cdi.annotations.Jpa;
import com.mycompany.cdi.service.CustomerService;

@Named("customerServlet")
public class CustomerServlet extends HttpServlet {

	private static final long serialVersionUID = 3607908647581421772L;
	
	private CustomerService customerService;
	
	@Inject
	public void setCustomerService(@Jpa CustomerService customerService) {
		this.customerService = customerService;
	}
	

}
