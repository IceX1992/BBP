package org.unasat.hibernate.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class HibernateUtil {
	
	private static final SessionFactory sessionFactory;	   
	
	static {
		try {
			// Create the SessionFactory from hibernate.cfg.xml
			System.out.println("Before session factory build");
			sessionFactory = new Configuration().configure().buildSessionFactory();
		/*	Configuration configuration = new Configuration().configure(HibernateUtil.class.getResource("/hibernate.cfg.xml"));
            StandardServiceRegistryBuilder serviceRegistryBuilder = new StandardServiceRegistryBuilder();
            serviceRegistryBuilder.applySettings(configuration.getProperties());
            ServiceRegistry serviceRegistry = serviceRegistryBuilder.build();
            
            sessionFactory = configuration.buildSessionFactory(serviceRegistry);*/
            
			System.out.println("After session factory build");
		} catch (Exception ex) {
			// Make sure you log the exception, as it might be swallowed
			System.err.println("Initial SessionFactory creation failed." + ex);
			throw new ExceptionInInitializerError(ex);
		}
	}
	
	public static SessionFactory getSessionFactory() {				
		return sessionFactory;
	}	
	  public static Session openSession() {
	        return sessionFactory.openSession();
	    }
}
