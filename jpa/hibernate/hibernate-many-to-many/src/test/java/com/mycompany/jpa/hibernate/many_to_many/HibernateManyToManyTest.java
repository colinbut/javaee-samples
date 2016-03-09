/**
 * 
 */
package com.mycompany.jpa.hibernate.many_to_many;


import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.Query;
import org.hibernate.Session;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import com.mycompany.jpa.hibernate.many_to_many.persistence.HibernateUtil;

/**
 * @author colin
 *
 */
public class HibernateManyToManyTest {

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
		stock.setStockCode("9999");
		stock.setStockName("Oracle");
		
		Category category1 = new Category();
		category1.setName("Consumer");
		category1.setDescription("Consumer company");
		Category category2 = new Category();
		category2.setName("Producer");
		category2.setDescription("Producer company");
		
		Set<Category> categories = new HashSet<Category>();
		categories.add(category1);
		categories.add(category2);
		
		stock.setCategories(categories);
		
		
		StockDetail stockDetail = new StockDetail();
		stockDetail.setCompanyName("Oracle Coorporations");
		stockDetail.setCompanyDescription("Oracle ????");
		stockDetail.setRemark("The Sun");
		stockDetail.setListedDate(new Date());
		
		stock.setStockDetail(stockDetail);
		stockDetail.setStock(stock);
		
		session.save(stock);
		
		StockDailyRecord stockDailyRecord = new StockDailyRecord();
		stockDailyRecord.setPriceOpen(1.2f);
		stockDailyRecord.setPriceClose(1.1f);
		stockDailyRecord.setPriceChange(10.0f);
		stockDailyRecord.setVolume(300000L);
		stockDailyRecord.setDate(new Date());
		
		stockDailyRecord.setStock(stock);
		stock.getStockDailyRecords().add(stockDailyRecord);
		
		session.save(stockDailyRecord);
		
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
