package com.example.singletable;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class Main {
    public static void main(String[] args) {
        // Obtain a session from the session factory
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = null;

        try {
            // Start a transaction
            transaction = session.beginTransaction();

            // Create and save FullTimeEmployee
            FullTimeEmployee fullTimeEmployee = new FullTimeEmployee(1L, "Anurag Singh", 50000.00);
            session.save(fullTimeEmployee);

            // Create and save PartTimeEmployee
            PartTimeEmployee partTimeEmployee = new PartTimeEmployee(2L, "Arati Kapoor", 20.00);
            session.save(partTimeEmployee);

            // Commit the transaction
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
