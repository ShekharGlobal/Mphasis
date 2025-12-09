package com.example.hql;

import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;

public class DBOperations {

    public static void main(String args[]) {
        // Get operation from the user via Scanner
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter operation (insert, fetch, update, delete, fetchByCriteria, fetchByNamedQuery): ");
        String operation = scanner.nextLine();

        DBOperations db = new DBOperations();
        // Call the appropriate method based on user input
        switch (operation.toLowerCase()) {
            case "insert":
                db.insertItems();
                break;
            case "fetch":
                db.fetchItems();
                break;
            case "update":
                db.updateItemName();
                break;
            case "delete":
                db.deleteItem();
                break;
            case "fetchbycriteria":
                db.fetchItemsByCriteria();
                break;
            case "fetchbynamedquery":
                db.fetchItemsByNamedQuery();
                break;
            default:
                System.out.println("Invalid operation.");
        }
        scanner.close();
    }

    // Insert items into the database
    public void insertItems() {
        Configuration cfg = new Configuration().configure("hibernate.cfg.xml");
        SessionFactory sf = cfg.buildSessionFactory();
        try (Session sess = sf.openSession()) {
            Transaction tx = sess.beginTransaction();
            Item i = new Item();
            i.setItemName("TV");
            i.setPrice(25000.0);
            sess.save(i);
            tx.commit();
            System.out.println("Item inserted successfully.");
        }
    }

    // Fetch items by id using HQL
    public void fetchItems() {
        Configuration cfg = new Configuration().configure("hibernate.cfg.xml");
        SessionFactory sf = cfg.buildSessionFactory();
        try (Session sess = sf.openSession()) {
            Query<Item> q = sess.createQuery("from Item where id=:id", Item.class);
            q.setParameter("id", 1);
            List<Item> items = q.list();
            System.out.println("Fetched Items: " + items);
        }
    }

    // Update item name using HQL
    public void updateItemName() {
        Configuration cfg = new Configuration().configure("hibernate.cfg.xml");
        SessionFactory sf = cfg.buildSessionFactory();
        try (Session sess = sf.openSession()) {
            Transaction tx = sess.beginTransaction();
            Query q = sess.createQuery("update Item set itemName=:name where id=:id");
            q.setParameter("name", "Washing Machine");
            q.setParameter("id", 1);
            int rowsUpdated = q.executeUpdate();
            tx.commit();
            System.out.println("Rows Updated: " + rowsUpdated);
        }
    }

    // Delete item by id using HQL
    public void deleteItem() {
        Configuration cfg = new Configuration().configure("hibernate.cfg.xml");
        SessionFactory sf = cfg.buildSessionFactory();
        try (Session sess = sf.openSession()) {
            Transaction tx = sess.beginTransaction();
            Query q = sess.createQuery("delete from Item where id=:id");
            q.setParameter("id", 1);
            int rowsDeleted = q.executeUpdate();
            tx.commit();
            System.out.println("Rows Deleted: " + rowsDeleted);
        }
    }

    // Fetch items by criteria using CriteriaBuilder (Hibernate 6+)
    public void fetchItemsByCriteria() {
        Configuration cfg = new Configuration().configure("hibernate.cfg.xml");
        SessionFactory sf = cfg.buildSessionFactory();
        try (Session sess = sf.openSession()) {
            CriteriaBuilder cb = sess.getCriteriaBuilder();
            CriteriaQuery<Item> cq = cb.createQuery(Item.class);
            Root<Item> root = cq.from(Item.class);
            cq.select(root).where(cb.equal(root.get("id"), 2));
            List<Item> items = sess.createQuery(cq).getResultList();
            System.out.println("Items: " + items);
        }
    }

    // Fetch items using Named Query
    public void fetchItemsByNamedQuery() {
        Configuration cfg = new Configuration().configure("hibernate.cfg.xml");
        SessionFactory sf = cfg.buildSessionFactory();
        try (Session sess = sf.openSession()) {
            Query<Item> q = sess.createNamedQuery("fetchItemsById", Item.class);
            q.setParameter("id", 2);
            List<Item> items = q.list();
            System.out.println("Items: " + items);
        }
    }
}
