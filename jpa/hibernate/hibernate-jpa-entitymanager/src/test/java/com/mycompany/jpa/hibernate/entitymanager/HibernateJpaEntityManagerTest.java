/**
 * 
 */
package com.mycompany.jpa.hibernate.entitymanager;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.Before;
import org.junit.Test;

/**
 * @author colin
 *
 */
public class HibernateJpaEntityManagerTest {

	EntityManagerFactory entityManagerFactory;
	
	@Before
	public void setup() {
		entityManagerFactory = Persistence.createEntityManagerFactory(
				"com.mycompany.jpa.hibernate.entitymanager");
	}
	
	@Test
	public void testGettingDataFromDatabaseUsingEntityManager() {
		
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		entityManager.getTransaction().begin();
		
		List<Stock> stocks = entityManager.createQuery("from Stock", Stock.class).getResultList();
		for(Stock stock : stocks) {
			System.out.println(stock.getStockCode() + "-" + stock.getStockName());
		}
		
		entityManager.getTransaction().commit();
		entityManager.close();
		
	}
	
	@Test
	public void testInsertDataIntoDatabaseUsingEntityManager() {
		
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		entityManager.getTransaction().begin();
		
		Stock stock = new Stock();
		stock.setStockCode("5678");
		stock.setStockName("Hibernate JPA");
		
		entityManager.persist(stock);
		
		entityManager.getTransaction().commit();
		entityManager.close();
		
	}
}
