/**
 * 
 */
package com.mycompany.jpa.hibernate.one_to_one;


import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import com.mycompany.jpa.hibernate.one_to_one.persistence.HibernateUtil;

/**
 * @author colin
 *
 */
public class HibernateOneToOneTest {

	static Session session;
	
	@BeforeClass
	public static void init() {
		session = HibernateUtil.getSessionFactory().openSession();
	}
	
	@AfterClass
	public static void destroy() {
		session.close();
		HibernateUtil.shutdown();
	}
	
	@Test
	public void testInsertUsingHibernate() {
		
		session.beginTransaction();
		
		Stock stock = new Stock();
		stock.setStockCode("7052");
		stock.setStockName("PADINI");
		
		StockDetail stockDetail = new StockDetail();
		stockDetail.setCompanyName("PADINI Holding Malaysia");
		stockDetail.setCompanyDescription("One stop shopping");
		stockDetail.setRemark("Vicci Vicci");
		stockDetail.setListedDate(new Date());
		
		stock.setStockDetail(stockDetail);
		stockDetail.setStock(stock);
		
		session.save(stock);
		
		session.getTransaction().commit();
		
	}
	
	@Test
	public void testRetreivingUsingHibernate() {
		
		Query query = session.createQuery("from Stock");
		
		@SuppressWarnings("unchecked")
		List<Stock> stocks = query.list();
		for(Stock stock : stocks ) {
			System.out.println(stock);
		}
		
	}
}
