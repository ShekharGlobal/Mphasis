package com.example.granuality;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {

	private static final SessionFactory sessionFactory;

	static {
		try {
			sessionFactory = new Configuration().configure().buildSessionFactory();
		} catch (Exception e) {
			throw new RuntimeException("Failed to build SessionFactory", e);
		}
	}

	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}
}
