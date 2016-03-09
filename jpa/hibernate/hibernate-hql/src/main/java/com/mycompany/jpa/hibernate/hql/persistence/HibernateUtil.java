/**
 * 
 */
package com.mycompany.jpa.hibernate.hql.persistence;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

/**
 * @author colin
 *
 */
public class HibernateUtil {

	private static SessionFactory sessionFactory = createSessionFactory();
	
	
	private static SessionFactory createSessionFactory() {
	
		try {
			
			Configuration configuration = new Configuration();
			configuration.configure();
			
			ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
													.applySettings(configuration.getProperties()).build();
			
			sessionFactory = configuration.buildSessionFactory(serviceRegistry);
		}
		catch(Throwable ex) {
			throw new ExceptionInInitializerError(ex);
		}
		
		return sessionFactory;
	}
			
	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	
	public static void shutdown() {
		HibernateUtil.getSessionFactory().close();
	}
}
