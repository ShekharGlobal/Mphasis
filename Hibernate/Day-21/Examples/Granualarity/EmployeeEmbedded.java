package com.example.granuality;

//@Embeddable, @Embedded (Address + EmployeeEmbedded)
import jakarta.persistence.*;

@Entity
@Table(name = "employee_embedded")
public class EmployeeEmbedded {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String name;

	@Embedded
	private Address address;

	// Getters/setters

	@Override
	public String toString() {
		return "EmployeeEmbedded{id=" + id + ", name='" + name + "', address=" + address + "}";
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

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}
}
