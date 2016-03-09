/**
 * 
 */
package com.mycompany.jpa.hibernate.criteria;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.CriteriaUpdate;
import javax.persistence.criteria.Root;

import org.hibernate.Criteria;
import org.junit.Before;
import org.junit.Test;

/**
 * @author colin
 *
 */
public class HibernateCriteriaTest {

	EntityManagerFactory entityManagerFactory;
	
	@Before
	public void setup() {
		entityManagerFactory = Persistence.createEntityManagerFactory(
				"com.mycompany.jpa.hibernate.entitymanager");
	}
	
	@Test
	public void testGetStockDailyRecordViaCriteria() {
		
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		entityManager.getTransaction().begin();
		
		// make the CriteriaBuilder & construct the Criteria object
		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder(); 
		CriteriaQuery<StockDailyRecord> criteria 
						= criteriaBuilder.createQuery(StockDailyRecord.class);
		
		// get the root object
		Root<StockDailyRecord> stockDailyRecordRoot = criteria.from(StockDailyRecord.class);
		
		// choose what to select
		criteria.select(stockDailyRecordRoot);
		
		
		List<StockDailyRecord> stockDailyRecords = entityManager.createQuery(criteria).getResultList();
		for(StockDailyRecord stockDailyRecord : stockDailyRecords) {
			System.out.println(stockDailyRecord);
		}
		
	}
}
