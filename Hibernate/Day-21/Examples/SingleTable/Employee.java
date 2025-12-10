package com.example.singletable;
import jakarta.persistence.DiscriminatorColumn;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "EMP_TYPE")
public abstract class Employee {

/**
 * In Hibernate, the @DiscriminatorColumn annotation is used in conjunction with the @DiscriminatorValue annotation to support table-per-class hierarchy inheritance mapping. This mapping strategy allows you to store data for an entire class hierarchy in a single table, using a discriminator column to differentiate between the different types in the hierarchy.
Superclass Setup: Define a base class and annotate it with @Inheritance to specify the inheritance strategy. In the case of a single table strategy, use @Inheritance(strategy = InheritanceType.SINGLE_TABLE).

Discriminator Column: Annotate the base class with @DiscriminatorColumn to specify the column in the table that will be used to distinguish between different subclasses.

Subclass Setup: Define subclasses and annotate them with @DiscriminatorValue to specify the value that will be used in the discriminator column for that subclass.
 * 
 */
	
    @Id
    private Long id;
    private String name;

    // Default constructor
    public Employee() {
    }

    // Constructor with parameters
    public Employee(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    // Getters and setters
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
}

