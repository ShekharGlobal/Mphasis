package com.example.joinedtable;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "part_time_employee")
public class PartTimeEmployee extends Employee {

    @Column(name = "hourly_rate")
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
