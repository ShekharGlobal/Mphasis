package com.example.auto;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class CarService {

	//@Autowired
    private final Engine engine;

    // Constructor injection with Qualifier to resolve multiple Engine beans
    public CarService(@Qualifier("dieselEngine") Engine engine) {
        this.engine = engine;
    }

    public void startCar() {
        System.out.println("CarService: starting car...");
        engine.start();
    }
}
