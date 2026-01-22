package com.examples.hql2;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "studenthql2")
public class Student {

	@Id
	private int id;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getRoll() {
		return roll;
	}

	public void setRoll(int roll) {
		this.roll = roll;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getMarks() {
		return marks;
	}

	public void setMarks(int marks) {
		this.marks = marks;
	}

	private int roll;
	private String name;
	private int marks;

	public Student() {
	}

	public Student(int id, int roll, String name, int marks) {
		this.id = id;
		this.roll = roll;
		this.name = name;
		this.marks = marks;
	}

	// getters & setters
}
