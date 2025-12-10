package com.example.granuality;

import jakarta.persistence.*;

//COARSE GRANULARITY – Entire Entity
@Entity
@Table(name = "employee_coarse")
public class EmployeeCoarse {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String name;
	private String department;

	// Getters/setters/toString

	@Override
	public String toString() {
		return "EmployeeCoarse{id=" + id + ", name='" + name + "', department='" + department + "'}";
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}
}
