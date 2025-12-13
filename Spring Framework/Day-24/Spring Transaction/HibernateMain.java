package com.coforge.springtx;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class HibernateMain {

    public static void main(String[] args) {
        
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(HibernateConfig.class);
           
            UserHibernateDao userDao = context.getBean(UserHibernateDao.class);

            try {
             
                Usertx user1 = new Usertx();
                user1.setUsername("Monika");
                user1.setEmail("monika@gmail.com");
                userDao.saveUser(user1);

                // Simulate error (will cause rollback)
                Usertx user2 = new Usertx();
                user2.setUsername("error"); // Will trigger rollback
                user2.setEmail("error@gmail.com");
                userDao.saveUser(user2);

            } catch (Exception e) {
                System.out.println("Transaction Rolled Back: " + e.getMessage());
            }
        }
    }

