/**
 * 
 */
package com.mycompany.jpa.hibernate.one_to_many;


import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import com.mycompany.jpa.hibernate.one_to_many.persistence.HibernateUtil;

/**
 * @author colin
 *
 */
public class HibernateOneToManyTest {

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
