package com.example.tableperclass;
import jakarta.persistence.Entity;

@Entity
public class FullTimeEmployee extends Employee {

    private double salary;

    // Default constructor
    public FullTimeEmployee() {
        super();
    }

    // Constructor with parameters
    public FullTimeEmployee(Long id, String name, double salary) {
        super(id, name);
        this.salary = salary;
    }

    // Getters and setters
    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
}
