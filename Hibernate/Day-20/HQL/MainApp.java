package com.example.hql;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public class MainApp {

	public static void main(String[] args) {

		// Create SessionFactory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class)
				.buildSessionFactory();

		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();

		// Insert data
		session.save(new Student(1, "Rahul", 20));
		session.save(new Student(2, "Amit", 22));
		session.save(new Student(3, "Sneha", 18));

		tx.commit();

		// ---------------- HQL QUERIES ----------------

		session.beginTransaction();

		// 1. Fetch all students
		Query<Student> query1 = session.createQuery("FROM Student", Student.class);
		List<Student> students = query1.list();

		for (Student s : students) {
			System.out.println(s.getId() + " " + s.getName() + " " + s.getAge());
		}

		// 2. Fetch students with age > 18
		Query<Student> query2 = session.createQuery("FROM Student WHERE age > :age", Student.class);
		query2.setParameter("age", 18);

		List<Student> result = query2.list();
		System.out.println("Students age > 18: " + result.size());

		// 3. Update using HQL
		Query<?> updateQuery = session.createQuery("UPDATE Student SET age = 21 WHERE id = 1");
		updateQuery.executeUpdate();

		// 4. Delete using HQL
		Query<?> deleteQuery = session.createQuery("DELETE FROM Student WHERE id = 3");
		deleteQuery.executeUpdate();

		session.getTransaction().commit();

		session.close();
		factory.close();
	}
}
