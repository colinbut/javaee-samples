/**
 * 
 */
package com.mycompany.jpa.hibernate.logging.slf4j.logback;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.junit.Test;

import com.mycompany.jpa.hibernate.logging.slf4j.logback.persistence.HibernateUtil;




/**
 * @author colin
 *
 */
public class DBUserTest {

	@Test
	public void testGettingDataFromHibernate() {
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		
		session.beginTransaction();
		
		Query query = session.createQuery("from DBUser");
		
		@SuppressWarnings("unchecked")
		List<DBUser> dbUsers = query.list();
		for(DBUser dbUser : dbUsers ) {
			System.out.println(dbUser);
		}
		
		session.getTransaction().commit();
		
		HibernateUtil.shutdown();
		
	}
}
