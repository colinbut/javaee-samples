package com.mycompany.cdi.service.jdbc;

import javax.enterprise.inject.Default;
import javax.inject.Inject;

import com.mycompany.cdi.repository.CustomerRepository;
import com.mycompany.cdi.service.CustomerService;

@Default
public class CustomerServiceJdbc implements CustomerService {

	@Inject
	private CustomerRepository customerRepository;
}
