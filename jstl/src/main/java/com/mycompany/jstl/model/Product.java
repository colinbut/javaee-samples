/*
 * |-------------------------------------------------
 * | Copyright © 2015 Colin But. All rights reserved. 
 * |-------------------------------------------------
 */
package com.mycompany.jstl.model;

import java.math.BigDecimal;

/**
 * {@link Product}
 * 
 * @author colin
 *
 */
public class Product {

	private String name;
	private String description;
	private BigDecimal price;
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Product [name=" + name + ", description=" + description
				+ ", price=" + price + "]";
	}
	
}
