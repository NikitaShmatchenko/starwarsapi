package com.example.starwarsapi.persistence.entity;


import jakarta.persistence.MappedSuperclass;

@MappedSuperclass
public class CelestialBody extends BaseEntity {
    private String name;
    private int diameter;

    public void describe() {
        System.out.println("The description of a celestial body.");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public int getDiameter() {
        return diameter;
    }

    public void setDiameter(int diameter) {
        this.diameter = diameter;
    }
}
