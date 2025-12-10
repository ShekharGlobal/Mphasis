package com.example.granuality;

import org.hibernate.Session;
import org.hibernate.Transaction;
import java.time.Instant;
import java.util.List;

public class Main {
	public static void main(String[] args) {

		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = session.beginTransaction();

		System.out.println("\n=== COARSE GRANULARITY ===");
		EmployeeCoarse emp = new EmployeeCoarse();
		emp.setName("Vijay");
		emp.setDepartment("Engineering");
		session.persist(emp);

		System.out.println("\n=== MEDIUM GRANULARITY (Embedded) ===");
		EmployeeEmbedded e2 = new EmployeeEmbedded();
		e2.setName("Venkat");
		Address addr = new Address();
		addr.setStreet("100 Main St");
		addr.setCity("Metropolis");
		addr.setZip("11111");
		e2.setAddress(addr);
		session.persist(e2);

		System.out.println("\n=== FINE GRANULARITY (Field Level) ===");
		Document doc = new Document();
		doc.setTitle("Hibernate Quickstart");
		doc.setContent("Some long LOB content...");
		doc.setCreatedOn(Instant.now());
		session.persist(doc);

		System.out.println("\n=== VERY FINE GRANULARITY (ElementCollection) ===");
		Student s1 = new Student();
		s1.setName("Carol");
		s1.setSkills(List.of("Java", "Hibernate", "SQL"));
		session.persist(s1);

		tx.commit();

		session.close();
		HibernateUtil.getSessionFactory().close();

		System.out.println("\n*** DONE ***");
	}
}
