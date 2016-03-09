/**
 * 
 */
package com.mycompany.jpa.hibernae.xml_mapping;


import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.junit.Test;

import com.mycompany.jpa.hibernate.xml_mapping.DBUser;
import com.mycompany.jpa.hibernate.xml_mapping.persistence.HibernateUtil;

/**
 * @author colin
 *
 */
public class DBUserTest {

	@Test
	public void testInsertUsingHibernate() {
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		
		session.beginTransaction();
		
		DBUser dbUser = new DBUser();
		dbUser.setUsername("ColinB");
		dbUser.setCreatedBy("Colin But");
		
		session.save(dbUser);
		
		session.getTransaction().commit();
		
		HibernateUtil.shutdown();
	}
	
	@Test
	public void testRetreivingUsingHibernate() {
		
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
