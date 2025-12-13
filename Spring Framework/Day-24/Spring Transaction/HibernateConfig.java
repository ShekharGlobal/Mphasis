package com.coforge.springtx;

import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import java.util.Properties;

@Configuration
@EnableTransactionManagement
@ComponentScan(basePackages = "com.coforge.springtx") 
public class HibernateConfig {

	  @Bean
	    public DataSource dataSource() {
	        DriverManagerDataSource dataSource = new DriverManagerDataSource();
	        dataSource.setDriverClassName("org.postgresql.Driver"); 
	        dataSource.setUrl("jdbc:postgresql://localhost:5432/mydb"); 
	        dataSource.setUsername("postgres"); 
	        dataSource.setPassword("root"); 
	        return dataSource;
	    }

	   
	    @Bean
	    public LocalSessionFactoryBean sessionFactory() {
	        LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
	        sessionFactory.setDataSource(dataSource());
	        sessionFactory.setPackagesToScan("com.coforge.springtx"); // Scan your entity package
	        Properties hibernateProperties = new Properties();
	        hibernateProperties.put("hibernate.dialect", "org.hibernate.dialect.PostgreSQLDialect"); 
	        hibernateProperties.put("hibernate.hbm2ddl.auto", "update"); 
	        hibernateProperties.put("hibernate.show_sql", "true"); 
	        sessionFactory.setHibernateProperties(hibernateProperties);
	        return sessionFactory;
	    }


    @Bean
    public HibernateTransactionManager transactionManager() {
        return new HibernateTransactionManager(sessionFactory().getObject());
    }
}
