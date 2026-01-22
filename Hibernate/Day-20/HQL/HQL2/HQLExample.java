package com.examples.hql2;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public class HQLExample {

	public static void main(String[] args) {

		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class)
				.buildSessionFactory();

		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();

		// -------------------- INSERT DATA --------------------
		session.save(new Student(1, 101, "Rahul", 85));
		session.save(new Student(2, 102, "Amit", 72));
		session.save(new Student(3, 103, "Sneha", 90));
		session.save(new Student(4, 104, "Anita", 65));
		session.save(new Student(5, 105, "Rohit", 78));
		session.save(new Student(6, 106, "Neha", 88));

		tx.commit();

		session.beginTransaction();

		// -------------------- FROM --------------------
		Query<Student> q1 = session.createQuery("FROM Student", Student.class);
		System.out.println("\nAll Students:");
		q1.list().forEach(s -> System.out.println(s.getRoll() + " " + s.getName() + " " + s.getMarks()));

		// -------------------- SELECT --------------------
		Query<String> q2 = session.createQuery("SELECT S.name FROM Student S", String.class);
		System.out.println("\nStudent Names:");
		q2.list().forEach(System.out::println);

		// -------------------- WHERE --------------------
		Query<Student> q3 = session.createQuery("FROM Student S WHERE S.marks > 80", Student.class);
		System.out.println("\nStudents with marks > 80:");
		q3.list().forEach(s -> System.out.println(s.getName()));

		// -------------------- ORDER BY --------------------
		Query<Student> q4 = session.createQuery("FROM Student S ORDER BY S.marks DESC", Student.class);
		System.out.println("\nStudents Ordered by Marks:");
		q4.list().forEach(s -> System.out.println(s.getName() + " - " + s.getMarks()));

		// -------------------- UPDATE --------------------
		Query<?> q5 = session.createQuery("UPDATE Student SET marks = 95 WHERE roll = 103");
		int updated = q5.executeUpdate();
		System.out.println("\nRows Updated: " + updated);

		// -------------------- DELETE --------------------
		Query<?> q6 = session.createQuery("DELETE FROM Student WHERE roll = 104");
		int deleted = q6.executeUpdate();
		System.out.println("Rows Deleted: " + deleted);

		// -------------------- PAGINATION --------------------
		Query<Student> q7 = session.createQuery("FROM Student", Student.class);
		q7.setFirstResult(2);
		q7.setMaxResults(3);
		System.out.println("\nPaginated Students:");
		q7.list().forEach(s -> System.out.println(s.getName()));

		// -------------------- AGGREGATE FUNCTIONS --------------------

		// MIN
		Integer minMarks = session.createQuery("SELECT MIN(marks) FROM Student", Integer.class).uniqueResult();
		System.out.println("\nMinimum Marks: " + minMarks);

		// MAX
		Integer maxMarks = session.createQuery("SELECT MAX(marks) FROM Student", Integer.class).uniqueResult();
		System.out.println("Maximum Marks: " + maxMarks);

		// SUM
		Long sumMarks = session.createQuery("SELECT SUM(marks) FROM Student", Long.class).uniqueResult();
		System.out.println("Total Marks: " + sumMarks);

		// AVG
		Double avgMarks = session.createQuery("SELECT AVG(marks) FROM Student", Double.class).uniqueResult();
		System.out.println("Average Marks: " + avgMarks);

		// COUNT
		Long count = session.createQuery("SELECT COUNT(id) FROM Student", Long.class).uniqueResult();
		System.out.println("Total Students: " + count);

		session.getTransaction().commit();
		session.close();
		factory.close();
	}
}
