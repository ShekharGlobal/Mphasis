package com.example.auto;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("com.example.auto")  // Detect CarService (@Service)
public class AppConfig {
}
