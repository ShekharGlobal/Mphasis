package com.example.web;

import java.io.IOException;

import org.hibernate.Session;
import org.hibernate.Transaction;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/crudorm2")
public class crudorm2 extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Session session = null;
        Transaction transaction = null;

        try {
            // Open Hibernate session
            session = HibernateUtil.getSessionFactory().openSession();
            transaction = session.beginTransaction();

            // Create and save an employee record
            Employees e1 = new Employees();
            e1.setId(101);
            e1.setFirstName("Vijay");
            e1.setLastName("Kumar");
            session.save(e1);

            // Commit the transaction
            transaction.commit();

            // Output success message
            response.getWriter().println("Record Inserted Successfully");

        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            response.getWriter().println("Error: " + e.getMessage());
        } finally {
            if (session != null) session.close();
        }
    }

    @Override
    public void destroy() {
        HibernateUtil.closeSessionFactory();
        super.destroy();
    }
}
