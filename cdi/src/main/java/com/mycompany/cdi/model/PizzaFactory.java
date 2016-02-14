package com.mycompany.cdi.model;

import javax.enterprise.inject.Produces;

import com.mycompany.cdi.annotations.ChosenPizza;

public class PizzaFactory {

	@Produces
	@ChosenPizza
	public Pizza createPizza() {
		return new Pizza();
	}
}
