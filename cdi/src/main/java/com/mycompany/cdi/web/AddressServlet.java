package com.mycompany.cdi.web;

import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.http.HttpServlet;

import com.mycompany.cdi.annotations.Jpa;
import com.mycompany.cdi.service.AddressService;

@Named("addressServlet")
public class AddressServlet extends HttpServlet {

	private static final long serialVersionUID = -7572534245890727639L;
	
	private AddressService addressService;
	
	@Inject
	public AddressServlet(@Jpa AddressService addressService) {
		this.addressService = addressService;
	}
}
