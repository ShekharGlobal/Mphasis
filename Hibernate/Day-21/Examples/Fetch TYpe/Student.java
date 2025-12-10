package com.example.fetchtype;

import java.util.ArrayList;
import java.util.Collection;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int sid;

    private String sname;

    // One-to-Many with Lazy Fetching
    @OneToMany(mappedBy = "student") // Lazy fetch is the default
    private Collection<Laptop> lazyLaptops = new ArrayList<>();

    // One-to-Many with Eager Fetching
    @OneToMany(mappedBy = "student", fetch = FetchType.EAGER)
    private Collection<Laptop> eagerLaptops = new ArrayList<>();

    // Getters and Setters
    public int getSid() {
        return sid;
    }

    public void setSid(int sid) {
        this.sid = sid;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public Collection<Laptop> getLazyLaptops() {
        return lazyLaptops;
    }

    public void setLazyLaptops(Collection<Laptop> lazyLaptops) {
        this.lazyLaptops = lazyLaptops;
    }

    public Collection<Laptop> getEagerLaptops() {
        return eagerLaptops;
    }

    public void setEagerLaptops(Collection<Laptop> eagerLaptops) {
        this.eagerLaptops = eagerLaptops;
    }
}
