/*
 * |-------------------------------------------------
 * | Copyright © 2015 Colin But. All rights reserved. 
 * |-------------------------------------------------
 */
package com.mycompany.jpa.hibernate;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.Before;
import org.junit.Test;

import com.mycompany.jpa.hibernate.entities.Customer;
import com.mycompany.jpa.hibernate.entities.Order;

/**
 * Ad-hoc test class to test basic JPA Hibernate entity relationships features
 * 
 * @author colin
 *
 */
public class JpaHibernateTest {

	private EntityManagerFactory entityManagerFactory;
	
	@Before
	public void setup() {
		entityManagerFactory = Persistence.createEntityManagerFactory("com.mycompany.jpa.hibernate.entitymanager");
	}
	
	@Test
	public void testRetrievingDataFromDB() {
		
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		entityManager.getTransaction().begin();
		
		List<Customer> customers = entityManager.createQuery("from Customer", Customer.class)
											.getResultList();
		
		for(Customer customer : customers) {
			System.out.println(customer);
		}
		
		List<Order> orders = entityManager.createQuery("from Order", Order.class).getResultList();
		for(Order order : orders) {
			System.out.println(order);
		}
		
		entityManager.getTransaction().commit();
		entityManager.close();
		
	}
}
