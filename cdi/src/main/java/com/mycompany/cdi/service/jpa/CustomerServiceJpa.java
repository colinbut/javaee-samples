package com.mycompany.cdi.service.jpa;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import com.mycompany.cdi.annotations.Jpa;
import com.mycompany.cdi.service.CustomerService;

@Jpa
public class CustomerServiceJpa implements CustomerService {

	@PostConstruct
	public void init() {
		
	}
	
	@PreDestroy
	public void destroy() {
		
	}
	
}
