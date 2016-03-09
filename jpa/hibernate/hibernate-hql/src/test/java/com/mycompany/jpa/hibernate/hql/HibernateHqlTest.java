/**
 * 
 */
package com.mycompany.jpa.hibernate.hql;


import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import com.mycompany.jpa.hibernate.hql.persistence.HibernateUtil;


/**
 * Testing using HQL to do CRUD operations:
 * 
 * - Create (Insert)
 * - Read   (Select)
 * - Update (Update)
 * - Delete (Delete)
 * 
 * @author colin
 *
 */
public class HibernateHqlTest {

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
	
	/**
	 * HQL supports select into select ONLY
	 */
	@Test
	public void test_InsertQuery() {
		
		Query query = session.createQuery("insert into Stock(stock_code, stock_name" +
						"select stock_code, stock_name from backup_stock");
		
		int result = query.executeUpdate();
		
	}
	
	@Test
	public void test_SelectQuery() {
		
		//Query query = session.createQuery("from Stock where stockCode = :code");
		Query query = session.createQuery("from Stock where stockCode = '9999'");
		//query.setParameter("code", "7052");
		List<Stock> stocks = query.list();
		
		for(Stock stock : stocks) {
			System.out.println(stock);
		}
	}
	
	@Test
	public void test_UpdateQuery() {
		
		Query query = session.createQuery("update Stock set stockName = :stockName" + 
							" where stockCode = :stockCode");
		query.setParameter("stockName", "Testing");
		query.setParameter("stockCode", "1234");
		
		int result = query.executeUpdate();
	}
	
	@Test
	public void test_DeleteQuery() {
		
		Query query = session.createQuery("delete Stock where stockCode = :stockCode");
		query.setParameter("stockCode", "1234");
		
		int result = query.executeUpdate();
		
	}
	
}
