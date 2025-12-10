package com.example.singletable;
import org.hibernate.Session;

public class Fetch {
    public static void main(String[] args) {
        Session session = HibernateUtil.getSessionFactory().openSession();

        try {
            // Retrieve a FullTimeEmployee by ID
            FullTimeEmployee employee = session.get(FullTimeEmployee.class, 1L);
            if (employee != null) {
                System.out.println("FullTimeEmployee: " + employee.getName() + ", Salary: " + employee.getSalary());
            }

            // Retrieve a PartTimeEmployee by ID
            PartTimeEmployee partTimeEmployee = session.get(PartTimeEmployee.class, 2L);
            if (partTimeEmployee != null) {
                System.out.println("PartTimeEmployee: " + partTimeEmployee.getName() + ", Hourly Rate: " + partTimeEmployee.getHourlyRate());
            }
        } finally {
            session.close();
        }
    }
}
