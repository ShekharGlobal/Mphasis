package com.example.jdbctemplate;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

    public static void main(String[] args) {
       ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        
        //ApplicationContext context = new ClassPathXmlApplicationContext("springjdbc.xml");
        UserDao userDao = context.getBean(UserDao.class);

        // Create users
        userDao.createUser("Ravi Reddy");
        userDao.createUser("Priya Lakshmi");

        // Retrieve users
        List<String> users = userDao.getUsers();
        System.out.println("Users:");
        for (String user : users) {
            System.out.println(user);
        }
        
     // Update a user
       // userDao.updateUser(1, "Sanjay Kumar");

        // Retrieve users again
        System.out.println("Users after update:");
        users = userDao.getUsers();
        for (String user : users) {
            System.out.println(user);
        }

        // Delete a user
      //  userDao.deleteUser(2);

        // Retrieve users again
        System.out.println("Users after deletion:");
        users = userDao.getUsers();
        for (String user : users) {
            System.out.println(user);
        }

        
    }
}
