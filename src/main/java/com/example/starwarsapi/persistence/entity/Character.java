package com.example.starwarsapi.persistence.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="character")
public class Character extends BaseEntity {
    private String name;
    private int height;
    private int mass;

    @ManyToOne
    private Planet planet;

    @ManyToOne
    private Specie specie;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getMass() {
        return mass;
    }

    public void setMass(int mass) {
        this.mass = mass;
    }

    public Planet getPlanet() {
        return planet;
    }

    public void setPlanet(Planet homeworld) {
        this.planet = homeworld;
    }

    public Specie getSpecie() {
        return specie;
    }

    public void setSpecie(Specie specie) {
        this.specie = specie;
    }

}

