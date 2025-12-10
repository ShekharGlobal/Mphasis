package com.example.singletable;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class Delete {
    public static void main(String[] args) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = null;

        try {
            transaction = session.beginTransaction();

            // Delete PartTimeEmployee by ID
            PartTimeEmployee partTimeEmployee = session.get(PartTimeEmployee.class, 2L);
            if (partTimeEmployee != null) {
                session.delete(partTimeEmployee);
            }

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
