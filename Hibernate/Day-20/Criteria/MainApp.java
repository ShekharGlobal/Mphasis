package com.example.criteria;


import java.util.Arrays;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;



public class MainApp {

    public static void main(String[] args) {

        SessionFactory factory = new Configuration()
                .configure()
                .addAnnotatedClass(Employee.class)
                .buildSessionFactory();

        Session session = factory.openSession();
        Transaction tx = session.beginTransaction();

        // Sample data
        session.save(new Employee(1, "Rahul", 30000));
        session.save(new Employee(2, "Amit", 45000));
        session.save(new Employee(3, "Sneha", 25000));
        session.save(new Employee(4, "Rohit", 60000));
        session.save(new Employee(5, "Anita", 40000));

        tx.commit();

        session.beginTransaction();

        CriteriaBuilder cb = session.getCriteriaBuilder();

        // ------------------ 1. EQUAL ------------------
        CriteriaQuery<Employee> cq1 = cb.createQuery(Employee.class);
        Root<Employee> r1 = cq1.from(Employee.class);

        cq1.select(r1).where(cb.equal(r1.get("name"), "Rahul"));

        List<Employee> result1 = session.createQuery(cq1).getResultList();
        System.out.println("\nEmployee name = Rahul:");
        result1.forEach(e -> System.out.println(e.getName()));

        // ------------------ 2. LIKE ------------------
        CriteriaQuery<Employee> cq2 = cb.createQuery(Employee.class);
        Root<Employee> r2 = cq2.from(Employee.class);

        cq2.select(r2).where(cb.like(r2.get("name"), "R%"));

        System.out.println("\nEmployees starting with R:");
        session.createQuery(cq2).getResultList()
                .forEach(e -> System.out.println(e.getName()));

        // ------------------ 3. BETWEEN ------------------
        CriteriaQuery<Employee> cq3 = cb.createQuery(Employee.class);
        Root<Employee> r3 = cq3.from(Employee.class);

        cq3.select(r3)
           .where(cb.between(r3.get("salary"), 30000.0, 50000.0));

        System.out.println("\nSalary between 30k and 50k:");
        session.createQuery(cq3).getResultList()
                .forEach(e -> System.out.println(e.getName()));

        // ------------------ 4. IN ------------------
        CriteriaQuery<Employee> cq4 = cb.createQuery(Employee.class);
        Root<Employee> r4 = cq4.from(Employee.class);

        cq4.select(r4)
           .where(r4.get("name").in(Arrays.asList("Amit", "Anita")));

        System.out.println("\nEmployees IN (Amit, Anita):");
        session.createQuery(cq4).getResultList()
                .forEach(e -> System.out.println(e.getName()));

        // ------------------ 5. AND ------------------
        CriteriaQuery<Employee> cq5 = cb.createQuery(Employee.class);
        Root<Employee> r5 = cq5.from(Employee.class);

        cq5.select(r5).where(
                cb.and(
                    cb.gt(r5.get("salary"), 30000),
                    cb.like(r5.get("name"), "A%")
                )
        );

        System.out.println("\nSalary > 30000 AND name starts with A:");
        session.createQuery(cq5).getResultList()
                .forEach(e -> System.out.println(e.getName()));

        // ------------------ 6. OR ------------------
        CriteriaQuery<Employee> cq6 = cb.createQuery(Employee.class);
        Root<Employee> r6 = cq6.from(Employee.class);

        cq6.select(r6).where(
                cb.or(
                    cb.lt(r6.get("salary"), 30000),
                    cb.gt(r6.get("salary"), 55000)
                )
        );

        System.out.println("\nSalary < 30000 OR salary > 55000:");
        session.createQuery(cq6).getResultList()
                .forEach(e -> System.out.println(e.getName()));

        // ------------------ 7. COUNT ------------------
        CriteriaQuery<Long> countQuery = cb.createQuery(Long.class);
        Root<Employee> countRoot = countQuery.from(Employee.class);

        countQuery.select(cb.count(countRoot));
        Long total = session.createQuery(countQuery).getSingleResult();
        System.out.println("\nTotal Employees: " + total);

        // ------------------ 8. MAX ------------------
        CriteriaQuery<Double> maxQuery = cb.createQuery(Double.class);
        Root<Employee> maxRoot = maxQuery.from(Employee.class);

        maxQuery.select(cb.max(maxRoot.get("salary")));
        Double maxSalary = session.createQuery(maxQuery).getSingleResult();
        System.out.println("\nMax Salary: " + maxSalary);

        // ------------------ 9. DISTINCT ------------------
        CriteriaQuery<String> distinctQuery = cb.createQuery(String.class);
        Root<Employee> dRoot = distinctQuery.from(Employee.class);

        distinctQuery.select(dRoot.get("name")).distinct(true);

        System.out.println("\nDistinct Employee Names:");
        session.createQuery(distinctQuery).getResultList()
                .forEach(System.out::println);

        session.getTransaction().commit();
        session.close();
        factory.close();
    }
}
