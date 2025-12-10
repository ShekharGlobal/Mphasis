package com.example.joinedtable;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "full_time_employee")
public class FullTimeEmployee extends Employee {

    @Column(name = "salary")
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
