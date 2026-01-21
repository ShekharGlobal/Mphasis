package com.example.bi.manytomany;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class HibernateExample {
    public static void main(String[] args) {
        // Create SessionFactory
        Configuration configuration = new Configuration().configure("hibernate.cfg.xml");
        SessionFactory sessionFactory = configuration.buildSessionFactory();

        // Open a session
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        // Create employees
        Employee employee1 = new Employee("Vishal");
        Employee employee2 = new Employee("Jagrati");

        // Create projects
        Project project1 = new Project("JPMC");
        Project project2 = new Project("Charles Shop");

        // Establish many-to-many relationships
        employee1.addProject(project1);
        employee1.addProject(project2);

        employee2.addProject(project1);
        //employee2.addProject(project2);

        // Persist data
        session.save(employee1);
        session.save(employee2);

        // Commit the transaction
        transaction.commit();

		/*
		 * // Fetch and display details Employee foundEmployee =
		 * session.get(Employee.class, employee1.getId());
		 * System.out.println("Employee: " + foundEmployee.getName()); for (Project
		 * project : foundEmployee.getProjects()) {
		 * System.out.println("Assigned Project: " + project.getName()); }
		 * 
		 * Project foundProject = session.get(Project.class, project1.getId());
		 * System.out.println("Project: " + foundProject.getName()); for (Employee emp :
		 * foundProject.getEmployees()) { System.out.println("Assigned Employee: " +
		 * emp.getName()); }
		 */
        // Close session and factory
        session.close();
        sessionFactory.close();
    }
}
