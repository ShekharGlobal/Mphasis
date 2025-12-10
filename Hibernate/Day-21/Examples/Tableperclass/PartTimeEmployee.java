package com.example.tableperclass;
import jakarta.persistence.Entity;
@Entity
public class PartTimeEmployee extends Employee {

    private double hourlyRate;

    // Default constructor
    public PartTimeEmployee() {
        super();
    }

    // Constructor with parameters
    public PartTimeEmployee(Long id, String name, double hourlyRate) {
        super(id, name);
        this.hourlyRate = hourlyRate;
    }

    // Getters and setters
    public double getHourlyRate() {
        return hourlyRate;
    }

    public void setHourlyRate(double hourlyRate) {
        this.hourlyRate = hourlyRate;
    }
}
