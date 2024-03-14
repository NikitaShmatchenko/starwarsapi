package com.example.starwarsapi.persistence.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "planet")
public class Planet extends CelestialBody {

    private String climate;
    private String terrain;

    @Override
    public void describe() {
        System.out.println("The description of a planet.");
    }

    public void calculateGravity() {
        System.out.println("Calculate Gravity for the planet.");
    }

    public String getClimate() {
        return climate;
    }

    public void setClimate(String climate) {
        this.climate = climate;
    }

    public String getTerrain() {
        return terrain;
    }

    public void setTerrain(String terrain) {
        this.terrain = terrain;
    }
}

