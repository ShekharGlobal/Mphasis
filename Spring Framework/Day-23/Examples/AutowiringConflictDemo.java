package com.example.auto;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AutowiringConflictDemo {
    public static void main(String[] args) {
        // LOAD AppConfig so component scanning picks up @Service and @Component beans
        ConfigurableApplicationContext context = 
                new AnnotationConfigApplicationContext(AppConfig.class);

        // now CarService is a bean and can be fetched
        CarService carService = context.getBean(CarService.class);
        carService.startCar();

        context.close();
    }
}
