package com.mycompany.cdi.service.jdbc;

import javax.enterprise.inject.Default;
import javax.inject.Inject;

import com.mycompany.cdi.annotations.ChosenPizza;
import com.mycompany.cdi.model.Pizza;
import com.mycompany.cdi.repository.OrderRepository;
import com.mycompany.cdi.service.OrderService;

@Default
public class OrderServiceJdbc implements OrderService {

	@Inject
	private OrderRepository orderRepository;
	
	@Inject
	@ChosenPizza
	private Pizza pizza;
}
