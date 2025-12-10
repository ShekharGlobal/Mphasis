package com.example.joinedtable;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class Main {
    public static void main(String[] args) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = null;

        try {
            transaction = session.beginTransaction();

            // Create and save FullTimeEmployee
            FullTimeEmployee fullTimeEmployee = new FullTimeEmployee(1L, "Lakshmi", 50000.00);
            session.save(fullTimeEmployee);

            // Create and save PartTimeEmployee
            PartTimeEmployee partTimeEmployee = new PartTimeEmployee(2L, "Venkat", 20.00);
            session.save(partTimeEmployee);

            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
    }
}
