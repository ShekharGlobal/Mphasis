package com.example.firstlevel;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class FirstLevelCacheDemo {

	public static void main(String[] args) {

		SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();
		Session session = factory.openSession();
        Transaction tx1 = session.beginTransaction();
		Student std = new Student();
		std.setId(1);
		std.setName("Venkat");

		session.save(std);// persistant object
		tx1.commit();
		session.close();
		System.out.println("Student inserted.");

		// --- Demonstrate First-Level Cache: two gets inside the same session ---
		Session session2 = factory.openSession();
		Transaction tx = session2.beginTransaction();

		System.out.println("\nFirst fetch:");
		// This will produce an SQL SELECT (if not already in session)
		Student s1 = session2.get(Student.class, 1);
		System.out.println("Fetched: " + s1);

		System.out.println("\nSecond fetch:");
		// This will NOT produce another SQL SELECT — it comes from the session (L1)
		// cache
		Student s2 = session2.get(Student.class, 1);
		System.out.println("Fetched: " + s2);

		tx.commit();
		session2.close();
		
		factory.close();

	}
}
