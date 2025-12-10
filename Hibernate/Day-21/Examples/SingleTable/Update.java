package com.example.singletable;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class Update {
    public static void main(String[] args) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = null;

        try {
            transaction = session.beginTransaction();

            // Update FullTimeEmployee's salary
            FullTimeEmployee employee = session.get(FullTimeEmployee.class, 1L);
            if (employee != null) {
                employee.setSalary(55000.00);
                session.update(employee);
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
