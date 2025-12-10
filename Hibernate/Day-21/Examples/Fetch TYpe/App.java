package com.example.fetchtype;

import java.util.Collection;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class App {
    public static void main(String[] args) {
        // Create SessionFactory
        SessionFactory sessionFactory = new Configuration()
                .configure() // Loads hibernate.cfg.xml
                .addAnnotatedClass(Laptop.class)
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();

        // Open session
        Session session = sessionFactory.openSession();

        try {
            session.beginTransaction();

            // Create and save a Student
            Student student = new Student();
            student.setSname("Naveen Kumar");
            session.save(student);

            // Create and save Laptops associated with the Student
            Laptop laptop1 = new Laptop();
            laptop1.setBrand("Dell");
            laptop1.setPrice(80000);
            laptop1.setStudent(student); // Associate with Student

            Laptop laptop2 = new Laptop();
            laptop2.setBrand("HP");
            laptop2.setPrice(120000);
            laptop2.setStudent(student); // Associate with Student

            // Save laptops
            session.save(laptop1);
            session.save(laptop2);

            // Commit the transaction
            session.getTransaction().commit();
            System.out.println("Records added successfully!");

            // Start a new session for fetching
            session = sessionFactory.openSession();
            session.beginTransaction();

            // Fetch a Student by ID
            Student fetchedStudent = session.get(Student.class, student.getSid());
            System.out.println("Student Name: " + fetchedStudent.getSname());

            // Access lazyLaptops (Lazy Fetching - additional query is executed)
            System.out.println("\nAccessing Lazy Laptops (triggers SELECT query):");
            Collection<Laptop> lazyLaptops = fetchedStudent.getLazyLaptops();
            for (Laptop laptop : lazyLaptops) {
                System.out.println("Laptop ID: " + laptop.getLid());
                System.out.println("Laptop Brand: " + laptop.getBrand());
                System.out.println("Laptop Price: " + laptop.getPrice());
            }

            // Access eagerLaptops (Eager Fetching - data already loaded)
            System.out.println("\nAccessing Eager Laptops (data already loaded):");
            Collection<Laptop> eagerLaptops = fetchedStudent.getEagerLaptops();
            for (Laptop laptop : eagerLaptops) {
                System.out.println("Laptop ID: " + laptop.getLid());
                System.out.println("Laptop Brand: " + laptop.getBrand());
                System.out.println("Laptop Price: " + laptop.getPrice());
            }

            // Commit the transaction
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
            sessionFactory.close();
        }
    }
}
